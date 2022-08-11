package dtn.asm.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dtn.asm.dao.OrderDetailsDAO;
import dtn.asm.dao.OrdersDAO;
import dtn.asm.entity.Accounts;
import dtn.asm.entity.OrderDetails;
import dtn.asm.entity.Orders;
import dtn.asm.service.OrderDetailsService;
import dtn.asm.service.OrdersService;
import dtn.asm.service.SessionService;

@Controller
public class OrderController {
	
	@Autowired
	OrdersDAO orderdao;
	@Autowired 
	SessionService session;
	@Autowired
	OrdersService orderservice;
	@Autowired
	OrderDetailsService orderdetailsservice;
	@Autowired
	OrderDetailsDAO orderdetaildao;

	// Checkout page
	@RequestMapping("/checkout.html")
	public String checkoutPage() {
		return "user/order/checkout";
	}

	// Order Manager
//	@RequestMapping("/orders.html")
//	public String ordersPage() {
//		return "user/order/orders";
//	}

//	 Order Details Manager
	@GetMapping("/order_details.html")
	public String orderDetailsPage(Model m, @RequestParam("id") Integer id) {
		Accounts account = session.get("account");
		List<OrderDetails> details=orderdetaildao.find_Order_details(id);
		m.addAttribute("details",details);	
		
		//thông tin khách hàng
		List<Orders> order_all=orderdao.find_LoginbyUsername(account.getUsername());
		m.addAttribute("or", order_all);
		return "user/order/order-details";
	}
	
	//Order page
	@GetMapping("/orders.html")
	public String order_Get(Model m) {
		Accounts account = session.get("account");
		List<Orders> order_all=orderdao.find_LoginbyUsername(account.getUsername());
		m.addAttribute("or", order_all);
		return "user/order/orders";
	}
	
	
	
}
