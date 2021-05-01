package HW8_2021_04_23.thirdtask;

public enum Paths {
    ORIGIN_FILE_PATH("src/HW8_2021_04_23/thirdtask/BlackList.txt"),
    NEW_FILE_PATH("src/HW8_2021_04_23/thirdtask/censoredText.txt");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
