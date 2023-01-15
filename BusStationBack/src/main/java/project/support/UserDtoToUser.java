package project.support;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.model.User;
import project.service.UserService;
import project.web.dto.UserDTO;

@Component
public class UserDtoToUser implements Converter<UserDTO, User> {

    @Autowired
    private UserService userService;

    @Override
    public User convert(UserDTO userDTO) {
        User user = null;
        if(userDTO.getId() != null) {
        	user = userService.findOne(userDTO.getId()).get();
        }

        if(user == null) {
        	user = new User();
        }

        user.setUserName(userDTO.getUserName());
        user.seteMail(userDTO.geteMail());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());

        return user;
    }

}
