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
public class SocialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SocialServlet() {
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
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SOCIALLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/social/socialmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/social/readscocial.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/social/updatesocial.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String url = request.getParameter("url").toString();
			int post = Integer.parseInt(request.getParameter("post"));
			String data = request.getParameter("data").toString();
			String namecoin = request.getParameter("namecoin").toString();
			dto = new SocialDTO (url,post,data,namecoin);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/social/socialmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			url = request.getParameter("url");
			post = Integer.parseInt(request.getParameter("post"));
			data = request.getParameter("data");
			namecoin = request.getParameter("namecoin");
			
			dto = new SocialDTO (id, url,post,data,namecoin);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/social/socialmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/social/socialmanager.jsp").forward(request, response);
			break;
		}
	}
}
