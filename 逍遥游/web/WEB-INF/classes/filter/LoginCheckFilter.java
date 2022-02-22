package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter({ "/LoginCheckFilter", "/SendNewsAction","/SendGalleryAction"})
public class LoginCheckFilter extends HttpServlet implements Filter {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheckFilter() {
		super();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();// session记录用户是否登录！！
		if (session.getAttribute("userName") != null) {
			System.out.println("已登录");
			chain.doFilter(request, response);// 放开可以通行
		} else {
			System.out.println("页面重定向用了一次");
			request.setAttribute("loginTip", "需要登录才有权限");
			//httpResponse.sendRedirect("account.jsp");// 这里跳转你需要的登录界面
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
