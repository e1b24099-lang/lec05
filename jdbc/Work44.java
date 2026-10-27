import java.sql.*;

class Work44 {
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
            ResultSet rs = st.executeQuery("select * from customer;");

            //rsが指すものを1行ずつ表示する
            while (rs.next()){
                //1行分のデータをCustomerのインスタンスに格納する
                Customer c = new Customer();
                c.cust_id = rs.getInt("cust_id");
                c.cust_name = rs.getString("cust_name");
                c.pron = rs.getString("pron");
                c.address = rs.getString("address");

                //1行分のデータを表示する
                c.print();
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
