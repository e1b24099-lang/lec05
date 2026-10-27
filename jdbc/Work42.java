import java.sql.*;

class Work42 {
    public static void main(String[] args){
        try {
            //データベースに接続する
            Connection con = DriverManager.getConnection(
                               "jdbc:postgresql://150.89.235.74:5432/e1b24099",
                               "e1b24099",
                               "is2026");

            //SQL文を表すオブジェクトを生成する
            Statement st = con.createStatement();

            //SQL文を実行し，その結果を変数rsに関連付ける
            ResultSet rs = st.executeQuery("select goods_id, goods_name, unit_price from goods where unit_price >= 5000 order by unit_price desc;");
                                           //単価5000円以上の商品を単価の高い順に取得する

            //rsが指すものを1行ずつ表示する
            int no = 1;
            while (rs.next()){
                System.out.println(no + ": " +
                    rs.getInt("goods_id") + " " +
                    rs.getString("goods_name") + " " +
                    rs.getInt("unit_price")
                );
                no++;
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
