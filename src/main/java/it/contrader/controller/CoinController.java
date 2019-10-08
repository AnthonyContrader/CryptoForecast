package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CoinDTO;
import it.contrader.model.Coin;
import it.contrader.service.CoinService;


@Controller
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	private CoinService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "coins";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "coins";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecoin";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("namecoin") String namecoin,
			@RequestParam("price") int price, @RequestParam("circulating") int circulating) {

		CoinDTO dto = new CoinDTO();
		dto.setId(id);
		dto.setNamecoin(namecoin);
		dto.setPrice(price);
		dto.setCirculating(circulating);
		service.update(dto);
		setAll(request);
		return "coins";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("namecoin") String namecoin,
			@RequestParam("price") int price, @RequestParam("circulating") int circulating) {
		CoinDTO dto = new CoinDTO();
		dto.setNamecoin(namecoin);
		dto.setPrice(price);
		dto.setCirculating(circulating);
		service.insert(dto);
		setAll(request);
		return "coins";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readcoin";
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
