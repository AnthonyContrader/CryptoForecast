package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CoinDTO;
import it.contrader.service.CoinService;

@RestController
@RequestMapping("/coin")
@CrossOrigin(origins = "http://localhost:4200" )

public class CoinController extends AbstractController<CoinDTO>{

@Autowired
private CoinService coinService;



}
