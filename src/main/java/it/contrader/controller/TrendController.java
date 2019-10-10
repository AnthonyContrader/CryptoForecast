package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CoinDTO;
import it.contrader.dto.TrendDTO;

import it.contrader.service.TrendService;


@Controller
@RequestMapping("/trend")
public class TrendController {

	@Autowired
	private TrendService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "trends";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "trends";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetrend";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("variation") int variation,
			@RequestParam("date") String date, @RequestParam("idcoin") Long idcoin) {

		TrendDTO dto = new TrendDTO();
		dto.setId(id);
		dto.setVariation(variation);
		dto.setDate(date);
		CoinDTO sc = new CoinDTO();
		sc.setId(idcoin);
		dto.setCoinDTO(sc);
		service.update(dto);
		setAll(request);
		return "trends";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("variation") int variation,
			@RequestParam("date") String date, @RequestParam("idcoin") Long idcoin) {
		TrendDTO dto = new TrendDTO();
		dto.setVariation(variation);
		dto.setDate(date);
		CoinDTO sc = new CoinDTO();
		sc.setId(idcoin);
		dto.setCoinDTO(sc);
		service.insert(dto);
		setAll(request);
		return "trends";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtrend";
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
