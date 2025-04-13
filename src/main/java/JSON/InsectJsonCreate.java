package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;

public class InsectJsonCreate {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode root = mapper.createObjectNode();
        ArrayNode insectsArray = mapper.createArrayNode();

        ObjectNode habitat = mapper.createObjectNode();
        habitat.put("habitatName", "Aquatic");
        habitat.put("habitatId", "3");

        ArrayNode species = mapper.createArrayNode();
        ObjectNode insect = mapper.createObjectNode();
        insect.put("insectId", "A001");
        insect.put("commonName", "Gândacul de apă");
        insect.put("scientificName", "Belostomatidae");
        insect.put("discovered", "2001");
        insect.put("dangerLevel", "Medium");

        ArrayNode characteristics = mapper.createArrayNode();
        characteristics.add("Prinde pești");
        characteristics.add("Respiră prin sifon");
        insect.set("characteristics", characteristics);

        insect.put("legs", 6);
        species.add(insect);

        habitat.set("species", species);
        insectsArray.add(habitat);

        root.set("insects", insectsArray);

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("partial_insects.json"), root);
        System.out.println("Created partial_insects.json successfully.");
    }
}
