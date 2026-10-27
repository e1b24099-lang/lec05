import java.sql.*;
import java.util.ArrayList;

class Work47 {

    //指定した単価以上の商品の一覧を返すメソッド
    //  price: 単価の下限
    public static ArrayList<Goods> getGoodsList(Connection con, String price){

        //商品のリストを格納する可変長配列
        ArrayList<Goods> list = new ArrayList<Goods>();

        try {
            //SQL文を表すオブジェクトを生成する
            Statement st = con.createStatement();

            //SQL文を実行し，その結果を変数rsに関連付ける
            //（where句で単価がprice以上の商品に絞り込む）
            ResultSet rs = st.executeQuery("select * from goods where unit_price >= " + price + ";");

            //rsが指すものを1行ずつ処理する
            while (rs.next()){
                // 1行分の商品情報を設定
                Goods g =  new Goods();
                g.goods_id = rs.getInt("goods_id");
                g.goods_name = rs.getString("goods_name");
                g.unit_price = rs.getInt("unit_price");

                // 商品情報をArrayListに追加する
                list.add(g);
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }

        return list;
    }


    public static void main(String[] args){
        try {
            //データベースe1b24099に(ユーザ,パスワード)=(e1b24099,is2026)で接続する
            Connection con = DriverManager.getConnection(
                               "jdbc:postgresql://150.89.235.74:5432/e1b24099",
                               "e1b24099",
                               "is2026");

            // プログラム引数で指定した単価以上の商品の一覧を取得する
            ArrayList<Goods> list = getGoodsList(con, args[0]);

            // 取得した商品を表示する
            for (Goods g: list){
                g.print();
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
