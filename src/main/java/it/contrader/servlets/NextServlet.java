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
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NextServlet() {
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

		case "NEXTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/Next/Nextmanager.jsp").forward(request, response);
			break;

		/*case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/coin/readcoin.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/coin/updatecoin.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			int quotation = Integer.parseInt(request.getParameter("quotation"));
			String symbol = request.getParameter("symbol").toString();
			dto = new CoinDTO (name,quotation,symbol);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/coin/coinmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			quotation = Integer.parseInt(request.getParameter("quotation"));
			symbol = request.getParameter("symbol");
			
			dto = new CoinDTO (id, name, quotation, symbol);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/coin/coinmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/coin/coinmanager.jsp").forward(request, response);
			break;*/
		}
	}
}
