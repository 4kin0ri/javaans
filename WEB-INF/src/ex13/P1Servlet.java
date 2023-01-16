package ex13;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class P1Servlet
 */
@WebServlet("/ex13/P1Servlet")
public class P1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public P1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeesDAO dto = new EmployeesDAO();
		ResultSet rs = dto.selectAll();
		try {
			//結果格納用のリスト
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

			while(rs.next()) {
				/**
				 * employee_id, first_name, last_nameをそれぞれ，rsのgetStringメソッドによってそれぞれ
				 * 取得して格納させる．
				 */
				HashMap<String, String> map = new HashMap<String, String>();
				String id = rs.getString("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				//Mapに格納する．
				map.put("employee_id",  id);
				map.put("first_name", first_name);
				map.put("last_name", last_name);
				//Mapをlistへ追加する．
				list.add(map);

			}
			//あとは，JSP側へ渡す．
			request.setAttribute("retList", list);
			String path = "/WEB-INF/ex13/p1result.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
