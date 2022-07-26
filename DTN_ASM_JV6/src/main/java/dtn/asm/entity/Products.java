package dtn.asm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "[id]")
	private Integer id;
	
	@Column(name = "[name]")
	private String name;
	
	@Column(name = "[price]")
	private Double price;
	
	@Column(name = "[createdate]")
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	@Column(name = "[avaliable]")
	private Boolean avaliable;
	
	@Column(name = "[sale]")
	private Double sale;
	
	@ManyToOne
	@JoinColumn(name = "[categoryid]")
	private Categories catePro;
	
	@Column(name = "[description]")
	private String description;
	
	@Column(name = "[quantyti]")
	private Integer qty;
	
	@ManyToOne
	@JoinColumn(name = "[brandid]")
	private Brand brandPro;

	@Column(name = "[madein]")
	private String madein;
	
	@Column(name = "[image]")
	private String img;
	
	@OneToMany(mappedBy = "product")
	List<PriceHistory> priceHistories;
	
	@OneToMany(mappedBy = "imgPro")
	List<ProductImg> productImgs; 
	
	@OneToMany(mappedBy = "products")
	List<ProductColor> productColors;
	
	@OneToMany(mappedBy = "productsId")
	List<OrderDetails> orderDetails;
	
	@OneToMany(mappedBy = "proCart")
	List<Cart> carts;
	
	@OneToMany(mappedBy = "productsId")
	List<Favorites> favorites;
	
}