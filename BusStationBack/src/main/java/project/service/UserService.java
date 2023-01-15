package project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import project.model.User;
import project.web.dto.UserPasswordChangeDto;

public interface UserService {

    Optional<User> findOne(Long id);

    List<User> findAll();

    Page<User> findAll(int pageNumber);

    User save(User user);

    void delete(Long id);

    Optional<User> findbyUserName(String userName);

    boolean changePassword(Long id, UserPasswordChangeDto userPasswordChangeDto);
}
