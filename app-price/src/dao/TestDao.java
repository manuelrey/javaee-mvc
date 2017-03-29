package dao;

import java.util.List;

import line.product.Product;

public class TestDao {
	
	public static void main(String[] args){
		ProductsDaoImpl dao=new ProductsDaoImpl();
		Product p1=dao.save(new Product("HP123", 900, 45));
		Product p2=dao.save(new Product("HP456", 800, 70));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("Search products");
		List<Product> prods=dao.productsForMC("%H%");
		for(Product p: prods){
			System.out.println(p.toString());
		}
	}	
}
