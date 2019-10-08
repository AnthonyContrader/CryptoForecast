package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SocialDTO;
import it.contrader.model.Social;
import it.contrader.service.SocialService;


@Controller
@RequestMapping("/social")
public class SocialController {

	@Autowired
	private SocialService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "socials";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "socials";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatesocial";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("reddit") int reddit,
			@RequestParam("telegram") int telegram, @RequestParam("likefb") int likefb, @RequestParam("twitter") int twitter) {

		SocialDTO dto = new SocialDTO();
		dto.setId(id);
		dto.setTelegram(telegram);
		dto.setReddit(reddit);
		dto.setLikefb(likefb);
		dto.setTwitter(twitter);
		service.update(dto);
		setAll(request);
		return "socials";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("reddit") int reddit, @RequestParam("telegram") int telegram, @RequestParam("likefb") int likefb, @RequestParam("twitter") int twitter ) {
		SocialDTO dto = new SocialDTO();
		
		dto.setTelegram(telegram);
		dto.setReddit(reddit);
		dto.setLikefb(likefb);
		dto.setTwitter(twitter);
		service.insert(dto);
		setAll(request);
		return "socials";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readsocial";
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
