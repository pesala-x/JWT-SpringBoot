package lk.ijse.jwtauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthDTO {
    private  String email;
    private String token;
    private String refreshToken;
}
