public class DocumentTest {
    public static void main(String[] args) {
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
