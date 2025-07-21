package com.qualentraglobal.astraq.services;

import com.qualentraglobal.astraq.dto.LoginDto;
import com.qualentraglobal.astraq.entities.Superadmin;
import com.qualentraglobal.astraq.entities.Users;

import java.util.List;

public interface ILoginService {
    public LoginDto loginUser(Users user);
}

