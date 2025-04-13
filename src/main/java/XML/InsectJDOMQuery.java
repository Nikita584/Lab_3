package XML;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.io.File;


public class InsectJDOMQuery {
    public static void main(String[] args) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new File("C:\\Users\\niksu\\IdeaProjects\\Lab3\\src\\main\\java\\XML\\Insects.xml"));
        String searchId = "TMP001";

        for (Element habitat : doc.getRootElement().getChildren("habitat")) {
            for (Element insect : habitat.getChildren("insect")) {
                if (searchId.equals(insect.getAttributeValue("insectId"))) {
                    System.out.println("Found insect: " + insect.getChildText("commonName"));
                }
            }
        }
    }
}
