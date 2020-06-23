package com.npn.learning.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("superClass")
public class SuperSampleClass {
    private SampleClass1 sampleClass1;
    private SampleClass2 sampleClass2;

    @Autowired
    public SuperSampleClass(SampleClass1 sampleClass1, SampleClass2 sampleClass2) {
        this.sampleClass1 = sampleClass1;
        this.sampleClass2 = sampleClass2;
    }

    public SampleClass1 getSampleClass1() {
        return sampleClass1;
    }

    public void setSampleClass1(SampleClass1 sampleClass1) {
        this.sampleClass1 = sampleClass1;
    }

    public SampleClass2 getSampleClass2() {
        return sampleClass2;
    }

    public void setSampleClass2(SampleClass2 sampleClass2) {
        this.sampleClass2 = sampleClass2;
    }
}
