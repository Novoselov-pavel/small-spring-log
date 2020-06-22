package model;

public class SampleClass2 {
    private String name;

    public SampleClass2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void div(String value) {
        name = value + name;
    }
}
