package HW10_2021_05_14.xmlandjson;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MedicalSearch {

    public static String findDoctor(String name) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/HW10_2021_05_14/xmlandjson/medicalclinic.xml"));
        String nameTXT = "", positionTXT = "", departmentTXT = "", experienceTXT = "", doctorSearched = "";
        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("name");
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node nameStuff = employeeElements.item(i);
            if (nameStuff.getTextContent().equals(name)) {
                NodeList stuffList = nameStuff.getParentNode().getChildNodes();
                for (int ii = 0; ii < stuffList.getLength(); ii++) {
                    Node element = stuffList.item(ii);
                    doctorSearched += switch (element.getNodeName()) {
                        case "name" -> "name: " + element.getTextContent() + "\n";
                        case "position" -> "position: " + element.getTextContent() + "\n";
                        case "department" -> "department: " + element.getTextContent() + "\n";
                        case "experience" -> "experience: " + element.getTextContent() + " years";
                        default -> "";
                    };
                }
            }
        }
        if (doctorSearched.equals("")) {
            return doctorSearched = "Such doctor is not exist!";
        } else
            return doctorSearched;
    }
}
