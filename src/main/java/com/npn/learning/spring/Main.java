package com.npn.learning.spring;

import com.npn.learning.spring.model.SampleClass1;
import com.npn.learning.spring.model.SampleClass2;
import com.npn.learning.spring.model.SuperSampleClass;
import com.npn.learning.spring.model.interfacesample.Fabric;
import com.npn.learning.spring.model.interfacesample.MyInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static void main(String[] args) {
        SuperSampleClass superclass = (SuperSampleClass) context.getBean("superClass", SuperSampleClass.class);
        SampleClass1 class1 = superclass.getSampleClass1();
        SampleClass2 class2 = superclass.getSampleClass2();
        class1.sum("arg");
        class2.div("arg");
        class1.oops("ooo", "aaaa");
        class1.getName();
        class2.getName();
        class1.setName("aewe");
        class2.setName("wqqwe");
        class2.aroundTest("abbberea", "asdsafrr");
        class2.around2Test("ole");
        class2.around3Test("atest",2,"btest");

        Fabric fabric = (Fabric) context.getBean("fabric",Fabric.class);
        MyInterface myInterface = fabric.getMyInterface("myClass2");
        System.out.println(myInterface.doWork("a","b"));

        class1.bum();
        context.close();
    }
}
