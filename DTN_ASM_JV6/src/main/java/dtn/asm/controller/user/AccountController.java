package dtn.asm.controller.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dtn.asm.dao.AccountDAO;
import dtn.asm.entity.Accounts;
import dtn.asm.model.LoginForm;
import dtn.asm.model.SignUpForm;

@Controller
@RequestMapping("/DTNsBike")
public class AccountController {

	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;
	@Autowired
	AccountDAO accountdao;

//	Login Page
	@GetMapping("/login.html")
	public String getLogin(Model m) {
		LoginForm login = new LoginForm();
		m.addAttribute("loginForm", login);
		return "user/home/login";
	}

	@PostMapping("/login.html")
	public String postLogin(Model m, @Valid @ModelAttribute("loginForm") LoginForm login, Errors errors) {
		if (!errors.hasErrors()) {
			return "/user/home/index";
		}
		return "user/home/login";
	}

//	Register page
	@GetMapping("/register.html")
	public String register(Model m, @ModelAttribute("signUpForm") SignUpForm signUp) {
		signUp = new SignUpForm();
		return "user/home/register";
	}

	@PostMapping("/register.html")
	public String regiterUpdate(Model m, @Valid @ModelAttribute("signUpForm") SignUpForm signUp, Errors errors) {
//		String usernameR = req.getParameter("username");
//		String passwordR = req.getParameter("pass");
//		String passwordR2 = req.getParameter("pass2");
//		String fullname = req.getParameter("fullname");
//		String phone = req.getParameter("phone");
//		String email = req.getParameter("email");
//		Optional<Accounts> account = accountdao.findById(usernameR);
//		String account_email = accountdao.findEmail(email);
//		String account_phone = accountdao.findPhone(phone);
//		int loi = 0;
		if (errors.hasErrors()) {
//			if (account != null) {
//				loi++;
//				m.addAttribute("mess1", "Tên đăng nhập đã được sử dụng");
//			}
//			if (account_email != null) {
//				m.addAttribute("mess2", "Email trùng");
//				loi++;
//			}
//			if (account_phone != null) {
//				m.addAttribute("mess2", "Phone trùng");
//			} else if (!passwordR.equalsIgnoreCase(passwordR2)) {
//				m.addAttribute("mess2", "Vui lòng kiểm tra lại mật khẩu");
//				loi++;
//			}
		}
//		if (loi == 0) {
//			Accounts acc = new Accounts();
//			acc.setUsername(usernameR);
//			acc.setFullname(fullname);
//			acc.setPhone(phone);
//			acc.setPassword(passwordR2);
//			acc.setPhoto("abc.jpg");
//			acc.setEmail(email);
//			accountdao.save(acc);
//			m.addAttribute("mess2", "Đăng ký thành công");
//		}
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

//	@GetMapping("/DTNsBike/register.html")
//	public String dangky(Model m, @ModelAttribute ("acc") Accounts account) {
//		
//		return "user/home/register";
//	}
//	
//	@PostMapping("/DTNsBike/register.html")
//	public String dangky(Model m, @Valid @ModelAttribute Accounts account, Error errors) {
//		
//		return "user/home/register";
//	}

}
