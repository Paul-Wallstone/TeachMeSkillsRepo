package HW8_2021_04_23.firsttask;

public enum Paths {
    ORIGIN_FILE_PATH("src/HW8_2021_04_23/firsttask/InputOutputStreamFile.txt"),
    NEW_FILE_PATH("src/HW8_2021_04_23/firsttask/InputOutputStreamFileNew.txt");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
