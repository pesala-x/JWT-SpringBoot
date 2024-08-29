package lk.ijse.jwtauthentication.service;

import lk.ijse.jwtauthentication.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}
