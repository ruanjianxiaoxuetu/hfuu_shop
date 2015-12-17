package src.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.dbHandle.ShopCartHandle;
import src.tools.LoginVerify;
import src.vo.User;

/**
 * Servlet implementation class RemoveShopCartServlet
 */
@WebServlet("/RemoveShopCartServlet")
public class RemoveShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveShopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(1);       
		Integer    goodsId=Integer.parseInt(request.getParameter("goodsId"));
		          if (LoginVerify.isLogin(request)) {
		   User   loginUser = (User)request.getSession().getAttribute("loginUser");
		 int   loginUserId=loginUser.getId();
		 ShopCartHandle shopCartHandle=new ShopCartHandle();
		 try {
		if(shopCartHandle.removeList(goodsId, loginUserId)){
			response.getWriter().print("success");
			
		}else{
			response.getWriter().print("false");
		}
		} catch (Exception e) {
			
			e.printStackTrace();
			response.getWriter().print("false");
		}
		        	
		        }  else{
		        	response.getWriter().print("false");
		        	
		        }
		          
		          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
