package com.informatorio.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Transient
    private String userName;
    /*generado por*/
    @CreationTimestamp
    private LocalDateTime dateCart;
    @NotBlank
    private BigDecimal total;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartLine> cartLines = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getDateCart() {
        return dateCart;
    }
    public void setDateCart(LocalDateTime dateCart) {
        this.dateCart = dateCart;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void cartLineAdd(CartLine cartLine) {
        cartLines.add(cartLine);
        cartLine.setCart(this);
    }
    public void cartLineRemove(CartLine cartLine) {
        cartLines.remove(cartLine);
        cartLine.setCart(null);
    }
}






















