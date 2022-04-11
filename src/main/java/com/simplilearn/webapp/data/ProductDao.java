package com.simplilearn.webapp.data;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.webapp.model.Product;

public class ProductDao {
	
	
 JdbcTemplate template;
 
 public JdbcTemplate getTemplate() {
	 return template;
 }

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
 
 //list all product
public List<Product> getProducts(){
	
	String READ_PRODUCT = "select * from product_data";
	List<Product> productsList = template.query(READ_PRODUCT, new RowMapper<Product>() {
        //map result set row value to product object
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setCreatedAt(rs.getDate(4));
			
			return product;
		}
	});
	return productsList;
}
//create product
public int addProduct(Product product) {
	String ADD_PRODUCT = "insert into product_data(name,price) values(?, ?)";
	return template.update(ADD_PRODUCT,product.getName(), product.getPrice());
	}
   //update product
public int updateProduct(Product product) {
	String UPDATE_PRODUCT = "UPDATE product_data set name=?, price=? where id=?";
	return template.update(UPDATE_PRODUCT,product.getName(), product.getPrice(), product.getId());
	}
	//delete product
public int deleteProduct(Product product) {
	String DELETE_PRODUCT = "delete from product_data where id=?";
	return template.update(DELETE_PRODUCT,product.getId());
}
}
