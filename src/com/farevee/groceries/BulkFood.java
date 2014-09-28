package com.farevee.groceries;

public class BulkFood
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Name of the BulkFood
   */
  String name;

  /**
   * Unit of the BulkFood
   */
  Units unit;

  /**
   * Price of the BulkFood per unit of BulkFood
   */
  int pricePerUnit;

  /**
   * Supply of BulkFood
   */
  int supply;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public BulkFood(String name, Units unit, int pricePerUnit)
  {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = pricePerUnit;
  } // BulkFood(String, Units, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
  /**
   * Determines if this has fields equal to the fields of other, a BulkFood 
   * object.
   * @param other
   * @return
   */
  public boolean equals(BulkFood other)
  {
    return this.name.equals(other.name) && this.unit.equals(other.unit)
           && this.pricePerUnit == other.pricePerUnit;
  } // equals(BulkFood)
  
  /**
   * Determines if this is equal to other, an Object
   */
  public boolean equals(Object other)
  {
    if (this == other)
      {
        return true;
      } // if
    else if (other instanceof BulkFood)
      {
        return this.equals((BulkFood) other);
      } // else if
    else
      {
        return false;
      } // else
  } // equals(Object)
} // class BulkFood
