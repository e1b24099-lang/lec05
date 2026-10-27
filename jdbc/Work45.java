import java.sql.*;
import java.util.ArrayList;

class Work45 {

    //商品の一覧を返すメソッド
    public static ArrayList<Goods> getGoodsList(Connection con){

        //商品のリストを格納する可変長配列
        ArrayList<Goods> list = new ArrayList<Goods>();

        try {
            //SQL文を表すオブジェクトを生成する
            Statement st = con.createStatement();

            //SQL文を実行し，その結果を変数rsに関連付ける
            ResultSet rs = st.executeQuery("select * from goods;");

            //rsが指すものを1行ずつ表示する
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

            // 商品の一覧を取得する
            ArrayList<Goods> list = getGoodsList(con);

            // 取得した商品を表示する
            System.out.println(list.size() + "個の商品があります");
            for (Goods g: list){
                g.print();
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
