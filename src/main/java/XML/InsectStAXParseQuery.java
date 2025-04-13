package XML;

import javax.xml.stream.*;
import java.io.FileReader;

public class InsectStAXParseQuery {
    public static void main(String[] args) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("C:\\Users\\niksu\\IdeaProjects\\Lab3\\src\\main\\java\\XML\\Insects.xml"));

        String currentElement = "";
        String currentId = "";

        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                currentElement = reader.getLocalName();
                if ("insect".equals(currentElement)) {
                    currentId = reader.getAttributeValue(null, "insectId");
                }
            } else if (event == XMLStreamConstants.CHARACTERS) {
                if ("commonName".equals(currentElement) && "TMP002".equals(currentId)) {
                    System.out.println("Insect TMP002: " + reader.getText().trim());
                }
            }
        }
        reader.close();
    }
}
