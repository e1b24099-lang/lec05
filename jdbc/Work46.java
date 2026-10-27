import java.sql.*;
import java.util.ArrayList;

class Work46 {

    //顧客の一覧を返すメソッド
    public static ArrayList<Customer> getCustomerList(Connection con){

        //顧客のリストを格納する可変長配列
        ArrayList<Customer> list = new ArrayList<Customer>();

        try {
            //SQL文を表すオブジェクトを生成する
            Statement st = con.createStatement();

            //SQL文を実行し，その結果を変数rsに関連付ける
            ResultSet rs = st.executeQuery("select * from customer;");

            //rsが指すものを1行ずつ処理する
            while (rs.next()){
                // 1行分の顧客情報を設定
                Customer c = new Customer();
                c.cust_id = rs.getInt("cust_id");
                c.cust_name = rs.getString("cust_name");
                c.pron = rs.getString("pron");
                c.address = rs.getString("address");

                // 顧客情報をArrayListに追加する
                list.add(c);
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

            // 顧客の一覧を取得する
            ArrayList<Customer> list = getCustomerList(con);

            // 取得した顧客を表示する
            for (Customer c: list){
                c.print();
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
