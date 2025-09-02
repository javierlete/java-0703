package com.ipartek.formacion.ipartube.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/generar")
	public String generar(String password) {
		return passwordEncoder.encode(password);
	}
}
