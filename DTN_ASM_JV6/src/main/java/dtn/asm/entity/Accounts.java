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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "[username]")
	private Integer username;

	@Column(name = "[password]")
	private String password;

	@Column(name = "[fullname]")
	private String Fullname;

	@Column(name = "[email]")
	private String Email;

	@Column(name = "[photo]")
	private String photo;

	@Column(name = "[phone]")
	private String phone;

	@Column(name = "[active]")
	private Boolean active = true;

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