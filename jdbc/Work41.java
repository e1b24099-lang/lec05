import java.sql.*;

class Work41 {
    public static void main(String[] args){
        try {
            //データベースe1b24099に(ユーザ,パスワード)=(e1b24099,is2026)で接続する
            //  第1引数: データベースサーバとデータベース名（本授業ではユーザ名と同じ）
            //  第2引数: ユーザ名
            //  第2引数: パスワード
            //
            //プログラムを書く際には自分のユーザ名（e1b.....）を使ってください．
            //パスワードは is2026 です．情報システム専門演習のときに設定した
            //パスワードではありません．
            Connection con = DriverManager.getConnection(
                               "jdbc:postgresql://150.89.235.74:5432/e1b24099",
                               "e1b24099",  
                               "is2026");

            //SQL文を表すオブジェクトを生成する
            Statement st = con.createStatement();

            //SQL文を実行し，その結果を変数rsに関連付ける
            ResultSet rs = st.executeQuery("select * from customer;");


            //rsが指すものを1行ずつ表示する
            //（次の行が読み込める間，以下を続ける）
            int no = 1;
            while (rs.next()){
                System.out.println(no + ": " +
                                   rs.getInt("cust_id") + " " +
                                   rs.getString("cust_name") + " " +
                                   rs.getString("pron") + " "
                                   + rs.getString("address") );
                no++;
                    //rs.getInt("列名")で，指定列の値を整数として取り出す．
                    //rs.getString("列名")で，指定列の値を文字列として取り出す．
            }

        }catch (SQLException e){
            //一連のデータベース操作で例外が発生したらここに飛んでくる
            e.printStackTrace();
            System.exit(1);
        }
    }
}
