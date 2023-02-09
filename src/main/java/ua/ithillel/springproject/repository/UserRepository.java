package ua.ithillel.springproject.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.ithillel.springproject.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getUserByEmailAndPhone(String email, String phone);

    List<User> getUserByNameOrSurnameOrPhone(String name, String Surname, String Phone);

    @Transactional
    @Modifying
    @Query("update User u set u.email = ?1 where u.id = ?2")
    Integer updateEmailUserById(String email, Integer id);
}
