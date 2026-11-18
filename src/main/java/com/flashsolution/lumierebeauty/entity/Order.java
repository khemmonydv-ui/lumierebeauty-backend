package com.flashsolution.lumierebeauty.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.flashsolution.lumierebeauty.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "customer_orders") 
public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  
    @JoinColumn(name = "customer_users_id")
    private User user;


    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String orderNumber;
    private String customerName;
    private String phoneNumber;
    private String shippingAddress;
    
    private BigDecimal subTotal;
    private BigDecimal shippingFee;
    private BigDecimal discount;
    private BigDecimal total;

    private LocalDateTime createdAt;
    

    // GETTERS
    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public BigDecimal getSubTotal() {
        return subTotal;
    }
    public BigDecimal getShippingFee() {
        return shippingFee;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
