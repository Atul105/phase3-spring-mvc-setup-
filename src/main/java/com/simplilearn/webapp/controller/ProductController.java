package com.simplilearn.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.webapp.data.ProductDao;
import com.simplilearn.webapp.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	@RequestMapping("/list-products")
	public ModelAndView indexMapping() {
		
		ModelAndView mv = new ModelAndView("list-products");
		List<Product> list = productDao.getProducts();
		mv.addObject("list", list);
		return mv;

}
}
