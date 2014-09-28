package com.farevee.groceries;

public class Weight
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The unit the weight is measured in. 
   */
  Units unit;
  /**
   * The number of units the weight has.
   */
  int amount;
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public Weight(Units unit, int amount)
  {
    this.unit = unit;
    this.amount = amount;
  } // Weight
  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Determine the unit of the weight. 
   * @return
   */
  public Units unit()
  {
    return this.unit;
  } // unit()
  
  /**
   * Determines the amount of the weight.
   * @return
   */
  public int amount()
  {
    return this.amount;
  } // amount()
  
  /**
   * Adds a specified amount to the weight
   * @param amount, and int
   */
  public void addWeight(int amount)
  {
    this.amount += amount;
  } // addWeight(int)
    
  /**
   * Returns a string representation of the weight. (amount + abbrev)
   */
  public String toString()
  {
    return this.amount + this.unit().abbrev();
  } // toString()
  
  /**
   * Determines if this has fields equal to other, a Weight Object.
   */
  public boolean equals(Weight other)
  {
    return this.unit.equals(other.unit) && this.amount == other.amount;
  } // equals(Weight)
  
  /**
   * Determines if this is equal to other, an object
   */
  public boolean equals(Object other)
  {
    if (this == other)
      {
        return true;
      }
    else if (other instanceof Weight)
      {
        return this.equals((Weight) other);
      } // else if
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class Weight
