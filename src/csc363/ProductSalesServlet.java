package csc363;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductSalesServlet
 */
@WebServlet("/ProductSalesServlet")
public class ProductSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSalesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//create an array of products that are on sale
		product[] myProducts = getProductsOnSale();
		
		
		processRequestAndRespond(request, response, myProducts);
	}

	/**
	 * @param request
	 * @param response
	 * @param myProducts
	 * @throws ServletException
	 * @throws IOException
	 */
	//assistant function for processing a request and the response
	private void processRequestAndRespond(HttpServletRequest request, HttpServletResponse response,
			product[] myProducts) throws ServletException, IOException {
		//forward the request to the selected page
		String forwardingPage = "./ProductSalesDynamic.jsp";
		
		//add Products on sale to the session
		
		HttpSession mySession = request.getSession(); //get the session
		mySession.setAttribute("Products", myProducts); //set products to the Products attribute
		
		//get the username and add it to the session
		String pName = (String)request.getParameter("uname");
		mySession.setAttribute("UserName", pName);
		
		request.getRequestDispatcher(forwardingPage).forward(request, response);
	}

	/**
	 * @return
	 */
	private product[] getProductsOnSale() {
		product[] myProducts = new product[3];
		
		product p1 = new product();
		p1.setMfgName("Samsung");
		p1.setImagePath("http://images.samsung.com/is/image/samsung/uk-galaxy-j5-2017-j530fz-sm-j530fzkabtu-frontblack-68794892?$PD_GALLERY_JPG$");
		p1.setStorage("15GB");
		p1.setCost(199.0);
		
		product p2  = new product();
		p2.setMfgName("Apple");
		p2.setImagePath("https://devimages-cdn.apple.com/app-store/marketing/guidelines/images/thumbnail-iphone-se.png");
		p2.setStorage("32GB");
		p2.setCost(599.0);
		
		product p3  = new product();
		p3.setMfgName("Motorola");
		p3.setImagePath("https://cdn.posmicro.com/prodimages/mc75.gif");
		p3.setStorage("N/A");
		p3.setCost(99.0);
		
		//place products into the array
		myProducts[0] = p1;
		myProducts[1] = p2;
		myProducts[2] = p3;
		
		return myProducts;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
