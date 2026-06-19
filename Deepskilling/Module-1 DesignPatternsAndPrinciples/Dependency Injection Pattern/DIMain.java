package di;

public class DIMain {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(repository); // injected here

        Customer customer = customerService.getCustomerById(1);
        System.out.println("Found: " + customer);

        Customer missing = customerService.getCustomerById(99);
        System.out.println("Lookup for id=99 returned: " + missing);
    }
}
