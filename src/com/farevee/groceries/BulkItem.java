package com.farevee.groceries;

public class BulkItem
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * type of BulkFood BulkItem is.
   */
  BulkFood food;
  /**
   * Unit BulkItem is measured in
   */
  Units unit;
  /**
   * Number of units there are of BulkItem
   */
  int amount;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public BulkItem(BulkFood food, Units unit, int amount)
  {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  } // BulkItem(BulkFood, Units, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  

  /**
   * Determines the weight of the BulkItem
   */
  public Weight getWeight()
  {
    return new Weight(this.unit, this.amount);
  } // getWeight()

  /**
   * Determines the price of the BulkItem
   */
  public int getPrice()
  {
    return this.food.pricePerUnit * this.amount;
  } // getPrice()

  /**
   * Return the string representation of BulkItem.
   */
  public String toString()
  {
    return this.amount + " " + this.unit.name + "s of " + this.food.name + "s";
  } // ToString()

  /**
   * Determines if this and a BulkItem have equal fields
   * @param obj, a BulkItem
   * @return a boolean
   */
  public boolean equals(BulkItem obj)
  {
    return (obj.food == this.food) && (obj.unit == this.unit)
           && (obj.amount == this.amount);
  } // equals(BulkItem)

  /**
   * Determine if this is equal to an object
   */
  public boolean equals(Object other)
  {
    if (this == other)
      {
        return true;
      } // if
    else if (other instanceof BulkItem)
      {
        return this.equals((BulkItem) other);
      } // else if 
    else
      {
        return false;
      } // else 
  } // equals(Object)
} // class BulkItem
