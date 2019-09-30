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
public class TrendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TrendServlet() {
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
		int idtrend;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "TRENDLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/trend/trendmanager.jsp").forward(request, response);
			break;

		case "READ":
			idtrend = Integer.parseInt(request.getParameter("idtrend"));
			dto = service.read(idtrend);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/trend/readtrend.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/trend/updatetrend.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String time = request.getParameter("time").toString();
			int variations = Integer.parseInt(request.getParameter("idtrend")); 
			String namecoin = request.getParameter("namecoin").toString();
			dto = new TrendDTO (time,variations,namecoin);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/trend/trendmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			time = request.getParameter("time");
			variations = Integer.parseInt(request.getParameter("idtrend"));
			namecoin = request.getParameter("namecoin");
			idtrend = Integer.parseInt(request.getParameter("idtrend"));
			dto = new TrendDTO (idtrend,time, variations, namecoin);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/trend/trendmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idtrend = Integer.parseInt(request.getParameter("idtrend"));
			ans = service.delete(idtrend);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/trend/trendmanager.jsp").forward(request, response);
			break;
		}
	}
}