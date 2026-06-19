package di;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        database.put(1, new Customer(1, "Asha Verma"));
        database.put(2, new Customer(2, "Ravi Kumar"));
    }

    @Override
    public Customer findCustomerById(int id) {
        System.out.println("CustomerRepositoryImpl: querying data store for id=" + id);
        return database.get(id);
    }
}
