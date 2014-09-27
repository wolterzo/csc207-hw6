package com.farevee.groceries;

/**
 * Items in a grocery store
 * @author Zoe G. Wolter
 *
 */
public interface Item
{
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Determines the weight of the Item
   */
  public Weight getWeight();
  
  /**
   * Determines the price of the Item
   */
  public int getPrice();
  
  /**
   * Determined the string representation of the Item
   */
  public String toString();
  
} // interface Item
