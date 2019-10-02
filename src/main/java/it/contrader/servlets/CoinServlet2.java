package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CoinDTO;
import it.contrader.service.Service;
import it.contrader.service.CoinService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class CoinServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CoinServlet2() {
	
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CoinDTO> service = new CoinService();
		List<CoinDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CoinDTO> service = new CoinService();
		String mode = request.getParameter("mode");
		CoinDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "COINLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/coin/coinmanageru.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/coin/readcoin.jsp").forward(request, response);
				
			}
			
			
			
			break;
		}
	}
}
		