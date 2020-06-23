import model.SampleClass1;
import model.SampleClass2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SampleClass1 class1 = (SampleClass1) context.getBean("sampleClass1", SampleClass1.class);
        SampleClass2 class2 = (SampleClass2) context.getBean("sampleClass2", SampleClass2.class);
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
        class1.bum();
        context.close();
    }
}
