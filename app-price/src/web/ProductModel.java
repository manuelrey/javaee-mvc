package web;

import java.util.ArrayList;
import java.util.List;

import line.product.Product;

public class ProductModel {
	
	private String keyWord;
	private List<Product> products=new ArrayList<Product>();
	
	public String getkeyWord() {
		return keyWord;
	}
	public void setkeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
