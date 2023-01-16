package ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/ex11/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//nameの値を取得
		String name = request.getParameter("name");
		//genderの値を取得．Stringで取得するので，それをint型に変換しておく．
		int gender = Integer.valueOf(request.getParameter("gender")).intValue();
		String str_gender = null;
		switch(gender) {
		case 0:
			str_gender = "男性";
			break;
		case 1:
			str_gender = "女性";
			break;
		default:
			break;

		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("名前:"+name+"<br>");
		out.println("性別:"+str_gender + "<br>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
