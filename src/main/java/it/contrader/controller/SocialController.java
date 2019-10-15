package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SocialDTO;
import it.contrader.service.SocialService;

@RestController
@RequestMapping("/social")
@CrossOrigin(origins = "http://localhost:4200")

public class SocialController extends AbstractController<SocialDTO>{
	@Autowired
	private SocialService socialservice;
	
}
