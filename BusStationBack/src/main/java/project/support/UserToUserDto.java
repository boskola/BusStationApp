package project.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.model.User;
import project.web.dto.UserDTO;

@Component
public class UserToUserDto implements Converter<User, UserDTO>{


    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.seteMail(user.geteMail());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserName(user.getUserName());

        return userDTO;
    }

    public List<UserDTO> convert(List<User> users){
        List<UserDTO> userDTOS = new ArrayList<>();

        for(User k : users) {
            UserDTO dto = convert(k);
            userDTOS.add(dto);
        }

        return userDTOS;
    }
}
