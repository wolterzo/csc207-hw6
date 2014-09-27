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
  public BulkFood(String name, Units unit, int pricePerUnit, int supply)
  {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = pricePerUnit;
    this.supply = supply;
  } // BulkFood
  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
} // class BulkFood
