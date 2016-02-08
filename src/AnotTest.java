import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by User on 08.02.2016.
 */
public class AnotTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Printer printer = new Printer();
        Class printer2 = Class.forName("Printer");
//        Printer printer3 = (Printer) printer2.newInstance();
        CustomAnnotation annotation = printer.getClass().getAnnotation(CustomAnnotation.class);
        String method = annotation.methoToInvoke();
        int numberOfTime = annotation.numberOfTimes();
        Method method1 = printer.getClass().getMethod(method, int.class);
        method1.invoke(printer, 5);

        Method[] methods = printer2.getDeclaredMethods();
        for (Method methoda:methods){
            System.out.println(methoda);
        };
    }
}

@CustomAnnotation(numberOfTimes = 5, methoToInvoke = "method1")
class Printer {
    public void method1(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Method1 " + i);
        }
    }

    public void method2(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Method2 " + i);
        }
    }
}
