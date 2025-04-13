package XML;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;

public class InsectJDOMCreate {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\niksu\\IdeaProjects\\Lab3\\src\\main\\java\\XML\\Insects.xml");

        // If file exists, read and append; otherwise, create a new file
        Document doc;
        if (file.exists()) {
            // Read the existing file
            SAXBuilder saxBuilder = new SAXBuilder();
            doc = saxBuilder.build(file);
        } else {
            // Create a new document if the file doesn't exist
            Element root = new Element("insects");
            doc = new Document(root);
        }

        // Create new habitat and insect elements to add
        Element habitat = new Element("habitat");
        habitat.setAttribute("name", "Desertic");

        Element insect = new Element("insect");
        insect.setAttribute("insectId", "D001");
        insect.addContent(new Element("commonName").setText("Lăcustă de deșert"));
        insect.addContent(new Element("scientificName").setText("Schistocerca gregaria"));
        insect.addContent(new Element("dangerLevel").setText("High"));

        Element characteristics = new Element("characteristics");
        characteristics.addContent(new Element("characteristic").setText("Formează roiuri"));
        characteristics.addContent(new Element("characteristic").setText("Distruge culturi"));
        insect.addContent(characteristics);

        insect.addContent(new Element("legs").setText("6"));

        habitat.addContent(insect);

        // Add the new habitat to the root element
        doc.getRootElement().addContent(habitat);

        // Save the updated XML back to the file
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        try (FileWriter writer = new FileWriter(file)) {
            outputter.output(doc, writer);
        }

        System.out.println("New data added to 'insects.xml' successfully!");
    }
}