import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.DefaultService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * App which the user uses to input a list of filenames containing account records
 * which needs to be checked for defaulted payments
 */
public class App{
    /**
     * Main method for the App
     *
     * @param args args is not used
     */
    public static void main( String[] args ){
        try (var context = new AnnotationConfigApplicationContext(Config.class)) {
            var ds1 = context.getBean(DefaultService.class);

            List<String> filenames = new ArrayList<>(Arrays.asList("asdf.csv", "carLoans.csv",
                    "homeLoans.csv", "testCase.csv"));
            ds1.checkDefault(filenames);
        }
    }
}