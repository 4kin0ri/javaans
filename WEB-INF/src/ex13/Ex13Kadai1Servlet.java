package ex13;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex13Kadai1Servlet
 */
@WebServlet("/ex13/Ex13Kadai1Servlet")
public class Ex13Kadai1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex13Kadai1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		/**
		 * ポイント: EmployeesDAO2１を空のコンストラクタによってインスタンス化してください．
		 */
		EmployeesDAO2 dao = new EmployeesDAO2();
		/**
		 * ポイント: daoから，DBにあるemployee_id, first_name, last_nameを取得する
		 * メソッドを呼び出して，listへ格納させてください．
		 * EmployeesDAO2クラスを見てからメソッド名を書いてください．
		 */
		ArrayList<EmployeesDTO> list = dao.selectBasicInfo();
		try {

			/**
			 * ポイント: requestにおいて，"retList"という名前で，listをセット
			 * させてください．(setAttributeメソッドを呼び出す）
			 */
			request.setAttribute("retList", list);
			String path = "/WEB-INF/ex13/ex13kadai1result.jsp";
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
