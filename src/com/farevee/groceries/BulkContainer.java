package com.farevee.groceries;

public class BulkContainer
    extends BulkItem
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Container the BulkItem is in.
   */
  String container;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public BulkContainer(String container, BulkFood food, Units unit, int amount)
  {
    super(food, unit, amount);
    this.container = container;
  } // BulkContainer(String, BulkFood, Units, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
  /**
   * Returns a string representation of the item
   */
  public String toString()
  {
    return this.container + " of " + super.toString();
  } // toString()

  /**
   * Determines if this is equal to another BulkContainer
   * @param other
   * @return a boolean
   */
  public boolean equals(BulkContainer other)
  {
    return (this.container.equals(other.container)) && (other.food == this.food)
           && (other.unit == this.unit) && (other.amount == this.amount);
  } // equals(BulkContainer)
  
  /**
   * Determines if this is equal to other, an Object
   */
  public boolean equals(Object other)
  {
    if (this == other)
      {
        return true;
      } // if
    else if (other instanceof BulkContainer)
      {
        return this.equals((BulkContainer) other);
      } // else if
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class BulkContainer
