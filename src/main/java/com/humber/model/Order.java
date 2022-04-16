package com.humber.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "product_id")
    private Long product_id;
    
    @Column(name = "total")
    private double total;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "status")
    private String status;

	public Order(Long id, Long product_id, double total, int quantity, Date date, String status) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.total = total;
		this.quantity = quantity;
		this.date = date;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
