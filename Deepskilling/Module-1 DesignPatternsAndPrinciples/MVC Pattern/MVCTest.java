package mvc;

public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("Priya Sharma", "S1024", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        System.out.println("Initial record:");
        controller.updateView();

        System.out.println("\nUpdating grade via the controller...");
        controller.setStudentGrade("A+");

        System.out.println("\nRecord after update:");
        controller.updateView();
    }
}
