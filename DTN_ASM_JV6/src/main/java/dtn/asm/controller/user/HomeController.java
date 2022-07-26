package dtn.asm.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/DTNsBike")
public class HomeController {

	@RequestMapping("/index.html")
	public String index() {
		
		return "/user/home/index";
	}
	
	@RequestMapping("/shop.html")
	public String shopPage() {
		return "/user/home/shop";
	}
}
