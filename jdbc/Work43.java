import java.sql.*;

class Work43 {
    public static void main(String[] args){
        try {
            //データベースe1b24099に(ユーザ,パスワード)=(e1b24099,is2026)で接続する
            Connection con = DriverManager.getConnection(
                               "jdbc:postgresql://150.89.235.74:5432/e1b24099",
                               "e1b24099",
                               "is2026");

            //SQL文を表すオブジェクトを生成する
            Statement st = con.createStatement();

            //SQL文を実行し，その結果を変数rsに関連付ける
            ResultSet rs = st.executeQuery("select * from goods;");

            //rsが指すものを1行ずつ表示する
            while (rs.next()){
                //1行分のデータをGoodsのインスタンスに格納する
                Goods g =  new Goods();
                g.goods_id = rs.getInt("goods_id");
                g.goods_name = rs.getString("goods_name");
                g.unit_price = rs.getInt("unit_price");

                //1行分のデータを表示する
                g.print();
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
