package com.qualentraglobal.astraq.service.impl;

import java.util.List;

import com.qualentraglobal.astraq.dto.LoginDto;
import com.qualentraglobal.astraq.entities.Users;
import com.qualentraglobal.astraq.services.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qualentraglobal.astraq.entities.Superadmin;
import com.qualentraglobal.astraq.repositories.IUserRepository;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public LoginDto loginUser(Users user) {
        Users obj_users=new Users();
        obj_users=userRepository.login(user);
        if(obj_users!=null){
            LoginDto loginDto=LoginDto.Singleton();
            return loginDto.builder()
                    .userId(obj_users.getUserId())
                    .userFirstname(obj_users.getUserFirstname())
                    .userLastname(obj_users.getUserLastname())
                    .gender(obj_users.getGender())
                    .mobilenumber(obj_users.getMobilenumber())
                    .build();
        }
        return null;
    }
}
