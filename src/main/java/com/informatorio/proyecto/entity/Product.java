package com.informatorio.proyecto.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String content;
    @NotBlank
    @Positive
    @Min(value = 0)
    private BigDecimal price;
    @CreationTimestamp
    private LocalDateTime dateProduct;
    private Boolean productStock;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getProductStock() {
        return productStock;
    }
    public void setProductStock(Boolean productStock) {
        this.productStock = productStock;
    }

    public LocalDateTime getDateProduct() {
        return dateProduct;
    }
    public void setDateProduct(LocalDateTime dateProduct) {
        this.dateProduct = dateProduct;
    }
}






















