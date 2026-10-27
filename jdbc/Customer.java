// 顧客を表すクラス．
// customer表の1行（タップル）に対応する．

class Customer {
    int cust_id;        // 顧客ID
    String cust_name;   // 顧客名
    String pron;        // 読み
    String address;     // 住所

    void print(){
        System.out.println("(" + cust_id + ", " + cust_name + ", " + pron + ", " + address + ")");
    }
}
