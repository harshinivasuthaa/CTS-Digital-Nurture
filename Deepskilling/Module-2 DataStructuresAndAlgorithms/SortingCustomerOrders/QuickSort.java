class QuickSort{

    static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                swap(orders,i,j);
            }
        }
        swap(orders,i+1, high);
        return i + 1;
    }

    static void swap(Order[] orders, int i, int j){
            Order temp = orders[i];
            orders[i] = orders[j];
            orders[j] = temp;
    }

    static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static void main(String[] args) {

        Order[] orders = {
                new Order(101, "Harry", 4500),
                new Order(102, "Rahul", 1200),
                new Order(103, "Priya", 8500),
                new Order(104, "Karan", 3000)
        };

        quickSort(orders, 0, orders.length - 1);

        System.out.println("Orders after Quick Sort:");

        for (Order o : orders) {
            o.display();
        }
    }
}