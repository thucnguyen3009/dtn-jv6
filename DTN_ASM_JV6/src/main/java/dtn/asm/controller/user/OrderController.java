package dtn.asm.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	// Checkout page
	@RequestMapping("/checkout.html")
	public String checkoutPage() {
		return "user/order/checkout";
	}

	// Order Manager
	@RequestMapping("/orders.html")
	public String ordersPage() {
		return "user/order/orders";
	}

	// Order Details Manager
	@RequestMapping("/order_details.html")
	public String orderDetailsPage() {
		return "user/order/order-details";
	}
}
