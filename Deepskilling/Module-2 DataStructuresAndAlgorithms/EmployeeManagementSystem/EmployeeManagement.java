class EmployeeManagement{

    Employee[] employees;
    int size;

    EmployeeManagement(int capacity){
        employees = new Employee[capacity];
        size = 0;
    }

    void addEmployee(Employee emp){
        if (size == employees.length){
            System.out.println("Array is full!");
            return;
        }
        employees[size] = emp;
        size++;
    }
    
    void traverse(){
        for (int i = 0; i < size; i++){
            employees[i].display();
        }
    }

    Employee search(int id){
        for (int i = 0; i < size; i++){
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    void delete(int id){

        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id){
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found");
            return;
        }
        for (int i = index; i < size - 1; i++){
            employees[i] = employees[i + 1];
        }
        size--;
        System.out.println("Employee deleted successfully");
    }
}
    