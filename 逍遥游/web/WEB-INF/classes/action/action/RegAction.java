package action.action;

import model.Account;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class RegAction
 */
@WebServlet("/RegAction")
public class RegAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取出参数，构造user
		Account account = new Account();
		UserService userService = new UserService();
		account.setCreatTime(new Date());
		account.setUserName(request.getParameter("userName"));
		account.setEmail(request.getParameter("email"));
		account.setMobile(request.getParameter("mobile"));
		account.setSex(request.getParameter("sex"));
		account.setPassword(request.getParameter("pwd"));

		// 后台校验...
		boolean isReg=false;
		String regTip = "";
		if (!userService.checkEmail(account.getEmail())) {
			regTip = "邮箱已注册，注册失败！";
			System.out.println(regTip);
		} else {
			if (userService.reg(account)) {
				regTip = "注册成功";
				System.out.println(regTip);
				isReg=true;
			} else {
				regTip = "注册失败";
				System.out.println(regTip);
			}
		}
		request.setAttribute("regTip", regTip);
		request.setAttribute("isReg", isReg);
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json;charset=utf-8 ");
//		JSONObject jso = new JSONObject();
//		jso.put("isReg", isReg);
//		jso.put("regTip", regTip);
//		PrintWriter writer = response.getWriter();
//		writer.append(jso.toString());
//		writer.flush();
		request.getRequestDispatcher("account.jsp").forward(request, response);
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
