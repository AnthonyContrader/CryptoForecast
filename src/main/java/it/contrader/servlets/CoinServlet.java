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
public class CoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CoinServlet() {
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
		int idcoin;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "COINLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/coin/coinmanager.jsp").forward(request, response);
			break;

		case "READ":
			idcoin = Integer.parseInt(request.getParameter("idcoin"));
			dto = service.read(idcoin);
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
			name = request.getParameter("name");
			quotation = Integer.parseInt(request.getParameter("idcoin"));
			symbol = request.getParameter("symbol");
			idcoin = Integer.parseInt(request.getParameter("idcoin"));
			dto = new CoinDTO (idcoin, name, quotation, symbol);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/coin/coinmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idcoin = Integer.parseInt(request.getParameter("idcoin"));
			ans = service.delete(idcoin);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/coin/coinmanager.jsp").forward(request, response);
			break;
		}
	}
}
