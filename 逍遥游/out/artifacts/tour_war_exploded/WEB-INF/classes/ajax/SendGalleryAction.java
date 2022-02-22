package ajax;

import org.json.JSONArray;
import org.json.JSONObject;
import service.GalleryService;

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
@WebServlet("/SendGalleryAction")
public class SendGalleryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendGalleryAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GalleryService galleryService = new GalleryService();
		String imagesUrlArray = request.getParameter("imagesUrl");
		System.out.println("imagesUrlArray="+imagesUrlArray);
		JSONArray imagesUrlJsonArray = new JSONArray(imagesUrlArray);
		JSONObject galleryJson = new JSONObject();
		galleryJson.put("imagesUrl", imagesUrlJsonArray);
		galleryJson.put("userId", request.getSession().getAttribute("userId"));
		System.out.println(galleryJson);
		int rs = galleryService.saveGallery(galleryJson);
		String saveRs = "";
		if (rs > 0) {
			saveRs = "发布成功"+rs+"张相片";
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
