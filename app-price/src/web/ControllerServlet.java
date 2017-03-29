package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProductDao;
import dao.ProductsDaoImpl;
import line.product.Product;

public class ControllerServlet extends HttpServlet{
	private IProductDao line;
	
	public void init() throws ServletException{
		line = new ProductsDaoImpl();
	}
	
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		String path=request.getServletPath();
		if(path.equals("/index.php")){
			request.getRequestDispatcher("products.jsp").forward(request, response);
		}
		else if(path.equals("/search.php")){
			String keyWord=request.getParameter("keyWord");
			ProductModel model = new ProductModel();
			model.setkeyWord(keyWord);
			List<Product> products=line.productsForMC("%"+keyWord+"%");
			model.setProducts(products);
			request.setAttribute("model", model);
			request.getRequestDispatcher("products.jsp").forward(request, response);
		}
		else if(path.equals("/add.php")){
			request.setAttribute("product", new Product());
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
		else if(path.equals("/SaveProduct.php")&&(request.getMethod().equals("POST"))){
			String des=request.getParameter("designation");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			Product p=line.save(new Product(des, prix, quantity));
			request.setAttribute("product", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		else if(path.equals("/delete.php")){
			Long id=Long.parseLong(request.getParameter("id"));
			line.deleteProduct(id);
			//request.getRequestDispatcher("products.jsp").forward(request, response);
			response.sendRedirect("search.php?keyWord=");
		}
		else if(path.equals("/edit.php")){
			Long id=Long.parseLong(request.getParameter("id"));
			Product p=line.getProduct(id);
			request.setAttribute("product", p);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
		}
		else if(path.equals("/UpdateProduct.php")&&(request.getMethod().equals("POST"))){
			Long id=Long.parseLong(request.getParameter("id"));
			String des=request.getParameter("designation");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			Product p=line.save(new Product(des, prix, quantity));
			p.setId(id);
			line.update(p);
			request.setAttribute("product", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		else{
			response.sendError(Response.SC_NOT_FOUND);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			doGet(request, response);
	}
}
