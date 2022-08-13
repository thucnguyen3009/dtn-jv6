package dtn.asm.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dtn.asm.entity.Accounts;
import dtn.asm.entity.Cart;
import dtn.asm.entity.Products;
import dtn.asm.service.ProductsService;
import dtn.asm.service.SessionService;
import dtn.asm.service.impl.CartServiceImp;
import dtn.asm.service.impl.ShoppingCartServiceImpl;

@CrossOrigin("*")
@RestController
public class CartRestController {
	@Autowired
	ShoppingCartServiceImpl cart;
	@Autowired
	CartServiceImp cartService;
	@Autowired
	ProductsService daoProduct;
	@Autowired
	SessionService session;

	RestTemplate resp = new RestTemplate();

	@RequestMapping("/rest/Cart/create/{id}")
	public ResponseEntity<List<Cart>> addToCart(@PathVariable("id") Optional<Integer> id) {
		Accounts acc = session.get("account");
		if (id.isPresent()) {
			Products pro = daoProduct.findById(id.get());
			cart.add(1, pro, 1, acc);
		} else {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cart.getCarts(acc));
	}
	@GetMapping("/rest/Cart/delete/{id}")
	public ResponseEntity<List<Cart>> deleteToCart(@PathVariable("id") Optional<Integer> id) {
		Accounts acc = session.get("account");
		if (id.isPresent()) {
			Cart cartF = cartService.findById(id.get());
			if(cartF.getUserCart().getUsername().equals(acc.getUsername())) {
				cart.remove(id.get());
			}else {
				return ResponseEntity.notFound().build();
			}
		} else {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cart.getCarts(acc));
	}

	@GetMapping("/rest/Cart/listCart")
	public ResponseEntity<List<Cart>> listCart() {
		Accounts acc = session.get("account");
		return ResponseEntity.ok(cart.getCarts(acc));
	}

}
