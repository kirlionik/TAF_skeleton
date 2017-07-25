package configuration;

import org.exampleProject.qa.common.gui.configuration.WebdriverConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by Anton_Shapin on 5/23/17.
 */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({WebdriverConfig.class})
@ComponentScan("org.exampleProject.qa.common")
@PropertySources({
        @PropertySource("classpath:env/${NG_ENV:dev}.properties"),
        @PropertySource("classpath:core/webdrivermanager.properties")
})
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
