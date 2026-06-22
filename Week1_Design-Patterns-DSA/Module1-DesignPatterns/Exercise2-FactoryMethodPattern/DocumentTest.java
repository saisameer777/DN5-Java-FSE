public class DocumentTest {
    public static void main(String[] args) {

        // Factory creates the right object - caller doesn't use 'new'
        Document word  = DocumentFactory.createDocument("WORD");
        Document pdf   = DocumentFactory.createDocument("PDF");
        Document excel = DocumentFactory.createDocument("EXCEL");

        System.out.println("--- Word ---");
        word.open();
        word.save();
        word.close();

        System.out.println("--- PDF ---");
        pdf.open();
        pdf.save();
        pdf.close();

        System.out.println("--- Excel ---");
        excel.open();
        excel.save();
        excel.close();
    }
}
