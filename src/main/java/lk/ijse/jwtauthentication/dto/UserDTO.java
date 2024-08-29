package lk.ijse.jwtauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String companyName;
    private String role;
}
