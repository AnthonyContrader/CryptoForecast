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
public class CommitServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommitServlet2() {
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

		switch (mode.toUpperCase()) {

		case "COMMITLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/commit/commitmanager2.jsp").forward(request, response);
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
//insert
		
		}
	}
}
