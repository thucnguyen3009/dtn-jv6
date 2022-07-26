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
	@RequestMapping("/about.html")
	public String about() {
		return "/user/home/about";
	}
	@RequestMapping("/contact.html")
	public String contact() {
		return "/user/home/contact";
	}
	@RequestMapping("/product.html")
	public String product() {
		return "/user/home/product";
	}
	@RequestMapping("/login.html")
	public String login() {
		return "user/home/login";
	}
	@RequestMapping("/register.html")
	public String register() {
		return "user/home/register";
	}
	@RequestMapping("/changepass.html")
	public String changepass() {
		return "user/home/changepass";
	}
	@RequestMapping("/forgot-password.html")
	public String forgot_password() {
		return "user/home/forgot-password";
	}

}
