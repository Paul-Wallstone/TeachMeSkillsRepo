package HW10_2021_05_14.xmlandjson.xmlparsers;

import HW10_2021_05_14.xmlandjson.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMParserApp {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/HW10_2021_05_14/xmlandjson/medicalclinic.xml"));
        String name = "", position = "", department = "", experience = "";

        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("stuff");
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node stuff = employeeElements.item(i);
            NodeList stuffList = stuff.getChildNodes();
            for (int ii = 0; ii < stuffList.getLength(); ii++) {
                Node element = stuffList.item(ii);
                switch (element.getNodeName()) {
                    case "name" -> name = element.getTextContent();
                    case "position" -> position = element.getTextContent();
                    case "department" -> department = element.getTextContent();
                    case "experience" -> experience = element.getTextContent();
                }
            }
            employees.add(new Employee(name, position, department, Integer.parseInt(experience)));
        }
        employees.stream().map(a -> "Name: " + a.getName() + "\nPosition: "
                + a.getPosition() + "\nDepartment: " + a.getDepartment()
                + "\nExperience: " + a.getExperience() + "\n").forEach(System.out::println);
    }
}