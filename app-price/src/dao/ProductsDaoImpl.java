package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import line.product.Product;

public class ProductsDaoImpl implements IProductDao {

	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		Connection connection=SingletonConnection.getConnection();
		try{
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO PRODUCTS (DESIGNATION, PRIX, QUANTITY) VALUES(?, ?, ?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate();
			PreparedStatement ps2=connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM PRODUCTS");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()){
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> productsForMC(String mc) {
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<Product>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("SELECT * FROM PRODUCTS WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantity(rs.getInt("QUANTITY"));
				//adjoin products to list
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		Product p=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("SELECT * FROM PRODUCTS WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				p=new Product();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantity(rs.getInt("QUANTITY"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Product update(Product p) {
		// TODO Auto-generated method stub
		Connection connection=SingletonConnection.getConnection();
		try{
			PreparedStatement ps=connection.prepareStatement
					("UPDATE SET PRODUCTS DESIGNATION=?, PRIX=?, QUANTITY=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantity());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		Connection connection=SingletonConnection.getConnection();
		try{
			PreparedStatement ps=connection.prepareStatement
					("DELETE FROM PRODUCTS WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}	
	}
}
