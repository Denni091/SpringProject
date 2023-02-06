package ua.ithillel.springproject.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int age;
}
