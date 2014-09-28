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
  public String toString()
  {
    return this.container + " of " + super.toString();
  } // toString()
} // class BulkContainer
