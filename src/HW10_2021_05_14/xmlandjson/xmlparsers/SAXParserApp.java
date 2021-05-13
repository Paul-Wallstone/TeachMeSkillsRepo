package HW10_2021_05_14.xmlandjson.xmlparsers;

import HW10_2021_05_14.xmlandjson.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXParserApp {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        HMLHandler hmlHandler = new HMLHandler();
        saxParser.parse(new File("src/HW10_2021_05_14/xmlandjson/medicalclinic.xml"), hmlHandler);
        employees.stream().map(a -> "Name: " + a.getName() + "\nPosition: "
                + a.getPosition() + "\nDepartment: " + a.getDepartment()
                + "\nExpirience: " + a.getExperience() + "\n").forEach(System.out::println);
    }

    private static class HMLHandler extends DefaultHandler {
        private String name, position, department, experience, lastElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((name != null && !name.isEmpty()) && (position != null && !position.isEmpty())
                    && (department != null && !department.isEmpty()) && (experience != null && !experience.isEmpty())) {
                employees.add(new Employee(name, position, department, Integer.parseInt(experience)));
                name = null;
                position = null;
                department = null;
                experience = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();
            if (!information.isEmpty()) {
                if (lastElement.equals("name"))
                    name = information;
                if (lastElement.equals("position"))
                    position = information;
                if (lastElement.equals("department"))
                    department = information;
                if (lastElement.equals("experience"))
                    experience = information;
            }
        }
    }

}
