package dao;

import java.util.List;

import line.product.Product;

public interface IProductDao {
	
	public Product save(Product p);
	public List<Product> productsForMC(String mc);
	public Product getProduct(Long id);
	public Product update(Product p);
	public void deleteProduct(Long id);
	
}
