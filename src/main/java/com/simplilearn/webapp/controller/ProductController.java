package com.simplilearn.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.webapp.data.ProductDao;
import com.simplilearn.webapp.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/list-products", method=RequestMethod.GET)
	public ModelAndView listProducts() {
		
		ModelAndView mv = new ModelAndView("list-products");
		List<Product> list = productDao.getProducts();
		mv.addObject("list", list);
		return mv;
}
	//add a product
	@RequestMapping(value="/add-product", method=RequestMethod.GET)
	public ModelAndView addProduct() {
		
		ModelAndView mv = new ModelAndView("add-product");
		Product product =new Product();
		mv.addObject("product", product);
		return mv;
}
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-response");
		productDao.addProduct(product);
		mv.addObject("action", "created"); //action is created
		return mv;
}
	//updating a product
	@RequestMapping(value="/update-product", method=RequestMethod.GET)
	public ModelAndView updateProduct() {
		
		ModelAndView mv = new ModelAndView("update-product");
		Product product =new Product();
		mv.addObject("product", product);
		return mv;
}
	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-response");
		productDao.updateProduct(product);
		mv.addObject("action", "updated"); //action is created
		return mv;
}
	//deleting a product
	
	@RequestMapping(value="/delete-product", method=RequestMethod.GET)
	public ModelAndView deleteProduct() {
		
		ModelAndView mv = new ModelAndView("delete-product");
		Product product =new Product();
		mv.addObject("product", product);
		return mv;
}
	@RequestMapping(value = "/delete-product", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("success-response");
		productDao.deleteProduct(product);
		mv.addObject("action", "deleted"); //action is "deleted"
		return mv;
}
}
