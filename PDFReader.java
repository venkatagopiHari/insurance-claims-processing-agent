import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader {

    public static String readPDF(String filePath) {

        try {

            PDDocument document = Loader.loadPDF(new File(filePath));

            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            document.close();

            return text;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
