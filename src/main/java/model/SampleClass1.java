package model;

public class SampleClass1 {
    private String name;

    public SampleClass1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sum(String value) {
        name = name + value;
    }

    public void oops (String value, String value2) {
        name += value + value2;
    }

    public void bum() {
        int i = 50;
        i = i / 0;
    }
}
