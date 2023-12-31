package com.tindung.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productID;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate = new Date();

	@Column(name = "description")
	private String description;

	private String image;

	private Double price;

	@Column(name = "product_name")
	private String productName;

	private Integer quantity;

	@OneToMany(mappedBy = "product")
	private List<CartDetail> cartDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ProductReview> productReviews;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Comment> comment;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Inventory> inventory;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	@Lob
	@Column(name = "configuration")
	private String configuration;

	@Column(name = "active")
	private boolean active;

}