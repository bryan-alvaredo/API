package com.informatorio.proyecto.controller;

import com.informatorio.proyecto.entity.Cart;
import com.informatorio.proyecto.entity.CartLine;
import com.informatorio.proyecto.entity.Product;
import com.informatorio.proyecto.entity.User;
import com.informatorio.proyecto.repository.CartRepository;
import com.informatorio.proyecto.repository.ProductRepository;
import com.informatorio.proyecto.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CartController {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartController(UserRepository userRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/user/{id}/cart")
    public ResponseEntity<?> createCart(@PathVariable("id") Long userId,
                                        @Valid @RequestBody Cart cart) {
        User user = userRepository.getById(userId);
        cart.setUser(user);
        return new ResponseEntity<>(cartRepository.save(cart), HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}/cart/{idCart}")
    public ResponseEntity<?> addProduct(@PathVariable("id") Long userId,
                                        @PathVariable("idCart") Long cartId,
                                        @Valid @RequestBody CartOperation cartOperation) {
        Cart cart = cartRepository.getById(cartId);
        Product product = productRepository.getById(cartOperation.getProductId());
        CartLine cartLine = new CartLine();
        cartLine.setCart(cart);
        cartLine.setProduct(product);
        cartLine.setAmount(cartOperation.getAmount());
        cart.cartLineAdd(cartLine);
        return new ResponseEntity<>(cartRepository.save(cart), HttpStatus.CREATED);
    }

    @DeleteMapping("/user({id}/cart/{idCart}/line/{idLine}}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long userId,
                                           @PathVariable("idCart") Long idCart,
                                           @PathVariable("idCart") Long idLine) {
        return null;
    }
}





























