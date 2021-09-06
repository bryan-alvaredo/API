package com.informatorio.proyecto.entity;

import com.informatorio.proyecto.util.ValidationHelper;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El campo no puede ser blanco o nulo")
    private String userName;
    @NotBlank(message = "El campo no puede ser blanco o nulo")
    private String firstName;
    @NotBlank(message = "El campo no puede ser blanco o nulo")
    private String lastName;
    @Column(unique = true)
    @Email(regexp = ValidationHelper.EMAIL_REGEX)
    private String email;
    @NotBlank
    private String pass;
    @CreationTimestamp
    private LocalDateTime dateUser;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @NotBlank
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public LocalDateTime getDateUser() {
        return dateUser;
    }
    public void setDateUser(LocalDateTime dateUser) {
        this.dateUser = dateUser;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void cartAdd(Cart cart) {
        carts.add(cart);
        cart.setUser(this);
    }
    public void cartRemove(Cart cart) {
        carts.remove(cart);
        cart.setUser(null);
    }
}



















