package HW10_2021_05_14.xmlandjson;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MedicalApp {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        System.out.println(MedicalSearch.findDoctor("Allison Cameron") + "\n");
        System.out.println(MedicalSearch.findDoctor("Robert Chase") + "\n");
        System.out.println(MedicalSearch.findDoctor("Braun Finch"));
    }
}
