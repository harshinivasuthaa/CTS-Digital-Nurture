package builder;

public class BuilderTest {
    public static void main(String[] args) {
        Computer budgetPC = new Computer.Builder("Intel i3", "8GB", "256GB SSD").build();
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB", "2TB NVMe SSD")
                .gpu("NVIDIA RTX 4080")
                .bluetooth(true)
                .wifi(true)
                .build();

        System.out.println("Budget PC: " + budgetPC);
        System.out.println("Gaming PC: " + gamingPC);
    }
}
