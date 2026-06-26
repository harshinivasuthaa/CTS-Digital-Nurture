class Emp{
    public static void main(String [] args){
        EmployeeManagement em= new EmployeeManagement(5);

        em.addEmployee(new Employee(101, "Asha", "Manager", 50000));
        em.addEmployee(new Employee(102, "Rahul", "Developer", 40000));
        em.addEmployee(new Employee(103, "Priya", "Tester", 35000));

        System.out.println("Employees:");
        em.traverse();

        System.out.println("\nSearch Result:");
        Employee e = em.search(102);
        if(e!= null) 
            e.display();

        System.out.println("\nAfter Deletion:");
        em.delete(101);
        em.traverse();
    }
}
