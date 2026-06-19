package factory;

public abstract class DocumentFactory {

    public abstract Document createDocument();

    public Document newDocumentWorkflow() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        return doc;
    }
}
