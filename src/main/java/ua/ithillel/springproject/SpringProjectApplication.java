package ua.ithillel.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.springproject.configuration.SpringConfiguration;
import ua.ithillel.springproject.controller.UserController;
import ua.ithillel.springproject.entity.User;

import java.util.List;

@SpringBootApplication
public class SpringProjectApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringProjectApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        String stringBean = context.getBean("stringBean", String.class);

        System.out.println(stringBean);
        User getUser = context.getBean("getUser", User.class);
        getUser.setAge(30);
        System.out.println(getUser);
        User getUserUpdate = context.getBean("getUser", User.class);
        System.out.println(getUserUpdate);
        Integer getAgeUser = context.getBean("getAgeUser", Integer.class);
        System.out.println("Get age user: " + getAgeUser);

        String getTextFromApplicationProperties = context.getBean("getTextFromApplicationProperties", String.class);
        System.out.println("Text: " + getTextFromApplicationProperties);
        Integer getValueFromApplicationProperties = context.getBean("getValueFromApplicationProperties", Integer.class);
        System.out.println("Value: " + getValueFromApplicationProperties);

        UserController userController = run.getBean(UserController.class);
        List<User> userList = userController.getAll();
        userList.forEach(System.out::println);
    }
}
