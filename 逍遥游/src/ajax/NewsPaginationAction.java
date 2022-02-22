package ajax;

import org.json.JSONObject;
import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/NewsPaginationAction")
public class NewsPaginationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsPaginationAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsService newsService = new NewsService();
		String currentPage = request.getParameter("currentPage");
		JSONObject newsJson = newsService.getNews(Integer.valueOf(currentPage));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8 ");
		PrintWriter writer = response.getWriter();
		writer.append(newsJson.toString());
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
