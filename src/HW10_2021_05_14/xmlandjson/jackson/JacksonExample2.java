package HW10_2021_05_14.xmlandjson.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonExample2 {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // JSON file to Java object
            Staff staff = mapper.readValue(new File("src/HW10_2021_05_14/xmlandjson/jackson/staff.json"), Staff.class);

            // JSON string to Java object
            String jsonInString = "{\"new_name\":\"mkyong\",\"age\":37,\"skills\":[\"java\",\"python\"]}";
            Staff staff2 = mapper.readValue(jsonInString, Staff.class);

            // compact print
            System.out.println(staff2);

            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
