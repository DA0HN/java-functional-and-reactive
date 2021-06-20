package com.da0hn.usecases.fluentinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author daohn
 * @since 20/06/2021
 */
class Order {

  private List<String> cart = new ArrayList<>();
  private String address = "";

  public Order() {
  }

  public Order(List<String> cart, String address) {
    this.cart = cart;
    this.address = address;
  }

  public Order add(String item) {
    cart.add(item);
    System.out.println(item + " added to the cart");
    return new Order(this.cart, this.address);
  }

  public Order deliverAt(String location) {
    this.address = location;
    System.out.println("The delivery address set by you is '" + location + "'");
    return new Order(this.cart, this.address);
  }

  public static void place(Function<Order, Order> function) {
    Order order = function.apply(new Order());

    System.out.println("Order placed!");
    System.out.println(order.cart.size() + " items ordered by you will be delivered at " + order.address + " tomorrow!");
  }
}
