package com.farevee.groceries;

public class Package
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Name of the package.
   */
  String name;
  /**
   * Weight of the package.
   */
  Weight weight;
  /**
   * Price of the package
   */
  int price;
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public Package(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  } // Package(String, Weight, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
  /**
   * Determine the weight of the package.
   */
  public Weight getWeight()
  {
    return this.weight;
  } // getWeight()

  /**
   * Determine the price of the package.
   */
  public int getPrice()
  {
    return this.price;
  } // getPrice()
  
  /**
   * Determine the String representation of Package
   */
  @Override
  public String toString()
  {
    return this.weight.toString() + " pacake of " + this.name;
  } // toString()
  
} // class Package
