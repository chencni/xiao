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
@WebServlet("/SendNewsAction")
public class SendNewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendNewsAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsService newsService = new NewsService();
		String newsJsonString = request.getParameter("newsJson");
		JSONObject newsJson = new JSONObject(newsJsonString);
		System.out.println(newsJsonString);
		newsJson.put("userId", request.getSession().getAttribute("userId"));
		int rs = newsService.saveNews(newsJson);
		String saveRs = "";
		if (rs == 1) {
			saveRs = "发布成功";
		} else {
			saveRs = "发布失败";
		}
		JSONObject returnJson = new JSONObject().put("saveRs", saveRs);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8 ");
		PrintWriter writer = response.getWriter();
		writer.append(returnJson.toString());
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
