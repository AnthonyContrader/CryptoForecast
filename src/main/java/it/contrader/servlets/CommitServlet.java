package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CommitDTO;
import it.contrader.service.CommitService;
import it.contrader.service.Service;


/*
 * Per dettagli vedi Guida sez Servlet
 */
public class CommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommitServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CommitDTO> service = new CommitService();
		List<CommitDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CommitDTO> service = new CommitService();
		String mode = request.getParameter("mode");
		CommitDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "COMMITLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/commit/commitmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/commit/readcommit.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/commit/updatecommit.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String namecoin = request.getParameter("namecoin").toString();
			int number = Integer.parseInt(request.getParameter("number"));
			String data = request.getParameter("data").toString();
			dto = new CommitDTO (namecoin,number,data);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/commit/commitmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			namecoin = request.getParameter("namecoin");
			number = Integer.parseInt(request.getParameter("number"));
			data = request.getParameter("data");
			
			dto = new CommitDTO (id, namecoin, number, data);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/commit/commitmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/commit/commitmanager.jsp").forward(request, response);
			break;
		}
	}
}
