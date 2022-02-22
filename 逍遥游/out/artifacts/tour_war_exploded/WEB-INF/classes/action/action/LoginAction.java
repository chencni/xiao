package action.action;


import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		String email = request.getParameter("loginEmail");
		String pwd = request.getParameter("loginPwd");
		String quckLogin = request.getParameter("quckLogin");
		String curUrl = request.getParameter("curUrl");
		String userName = userService.checkLogin(email, pwd);
		System.out.println("curUrl="+curUrl);
		if (userName != null) {
			request.setAttribute("loginTip", "登录成功");
			request.getSession().setAttribute("userName", userName);
			String userId=userService.getUserId(email);
			request.getSession().setAttribute("userName", userName);
			request.getSession().setAttribute("userId", userId);//发新闻知道是谁
			if (curUrl != null && quckLogin!=null)//快速登录成功转跳到当前页面
				request.getRequestDispatcher(curUrl).forward(request, response); 
			else {//注册页面登录转跳到新闻页面
				request.getRequestDispatcher("Home.html").forward(request, response);
			}
		} else {//登录失败，跳到注册登录页面并提示
			request.setAttribute("loginTip", "登录失败");
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}
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
