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
   * Returns a string representation of the weight. (amount + abbrev)
   */
  public String toString()
  {
    return this.amount() + ' ' + this.unit().abbrev();
  } // toString()
} // class Weight
