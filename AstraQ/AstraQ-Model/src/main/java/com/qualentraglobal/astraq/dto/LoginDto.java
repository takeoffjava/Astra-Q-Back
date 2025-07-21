package com.qualentraglobal.astraq.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginDto {
    public static LoginDto loginDto_instance=null;
    private Long userId;
    private String userFirstname;
    private String userLastname;
    private String gender;
    private String token;
    private String mobilenumber;

    public static LoginDto Singleton()
    {
        if (loginDto_instance == null) {
            loginDto_instance = new LoginDto();
        }
        return loginDto_instance;
    }

}
