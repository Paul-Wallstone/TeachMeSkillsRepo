package HW8_2021_04_23.fourthtask;

public enum Paths {
    ORIGIN_FILE_PATH("src/HW8_2021_04_23/fourthtask/car.dat");


    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
