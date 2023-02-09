package ua.ithillel.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        String stringBean = context.getBean("stringBean", String.class);
//
//        System.out.println(stringBean);
//        User getUser = context.getBean("getUser", User.class);
//        getUser.setAge(30);
//        System.out.println(getUser);
//        User getUserUpdate = context.getBean("getUser", User.class);
//        System.out.println(getUserUpdate);
//        Integer getAgeUser = context.getBean("getAgeUser", Integer.class);
//        System.out.println("Get age user: " + getAgeUser);
//
//        String getTextFromApplicationProperties = context.getBean("getTextFromApplicationProperties", String.class);
//        System.out.println("Text: " + getTextFromApplicationProperties);
//        Integer getValueFromApplicationProperties = context.getBean("getValueFromApplicationProperties", Integer.class);
//        System.out.println("Value: " + getValueFromApplicationProperties);
//
//        UserController userController = run.getBean(UserController.class);
//        List<UserDto> userList = userController.getAll();
//        userList.forEach(System.out::println);
    }
}
