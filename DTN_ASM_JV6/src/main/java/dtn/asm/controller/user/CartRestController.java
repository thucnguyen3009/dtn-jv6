package dtn.asm.controller.user;

import java.io.File;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dtn.asm.entity.Accounts;
import dtn.asm.entity.Cart;
import dtn.asm.entity.Products;
import dtn.asm.service.FileManagerService;
import dtn.asm.service.SessionService;
import dtn.asm.service.impl.ProductsServiceImp;
import dtn.asm.service.impl.ShoppingCartServiceImpl;

@RestController
public class CartRestController {
	@Autowired
	ShoppingCartServiceImpl cart;
	@Autowired
	ProductsServiceImp daoProduct;
	@Autowired
	SessionService session;

//	@GetMapping("/update_account.html/{folder}/{file}")
//	public byte[] download(@PathVariable("folder") String folder,@PathVariable("file") String file) {
//		return fileService.read(folder, file);
//	}
//	
	@RequestMapping("/addToCart/{id}")
	public List<Cart> addToCart(@PathVariable("id") Integer id) {
		Accounts acc = session.get("account");
		cart.add(1, daoProduct.findById(id), 1, acc);
		return cart.getCarts(acc);
	}
	
	@GetMapping("/listCart")
	public List<Cart> listCart() {
		Accounts acc = session.get("account");
		
		return cart.getCarts(acc);
	}


}
