package HW8_2021_04_23.secondtask;

public enum Paths {
    ORIGIN_FILE_PATH("src/HW8_2021_04_23/secondtask/SecondTaskFile.txt"),
    NEW_FILE_PATH("src/HW8_2021_04_23/secondtask/SecondTaskFile_New.txt");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
