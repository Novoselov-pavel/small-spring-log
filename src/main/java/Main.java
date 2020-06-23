import com.npn.learning.spring.model.SampleClass1;
import com.npn.learning.spring.model.SampleClass2;
import com.npn.learning.spring.model.SuperSampleClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
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
        class1.bum();
        context.close();
    }
}
