package XML;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import java.io.File;
import java.util.List;

public class InsectJDOMParse {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("C:\\Users\\niksu\\IdeaProjects\\Lab3\\src\\main\\java\\XML\\Insects.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);

        Element rootElement = document.getRootElement(); // insects
        List<Element> habitats = rootElement.getChildren("habitat");

        for (Element habitat : habitats) {
            String habitatName = habitat.getAttributeValue("name");
            System.out.println("Habitat: " + habitatName);
            for (Element insect : habitat.getChildren("insect")) {
                System.out.println(" - Insect ID: " + insect.getAttributeValue("insectId"));
            }
        }
    }
}
