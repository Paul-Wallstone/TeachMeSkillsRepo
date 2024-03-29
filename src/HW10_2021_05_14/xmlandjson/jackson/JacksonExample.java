package HW10_2021_05_14.xmlandjson.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JacksonExample {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Staff staff = createStaff();

        try {

            // to enable pretty print
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // normal
            String normalView = mapper
                    .writerWithView(CompanyViews.Normal.class)
                    .writeValueAsString(staff);

            System.out.format("Normal views\n%s\n", normalView);

            // manager
            String managerView = mapper
                    .writerWithView(CompanyViews.Manager.class)
                    .writeValueAsString(staff);
            System.out.format("Manager views\n%s\n", managerView);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Staff createStaff() {

        Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(38);
        staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }


}
