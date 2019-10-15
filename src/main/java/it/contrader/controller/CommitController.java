package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CommitDTO;
import it.contrader.service.CommitService;

@RestController
@RequestMapping("/commit")
@CrossOrigin(origins = "http://localhost4200")

public class CommitController extends AbstractController<CommitDTO>
{
	
	@Autowired
	private CommitService commitService;
}
