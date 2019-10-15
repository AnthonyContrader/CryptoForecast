package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TrendDTO;
import it.contrader.service.TrendService;

@RestController
@RequestMapping("/trend")
@CrossOrigin(origins = "http://localhost4200")

public class TrendController extends AbstractController<TrendDTO>{


@Autowired
private TrendService trendService;


}



