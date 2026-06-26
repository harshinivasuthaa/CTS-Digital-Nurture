
public class SearchDemo {

    static Product linearSearch(Product[] products, int targetId) {

        for (Product p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

        static void sortProducts(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
        for (int j = 0; j < products.length - 1 - i; j++) {
            if (products[j].productId > products[j + 1].productId) {

                Product temp = products[j];
                products[j] = products[j + 1];
                products[j + 1] = temp;
            }
        }
    }
    }

    static Product binarySearch(Product[] products, int targetId) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }
            if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }


    public static void main(String[] args) {

        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Mobile", "Electronics"),
                new Product(107, "Headphones", "Electronics")
        };

        int searchId = 107;

        System.out.println("Linear Search");

        Product result1 = linearSearch(products, searchId);

        if (result1 != null) {
            result1.display();
        } else {
            System.out.println("Product not found");
        }

        sortProducts(products);

        System.out.println("\nBinary Search");

        Product result2 = binarySearch(products, searchId);

        if (result2 != null) {
            result2.display();
        } else {
            System.out.println("Product not found");
        }
    }
}