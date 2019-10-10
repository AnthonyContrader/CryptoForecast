package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CoinDTO;
import it.contrader.dto.CommitDTO;
import it.contrader.model.Commit;
import it.contrader.service.CommitService;


@Controller
@RequestMapping("/commit")
public class CommitController {

	@Autowired
	private CommitService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "commits";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "commits";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecommit";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("stars") int stars,
			@RequestParam("fork") int fork, @RequestParam("watcher") int watcher, @RequestParam("collaborators") int collaborators, 
			@RequestParam("number") int number, @RequestParam("idcoin") Long idcoin) {

		CommitDTO dto = new CommitDTO();
		dto.setId(id);
		dto.setStars(stars);
		dto.setFork(fork);
		dto.setWatcher(watcher);
		dto.setCollaborators(collaborators);
		dto.setNumber(number);
		CoinDTO c = new CoinDTO();
		c.setId(idcoin);
		dto.setCoinDTO(c);
		
		service.update(dto);
		setAll(request);
		return "commits";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("stars") int stars,
			@RequestParam("fork") int fork, @RequestParam("watcher") int watcher, @RequestParam("collaborators") int collaborators, 
			@RequestParam("number") int number, @RequestParam("idcoin") Long idcoin) {
		
		CommitDTO dto = new CommitDTO();
		dto.setStars(stars);
		dto.setFork(fork);
		dto.setWatcher(watcher);
		dto.setCollaborators(collaborators);
		dto.setNumber(number);
		CoinDTO c = new CoinDTO();
		c.setId(idcoin);
		dto.setCoinDTO(c);

		service.insert(dto);
		setAll(request);
		return "commits";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readcommit";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
