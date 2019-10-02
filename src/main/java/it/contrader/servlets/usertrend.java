package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.TrendDTO;
import it.contrader.service.Service;
import it.contrader.service.TrendService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class usertrend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public usertrend() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<TrendDTO> service = new TrendService();
		List<TrendDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<TrendDTO> service = new TrendService();
		String mode = request.getParameter("mode");
		TrendDTO dto;
		int id;
		

		switch (mode.toUpperCase()) {

		case "TRENDLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/trend/trendmanager2.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/trend/readtrend.jsp").forward(request, response);
				
			}
			
			
			
			break;

		
		}
	}
}