package HW10_2021_05_14.xmlandjson.jackson;

public class CompanyViews {

    public static class Normal {
        private String name;
        private String position;

        public Normal() {
        }

        public Normal(String name, String position) {
            this.name = name;
            this.position = position;
        }
    }

    public static class Manager extends Normal {
        private String name;
        private String position;

        public Manager() {
        }

        public Manager(String name, String position) {
            this.name = name;
            this.position = position;
        }
    }
}
