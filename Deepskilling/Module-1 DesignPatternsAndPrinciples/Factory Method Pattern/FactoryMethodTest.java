package factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            System.out.println("--- Using " + factory.getClass().getSimpleName() + " ---");
            factory.newDocumentWorkflow();
            System.out.println();
        }
    }
}
