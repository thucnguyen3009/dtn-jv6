package dtn.asm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dtn.asm.service.SessionService;

@Controller
@RequestMapping("/DTNsBike")
public class HomeController {
	@Autowired
	SessionService session;
	
//	Index Page :))
	@RequestMapping("/index.html")
	public String index() {
		
		return "/user/home/index";
	}
//	About page
	@RequestMapping("/about.html")
	public String about(Model m) {
		
		m.addAttribute("ab","active");
		return "/user/home/about";
	}
//	Contact page
	@RequestMapping("/contact.html")
	public String contact(Model m) {
		
		m.addAttribute("ct","active");
		return "/user/home/contact";
	}
//	Product page
	@RequestMapping("/shop.html")
	public String shopPage(Model m) {
		
		m.addAttribute("sp","active");
		return "/user/home/shop";
	}
//	Product details page
	@RequestMapping("/product.html")
	public String product() {
		return "/user/home/product";
	}
	

}
