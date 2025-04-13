package XML;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import java.io.File;
import java.util.*;

public class InsectXPathUtils {

    public static Document loadDoc(String filename) throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filename));
    }

    public static boolean tagExists(Document doc, String tagName) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "//" + tagName;
        NodeList nodes = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
        return nodes.getLength() > 0;
    }

    public static boolean tagHasChildren(Document doc, String tagName) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "//" + tagName + "/*";
        NodeList nodes = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
        return nodes.getLength() > 0;
    }

    public static List<String> getTagValues(Document doc, String tagName) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "//" + tagName;
        NodeList nodes = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

        List<String> values = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            values.add(nodes.item(i).getTextContent());
        }
        return values;
    }

    public static void main(String[] args) throws Exception {
        Document doc = loadDoc("C:\\Users\\niksu\\IdeaProjects\\Lab3\\src\\main\\java\\XML\\Insects.xml");

        System.out.println("Tag 'insect' exists: " + tagExists(doc, "insect"));
        System.out.println("Tag 'characteristics' has children: " + tagHasChildren(doc, "characteristics"));

        List<String> values = getTagValues(doc, "commonName");
        System.out.println("Common names of insects:");
        values.forEach(System.out::println);
    }
}
