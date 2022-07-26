package dtn.asm.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/DTNsBike")
public class AccountController {

//	Login Page
	@RequestMapping("/login.html")
	public String login() {
		return "user/home/login";
	}
//	Register page
	@RequestMapping("/register.html")
	public String register() {
		return "user/home/register";
	}
//	Change Pass page
	@RequestMapping("/changepass.html")
	public String changepass() {
		return "user/home/changepass";
	}
//	Forgot password page
	@RequestMapping("/forgot-password.html")
	public String forgot_password() {
		return "user/home/forgot-password";
	}
//	Update account page
	@RequestMapping("/update_account.html")
	public String updateAccount() {
		
		return "user/home/update-account";
	}

}
