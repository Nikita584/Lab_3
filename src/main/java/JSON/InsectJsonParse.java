package JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class InsectJsonParse {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("C:\\Users\\niksu\\IdeaProjects\\Lab3\\src\\main\\java\\JSON\\Insects.json"));

        for (JsonNode habitat : root.get("insects")) {
            System.out.println("Habitat: " + habitat.get("habitatName").asText());
            for (JsonNode insect : habitat.get("species")) {
                System.out.println("  - " + insect.get("commonName").asText() +
                        " (" + insect.get("scientificName").asText() + ")");
            }
        }
    }
}
