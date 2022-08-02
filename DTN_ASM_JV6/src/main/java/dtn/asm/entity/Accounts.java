package dtn.asm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts",
uniqueConstraints = { @UniqueConstraint(columnNames = { "[email]" }),@UniqueConstraint(columnNames = { "[phone]" }) })
public class Accounts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "[username]")
	 String username;

	@Column(name = "[password]")
	 String password;

	@Column(name = "[fullname]")
	 String Fullname;

	@Column(name = "[email]")
	 String email;

	@Column(name = "[photo]")
	 String photo;

	@Column(name = "[phone]")
	 String phone;

	@Column(name = "[acitve]")
	 Boolean active = true;

	@OneToMany(mappedBy = "userAuthor")
	List<Authorities> authorities;

	@OneToMany(mappedBy = "userCart")
	List<Cart> cart;

	@OneToMany(mappedBy = "userFvr")
	List<Favorites> favorites;

	@OneToMany(mappedBy = "userAr")
	List<Address> address;

	@OneToMany(mappedBy = "userOrder")
	List<Orders> order;

	@OneToMany(mappedBy = "userOtp")
	List<Otp> otp;

}