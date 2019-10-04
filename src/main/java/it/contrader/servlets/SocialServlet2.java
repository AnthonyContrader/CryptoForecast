package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.SocialDTO;
import it.contrader.service.Service;
import it.contrader.service.SocialService;


/*
 * Per dettagli vedi Guida sez Servlet
 */
public class SocialServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SocialServlet2() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<SocialDTO> service = new SocialService();
		List<SocialDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SocialDTO> service = new SocialService();
		String mode = request.getParameter("mode");
		SocialDTO dto;
		int id;
		

		switch (mode.toUpperCase()) {

		case "SOCIALLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/social/socialmanager2.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/social/readsocial.jsp").forward(request, response);
				
			}
			
			
			
			break;

		
		}
	}
}
