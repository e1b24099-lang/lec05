// 商品を表すクラス．
// goods表の1行（タップル）に対応する．
//
// 簡単のためにprivateフィールド，コンストラクタ，setter/getter等は用いていない．
// 必要であれば各自で適宜用いてください．

class Goods {
    int goods_id;       // 商品ID
    String goods_name;  // 商品名
    int unit_price;     // 単価

    void print(){
        System.out.println("(" + goods_id + ", " + goods_name + ", " + unit_price + ")");
    }
}
