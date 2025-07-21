package com.qualentraglobal.astraq.controllers;

import java.util.List;
import java.util.Optional;

import com.qualentraglobal.astraq.dto.LoginDto;
import com.qualentraglobal.astraq.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qualentraglobal.astraq.common.Constant;
import com.qualentraglobal.astraq.common.Utilities;
import com.qualentraglobal.astraq.entities.Superadmin;
import com.qualentraglobal.astraq.security.jwt.JwtService;
import com.qualentraglobal.astraq.service.impl.LoginService;

@RestController
@RequestMapping("astraq/api/v1")
public class Logincontroller {


    @Autowired
    private LoginService service;

	@Autowired
	JwtService jwtService;
	
	@Autowired
	Utilities utilities;
	
	@Autowired
	Constant constants;

	@PostMapping("/login")
	public  ResponseEntity<LoginDto> login(@RequestBody Users users){
		LoginDto loginDto=service.loginUser(users);
		Optional<LoginDto> isNull=Optional.ofNullable(loginDto);
		if (isNull.isPresent()) {
			String token = jwtService.generateToken(loginDto.getMobilenumber());
			loginDto.setToken(token);
			return ResponseEntity.ok(loginDto);

		} else {
			return ResponseEntity.status(401).body(null);
		}
	}

	@GetMapping("/validate")
	public ResponseEntity<String> getData(@RequestHeader("Authorization") String token) {
	    if (jwtService.validateToken(token.replace("Bearer ", ""), "user")) {
	        return ResponseEntity.ok("This is protected data!");
	    } else {
	        return ResponseEntity.status(401).body("Unauthorized");
	    }
	}
	
//	@GetMapping("/getadminuser")
//    public List<Superadmin> getAll() {
//        return service.getAllAdmins();
//    }
}
