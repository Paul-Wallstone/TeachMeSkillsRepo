package HW10_2021_05_14.xmlandjson.xmlparsers;

import HW10_2021_05_14.xmlandjson.Employee;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StaxParserApp implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private final XMLStreamReader reader;
    public List<Employee> employees = new ArrayList<>();
    private String name = "", position = "", department = "", experience = "";

    public static void main(String[] args) throws Exception {
        String[] elements = {"name", "position", "department", "experience"};

        try (StaxParserApp processor = new StaxParserApp(Files.newInputStream(Paths.get("src/HW10_2021_05_14/xmlandjson/medicalclinic.xml")))) {
            processor.startElement(elements, "clinic", "stuff");
            processor.employees.stream().map(a -> "Name: " + a.getName() + "\nPosition: "
                    + a.getPosition() + "\nDepartment: " + a.getDepartment()
                    + "\nExperience: " + a.getExperience() + "\n").forEach(System.out::println);
        } catch (XMLStreamException | IOException e1) {
            e1.printStackTrace(System.out);
        }
    }

    public StaxParserApp(InputStream is) throws XMLStreamException {
        this.reader = FACTORY.createXMLStreamReader(is);
    }

    public void startElement(String[] elements, String parent, String block) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (parent != null && event == XMLEvent.END_ELEMENT && parent.equals(reader.getLocalName())) {
            }
            for (String element : elements) {
                if (event == XMLEvent.START_ELEMENT && element.equals(reader.getLocalName())) {
                    if (reader.getLocalName().equals("name"))
                        name = reader.getElementText();
                    if (reader.getLocalName().equals("position"))
                        position = reader.getElementText();
                    if (reader.getLocalName().equals("department"))
                        department = reader.getElementText();
                    if (reader.getLocalName().equals("experience"))
                        experience = reader.getElementText();
                }
                if (name != null && position != null && department != null && experience != null &&
                        event == XMLEvent.END_ELEMENT && block.equals(reader.getLocalName())) {
                    employees.add(new Employee(name, position, department, Integer.parseInt(experience)));
                    name = null;
                    position = null;
                    department = null;
                    experience = null;
                }
            }
        }
    }

    @Override
    public void close() throws Exception {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}