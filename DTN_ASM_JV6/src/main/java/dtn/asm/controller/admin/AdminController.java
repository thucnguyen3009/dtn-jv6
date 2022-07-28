package dtn.asm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping({"/admin","/admin/home/index.html"})
	public String adminPage() {
		
		return "redirect:/assets/admin/index.html";
	}

}
