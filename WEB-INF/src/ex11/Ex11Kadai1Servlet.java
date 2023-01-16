package ex11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex11Kadai1Servlet
 */
@WebServlet("/ex11/Ex11Kadai1Servlet")
public class Ex11Kadai1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex11Kadai1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");

		//お菓子の値を取得
		/**
		 * ポイント: kadai1register.jspにて入力されたお菓子の値を取得するように，requestからパラメータ
		 * を取得して格納させてください（1行で）
		 */
		String val_okashi = request.getParameter("snack");
		//果物の値を取得
		/**
		 * ポイント: kadai1register.jspにて入力された果物の値を取得するように，requestからパラメータ
		 * を取得して格納させてください（1行で）
		 */
		String val_kudamono = request.getParameter("fruit");


		/**
		 * ポイント: 遷移先にて，"result_okashi"というキーで，val_okashiを取得できるように
		 * requestにおいて，(キー, 値) = ("result_okashi", val_okashi)をセットしてください．
		 */
		request.setAttribute("result_okashi", val_okashi);
		/**
		 * ポイント: 遷移先にて，"result_kudamono"というキーで，val_kudamonoを取得できるように
		 * requestにおいて，(キー, 値) = ("result_kudamono", val_kudamono)をセットしてください．
		 */
		request.setAttribute("result_kudamono", val_kudamono);

		/**
		 * ポイント: WebContentにある，WEB-INFのex11の，kadai1result.jspを呼び出すようにgetRequestDispatcher
		 *の引数を設定させてください．
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ex11/kadai1result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
