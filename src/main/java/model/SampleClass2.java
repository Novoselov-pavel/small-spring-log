package model;

import annotation.Around;
import annotation.AroundWithParameters;

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

    @Around
    public String aroundTest(String test1, String test2) {
        try {
            Thread.sleep(70);
        } catch (InterruptedException ignored) {
        }
        return test1+test2;
    }

    @AroundWithParameters(count = 5)
    public String around2Test(String test) {
        return test+" ";
    }

    @Around
    public String around3Test(String test, int count, String test2) {
        return test + test2;
    }
}
