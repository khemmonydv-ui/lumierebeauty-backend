package com.flashsolution.lumierebeauty.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "order_items")
public class OrderItem {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "customer_orders_id") 
    private Order order;
    // @ManyToOne 
    // @JoinColumn(name = "customer_products_id")
    // private Product product;

    private Integer quantity;

    private BigDecimal unitPrice;
    private BigDecimal subTotal;

    // GETTERS
    public Long getId() {
        return id;
    }
    public Order getOrder() {
        return order;
    }
    // public Product getProduct() {
    //     return product;
    // }
    public Integer getQuantity() {
        return quantity;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    // public void setProduct(Product product) {
    //     this.product = product;
    // }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setUnitPrice(BigDecimal unit_price) {
        this.unitPrice = unit_price;
    }
    public void setSubTotal(BigDecimal sub_total) {
        this.subTotal = sub_total;
    }
}
