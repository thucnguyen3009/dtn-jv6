package dtn.asm.controller.user;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dtn.asm.dao.AccountDAO;
import dtn.asm.dao.AddressDAO;
import dtn.asm.entity.Accounts;
import dtn.asm.entity.Address;
import dtn.asm.model.LoginForm;
import dtn.asm.model.SignUpForm;
import dtn.asm.model.UpdateAccountsForm;
import dtn.asm.service.AddressService;
import dtn.asm.service.SessionService;
import dtn.asm.service.impl.AccountServiceImpl;
import dtn.asm.service.impl.AddressServiceImp;

@Controller
public class AccountController {

	@Autowired
	HttpServletRequest req;

	@Autowired
	HttpServletResponse resp;

	@Autowired
	AccountDAO accountdao;

	@Autowired
	AccountServiceImpl accountsService;

	@Autowired
	AddressDAO addressDAO;

	@Autowired
	AddressServiceImp addressService;

	@Autowired
	SessionService session;

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
			String user = login.getUsername();
			String pass = login.getPass();

			Accounts acc = new Accounts();
			acc = accountsService.findById(user);

			if (acc instanceof Accounts) {
				if (pass.equals(acc.getPassword()) && acc.getActive()) {
					session.set("account", acc);

					m.addAttribute("message", "Đăng nhập thành công.");
					return "redirect:/index.html";
//				return "/user/home/index";
				}
			}
		}
		m.addAttribute("message", "123");
		return "user/home/login";
	}

//	Register page
	@GetMapping("/register.html")
	public String register(Model m, @ModelAttribute("signUpForm") SignUpForm signUp) {
		signUp = new SignUpForm();
		return "user/home/register";
	}

	@RequestMapping("/logout.html")
	public String logout() {
		session.remove("account");
		return "redirect:/index.html";
	}

	@PostMapping("/register.html")
	public String regiterUpdate(Model m, @Valid @ModelAttribute("signUpForm") SignUpForm signUp, Errors errors) {

		Optional<Accounts> account = accountdao.findById(signUp.getUsername());
		String account_email = accountdao.findEmail(signUp.getEmail());
		String account_phone = accountdao.findPhone(signUp.getPhone());
		int loi = 0;
		if (errors.hasErrors()) {
			loi++;
		}
		if (account.isPresent()) {
			loi++;
			m.addAttribute("mess1", "Tên đăng nhập đã được sử dụng");
		}
		if (account_email != null) {
			m.addAttribute("mess2", "Email đã được sử dụng");
			loi++;
		}
		if (account_phone != null) {
			m.addAttribute("mess3", "Số điện thoại đã được sử dụng");
		}
		String sdt = signUp.getPhone();
		String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
		if (!sdt.matches(reg)) {
			m.addAttribute("mess5", "Số điện thoại không hợp lệ");
			loi++;
		}
		if (!signUp.getPassword().equals(signUp.getPassword2())) {
			m.addAttribute("mess4", "Vui lòng kiểm tra lại mật khẩu");
			loi++;
		}
		if (loi == 0) {
			Accounts acc = new Accounts();
			acc.setUsername(signUp.getUsername());
			acc.setFullname(signUp.getFullname());
			acc.setPhone(signUp.getPhone());
			acc.setPassword(signUp.getPassword());
			acc.setPhoto("abc.jpg");
			acc.setEmail(signUp.getEmail());
			accountdao.save(acc);
			m.addAttribute("mess6", "Đăng ký thành công");
		}
		return "user/home/register";
	}

//	Change Pass page
	@RequestMapping("/changepass.html")
	public String changepass() {
		return "user/home/changepass";
	}

//	Forgot password page
	@GetMapping("/forgot-password.html")
	public String forgot_password() {
		return "user/home/forgot-password";
	}

	@PostMapping("/forgot-password.html")
	public String forgot_password_post(Model m) {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		Accounts account = accountdao.getById(username);
		if (account.getUsername().equals(username) && account.getEmail().equals(email)) {
			String pass = account.getPassword();
			// Gửi mật khẩu qua mail
			Properties pros = new Properties();
			pros.setProperty("mail.smtp.auth", "true");
			pros.setProperty("mail.smtp.starttls.enable", "true");
			pros.setProperty("mail.smtp.host", "smtp.gmail.com");
			pros.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
			pros.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			pros.setProperty("mail.smtp.port", "587");
			// Kết nối
			Session session = Session.getInstance(pros, new Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					String username = "phuchtpc01818@fpt.edu.vn";
					String password = "aorpgikdpdaojcfk";
					return new javax.mail.PasswordAuthentication(username, password);
				}
			});
			try {
				Multipart multipart = new MimeMultipart();
				MimeBodyPart bodytext = new MimeBodyPart();
				bodytext.setText("Mật khẩu của bạn là: " + pass, "utf-8");
				multipart.addBodyPart(bodytext);

				MimeMessage mess = new MimeMessage(session);
				mess.setFrom(new InternetAddress("phuchtpc01818@fpt.edu.vn"));
				mess.setRecipients(Message.RecipientType.TO, req.getParameter("email"));
				mess.setSubject("PASSWORD RETRIEVAL", "utf-8");
				mess.setReplyTo(mess.getFrom());
				mess.setContent(multipart);
				Transport.send(mess);
				m.addAttribute("mess", "Mật khẩu đã được gửi đến email của bạn");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "user/home/forgot-password";
	}

//	Update account page
	@GetMapping("/update_account.html")
	public String getUpdateAccount(Model m, @ModelAttribute("updateAccount") UpdateAccountsForm form,@RequestParam("tb") Optional<String> tb) {
		Accounts acc = session.get("account");
		if (acc == null) {
			return "redirect:/index.html?error=NotLogin";
		}
		if(tb.isPresent()) {
			if(tb.get().contains("success")) {
				m.addAttribute("alert","alert-success");
				m.addAttribute("message","Xóa địa chỉ thành công");
			}else if(tb.get().contains("error")) {
				m.addAttribute("alert","alert-danger");
				m.addAttribute("message","Không tìm thấy địa chỉ cần xóa");
			}
		}
		form.setFullname(acc.getFullname());
		form.setEmail(acc.getEmail());
		form.setPhone(acc.getPhone());
		form.setPhoto(acc.getPhoto());
		return "user/home/update-account";
	}

	@PostMapping("/update_account.html")
	public String postUpdateAccount(Model m, @Valid @ModelAttribute("updateAccount") UpdateAccountsForm form,
			Errors error){
		if (!error.hasErrors()) {
			Accounts acc = session.get("account");
			acc.setFullname(form.getFullname());
			acc.setEmail(form.getEmail());
			acc.setPhone(form.getPhone());
			accountsService.update(acc);
			m.addAttribute("alert","alert-success");
			m.addAttribute("message", "Cập nhật thông tin thànhh công");
		}
		return "user/home/update-account";
	}

	@RequestMapping("/update_account.html/delete/{id}")
	public String getDeleteAccount(Model m, @PathVariable("id") Optional<String> id) {
		if (id.isPresent()) {
			try {
				int ma = Integer.parseInt(id.get());
				Accounts acc = session.get("account");
				Optional<Address> adr = addressDAO.findById(ma);
				List<Address> list = (List<Address>) m.getAttribute("listAddress");
				if (adr.isPresent() && adr.get().getUserAr().getUsername().equals(acc.getUsername())) {
					if (list.size() == 1) {
						return "redirect:/update_account.html?tb=error";
					} else {
						addressService.delete(ma);
						return "redirect:/update_account.html?tb=success";
					}
				} else {
					return "redirect:/update_account.html?tb=error";
				}
			} catch (NumberFormatException e) {
				return "redirect:/update_account.html?tb=error";
			}
		}
		return "redirect:/update_account.html?tb=error";
	}

	@ModelAttribute("listAddress")
	public List<Address> getListAddress() {
		Accounts acc = session.get("account");
		return addressDAO.findByUsername(acc, null);
	}

}
