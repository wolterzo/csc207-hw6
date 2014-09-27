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

  
  public Weight getWeight()
  {
    return null;
  }

  @Override
  public int getPrice()
  {
    // TODO Auto-generated method stub
    return 0;
  }

}
