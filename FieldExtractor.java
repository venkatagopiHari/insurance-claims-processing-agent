import java.util.*;

public class FieldExtractor {

    public static void extractFields(String text) {

        System.out.println("\n--- PROCESSING FNOL DOCUMENT ---");

        Map<String, String> extractedFields = new HashMap<>();
        ArrayList<String> missingFields = new ArrayList<>();

        // ===========================
        // FIELD EXTRACTION (KEYWORDS BASED)
        // ===========================

        if (text.contains("POLICY NUMBER"))
            extractedFields.put("Policy Number", "Detected");
        else
            missingFields.add("Policy Number");

        if (text.contains("NAME OF INSURED"))
            extractedFields.put("Policyholder Name", "Detected");
        else
            missingFields.add("Policyholder Name");

        if (text.contains("DATE OF LOSS"))
            extractedFields.put("Incident Date", "Detected");
        else
            missingFields.add("Incident Date");

        if (text.contains("LOCATION OF LOSS"))
            extractedFields.put("Location", "Detected");
        else
            missingFields.add("Location");

        if (text.contains("DESCRIPTION OF ACCIDENT"))
            extractedFields.put("Description", "Detected");
        else
            missingFields.add("Description");

        if (text.contains("ESTIMATE AMOUNT"))
            extractedFields.put("Estimated Damage", "Detected");
        else
            missingFields.add("Estimated Damage");

        // ===========================
        // ROUTING LOGIC
        // ===========================

        String route = "FAST TRACK";
        String reasoning = "Estimated damage low";

        // Missing fields rule
        if (!missingFields.isEmpty()) {
            route = "MANUAL REVIEW";
            reasoning = "Mandatory fields missing";
        }

        // Fraud keyword rule
        if (text.toLowerCase().contains("fraud") ||
            text.toLowerCase().contains("staged") ||
            text.toLowerCase().contains("inconsistent")) {

            route = "INVESTIGATION";
            reasoning = "Suspicious keywords detected";
        }

        // Injury rule
        if (text.toLowerCase().contains("injured")) {
            route = "SPECIALIST QUEUE";
            reasoning = "Injury related claim detected";
        }

        // ===========================
        // FINAL JSON OUTPUT
        // ===========================

        System.out.println("\n--- JSON OUTPUT ---");

        String jsonOutput =
                "{\n" +
                "  \"extractedFields\": \"" + extractedFields + "\",\n" +
                "  \"missingFields\": \"" + missingFields + "\",\n" +
                "  \"recommendedRoute\": \"" + route + "\",\n" +
                "  \"reasoning\": \"" + reasoning + "\"\n" +
                "}";

        System.out.println(jsonOutput);

    }
}
