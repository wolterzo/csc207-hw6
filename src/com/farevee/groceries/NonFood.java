package com.farevee.groceries;

public class NonFood
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Name of the NonFood item 
   */
  String name;
  /**
   * Weight of the NonFood item
   */
  Weight weight;
  /**
   * Price of the NonFood item
   */
  int price;
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public NonFood(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  } // NonFodd(String, Weight, int)
  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
  
  /**
   * Determines the weight of the item
   */
  public Weight getWeight()
  {
    return this.weight;
  } // getWeight()

  /**
   * Determines the price of the item
   */
  public int getPrice()
  {
    return this.price;
  } // getPrice()
  
  /**
   * Returns a string representation of the item
   */
  public String toString()
  {
    return this.name;
  } // toString()
} // class NonFood
