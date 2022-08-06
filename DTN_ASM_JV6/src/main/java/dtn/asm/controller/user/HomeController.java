package dtn.asm.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dtn.asm.dao.CategoriesDAO;
import dtn.asm.dao.ProductsDAO;
import dtn.asm.entity.Categories;
import dtn.asm.entity.ProductColor;
import dtn.asm.entity.Products;
import dtn.asm.service.CategoriesService;
import dtn.asm.service.ProductsService;
import dtn.asm.service.SessionService;
import dtn.asm.service.impl.CategoryServiceImp;

@Controller
public class HomeController {
	@Autowired
	SessionService session;
	@Autowired
	ProductsDAO productdao;
	@Autowired
	ProductsService productservice;
	@Autowired
	CategoryServiceImp categoriesservice;
	@Autowired
	CategoriesDAO cateDAO;

//	Index Page :))
	@RequestMapping("/index.html")
	public String index(Model m) {
		
		List<Products> product = productservice.findAll();
		m.addAttribute("product", product);
		
		List<Categories> categories = cateDAO.listCateInProduct();
		if (!categories.isEmpty()) {
			m.addAttribute("cate", categories);
		}

		return "/user/home/index";
	}

//	About page
	@RequestMapping("/about.html")
	public String about(Model m) {

		m.addAttribute("ab", "active");
		return "/user/home/about";
	}

//	Contact page
	@RequestMapping("/contact.html")
	public String contact(Model m) {

		m.addAttribute("ct", "active");
		return "/user/home/contact";
	}

//	Product page
	@RequestMapping("/shop.html")
	public String shopPage(Model m) {
		List<Products> product = productservice.findAll();
		m.addAttribute("product", product);

		List<Categories> categories = cateDAO.listCateInProduct();
		if (!categories.isEmpty()) {
			m.addAttribute("cate", categories);
		}
		
		m.addAttribute("sp","active");		
		return "/user/home/shop";
	}

//	Product details page
	@RequestMapping("/product.html")
	public String product(Model m, @RequestParam("id") Integer id) {
		Products product = productservice.findById(id);
		m.addAttribute("item", product);

		return "/user/home/product";
	}

}
