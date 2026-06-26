public class TaskManagement{

    public static void main(String[] args){

        TaskList list = new TaskList();

        list.addTask(new Task(1, "Login Page", "Pending"));
        list.addTask(new Task(2, "Dashboard", "In Progress"));
        list.addTask(new Task(3, "Payment Module", "Completed"));

        System.out.println("Tasks:");
        list.traverse();

        System.out.println("\nSearch Result:");
        Task t = list.search(2);
        if (t != null) t.display();

        System.out.println("\nAfter Deletion:");
        list.delete(1);
        list.traverse();
    }
}