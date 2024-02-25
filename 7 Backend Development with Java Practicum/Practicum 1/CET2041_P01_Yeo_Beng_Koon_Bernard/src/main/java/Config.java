import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Config configures the Spring-related configurations for the project. The packages that are loaded are
 * model, repositories and services.
 */
@Configuration
@ComponentScan(basePackages = {"model", "repositories", "services"} )
public class Config {}


