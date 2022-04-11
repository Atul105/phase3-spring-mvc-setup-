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
	List<Product> productsList = template.query("select * from product_data", new RowMapper<Product>() {
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
//update product
//delete product
}
