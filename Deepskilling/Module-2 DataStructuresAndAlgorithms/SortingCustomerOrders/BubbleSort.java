class BubbleSort {

    static void bubbleSt(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if(orders[j].totalPrice>orders[j+1].totalPrice){
                    Order temp=orders[j];
                    orders[j]=orders[j+1];
                    orders[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, "Harry", 4500),
                new Order(102, "Rahul", 1200),
                new Order(103, "Priya", 8500),
                new Order(104, "Karan", 3000)
        };
        bubbleSt(orders);
        
        System.out.println("Orders after Bubble Sort:");

        for (int i=0;i<orders.length;i++) {
            orders[i].display();
        }
    }
}