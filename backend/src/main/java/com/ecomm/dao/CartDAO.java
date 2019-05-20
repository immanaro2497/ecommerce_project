package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Cart;

public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> getCarts(String username);
	public List<Cart> getPaidCarts(String username);
    public Cart getCart(int cartId);
}
