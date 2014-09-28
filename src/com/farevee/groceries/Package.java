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
   * Determines the name of the Package
   */
  public String getName()
  {
    return this.name;
  } // getName()
  
  /**
   * Determine the String representation of Package
   */
  @Override
  public String toString()
  {
    return this.weight.toString() + " package of " + this.name;
  } // toString()

  /**
   * Determine if this is equal to other, a Package
   * @param other
   * @return a boolean
   */
  public boolean equals(Package other)
  {
    return (other.name.equals(this.name)) && (other.weight.equals(this.weight))
           && (other.price == this.price);
  } // equals(Package)

  /**
   * Determine if this is equal to other, an object
   */
  public boolean equals(Object other)
  {
    if (this == other)
      {
        return true;
      } // if
    else if (other instanceof Package)
      {
        return this.equals((Package) other);
      } // else if
    else
      {
        return false;
      } // else
  } // equals(Object)

} // class Package
