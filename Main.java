public class Main {

    public static void main(String[] args) {

        System.out.println("Insurance Claim Processing Agent Started...");

        // PDF file name (project folder lo undali)
        String filePath = "sample.pdf";

        // PDF text read
        String pdfText = PDFReader.readPDF(filePath);

        // Print output
        //System.out.println("----- PDF CONTENT START -----");
        //System.out.println(pdfText);
        FieldExtractor.extractFields(pdfText);

        //System.out.println("----- PDF CONTENT END -----");

    }
}
