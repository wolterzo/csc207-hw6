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
   * Determines the name of the item
   */
  public String getName()
  {
    return this.name;
  } // getName()
  
  /**
   * Returns a string representation of the item
   */
  public String toString()
  {
    return this.name;
  } // toString()

  /**
   * Determine if this is equal to other, a NonFood object
   * @param other
   * @return boolean
   */
  public boolean equals(NonFood other)
  {
    return this.name.equals(other.name) && this.weight.equals(other.weight)
           && this.price == other.price;
  } // equals(NonFood)
  
  public boolean equals(Object other)
  {
    if (this == other)
      {
        return true;
      } // if
    else if (other instanceof NonFood)
    {
      return this.equals((NonFood) other); 
    } // else if
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class NonFood
