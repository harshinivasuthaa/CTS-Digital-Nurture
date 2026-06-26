class Product{
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name,int quant,double price ){
        this.productId=id;
        this.productName=name;
        this.quantity=quant;
        this.price=price;
    }
    public String toString(){
        return "Id:"+productId+", Name:"+productName+", Quantity:"+quantity+", Price"+price;
    }

}

