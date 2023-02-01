package ua.ithillel.springproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ua.ithillel.springproject.entity.User;

@Configuration
@ComponentScan("ua.ithillel.springproject.configuration")
@PropertySource("classpath:application.properties")
public class SpringConfiguration {

    @Value("${text}")
    private String textFromApplicationProperties;

    @Value("${value}")
    private Integer valueFromApplicationProperties;

    @Bean
    public String stringBean() {
        return "Text from Spring Config";
    }

    @Bean
    @Scope("prototype")
    public User getUser() {
        return new User("Maksim", "Zeider", 25);
    }

    @Bean
    @Scope("singleton")
    public Integer getAgeUser(User user) {
        return user.getAge();
    }

    @Bean
    public String getTextFromApplicationProperties() {
        return textFromApplicationProperties;
    }

    @Bean
    public Integer getValueFromApplicationProperties() {
        return valueFromApplicationProperties;
    }
}
