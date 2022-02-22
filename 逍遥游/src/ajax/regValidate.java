package ajax;

import org.json.JSONObject;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class regValidate
 */
@WebServlet("/regValidate")
public class regValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regValidate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass="";
		String tip="";
		String email=request.getParameter("email");
		UserService user=new UserService();
		if(user.checkEmail(email)){
			pass="true";
			tip="该邮箱可以使用！";
		}else{
			pass="false";
			tip="该邮箱已被注册！";
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8 ");
		JSONObject jso = new JSONObject();
		jso.put("pass", pass);
		jso.put("tip", tip);
		PrintWriter writer = response.getWriter();
		writer.append(jso.toString());
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
