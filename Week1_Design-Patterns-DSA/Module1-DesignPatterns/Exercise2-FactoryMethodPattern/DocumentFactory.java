public class DocumentFactory {

    public static Document createDocument(String type) {
        switch (type.toUpperCase()) {
            case "WORD":  return new WordDocument();
            case "PDF":   return new PdfDocument();
            case "EXCEL": return new ExcelDocument();
            default: throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}
