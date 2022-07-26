package dtn.asm.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/DTNsBike")
public class CartController {

// Cart page
	@RequestMapping("/cart.html")
	public String cartPage() {
		return "user/cart/cart";
	}

}
