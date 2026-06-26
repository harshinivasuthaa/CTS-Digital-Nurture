import java.util.*;

class InventoryManagement{
    HashMap<Integer,Product> inventory= new HashMap<>();

    public void addProduct(Product p){
        inventory.put(p.productId,p);
        System.out.println("Product Added");
    }

    public void updateProduct(int id, int quantity, double price){
        if(inventory.containsKey(id)){
            Product p=inventory.get(id);
            p.quantity=quantity;
            p.price=price;
            System.out.println("updated successfully");
        }
        else{
            System.out.println("product not found");
        }
    }

    public void deleteProduct(int id){
        if(inventory.containsKey(id)){
        inventory.remove(id);
         System.out.println("deleted successfully");
        }
        else System.out.println("product not found");
    }

    public void display(){
        for(Product p:inventory.values()){
            System.out.println(p.toString());
        }
    }

    public static void main(String [] args){
        InventoryManagement obj= new InventoryManagement();
        obj.addProduct(new Product(107,"Laptop",13,75000));
        obj.addProduct(new Product(102,"Speaker",40,4500));
        obj.addProduct(new Product(105,"Keyboard",54,2300));

        obj.updateProduct(102,43,5200);

        System.out.println("after updation");
        obj.display();

        obj.deleteProduct(105);

        System.out.println("after deletion");
        obj.display();
        
    }
}