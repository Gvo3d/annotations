import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    int numberOfTimes();
    String methoToInvoke();
}