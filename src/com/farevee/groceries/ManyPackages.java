package com.farevee.groceries;

public class ManyPackages
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Type of package that there are many of.
   */
  Package type;
  /**
   * How many packages there are.
   */
  int count;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public ManyPackages(Package type, int count)
  {
    this.type = type;
    this.count = count;
  } // ManyPackages(Package, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
  /**
   * Determines the weight of the ManyPackages
   */
  public Weight getWeight()
  {
    return new Weight(this.type.weight.unit(),
                      (this.count * this.type.weight.amount()));
  } // getWeight()

  /**
   * Determines the price of the ManyPackages
   */
  public int getPrice()
  {
    return this.count * this.type.price;
  } // getPrice()

  /**
   * Returns the String representation of ManyPackages
   */
  public String toString()
  {
    Package type = this.type;
    return this.count + " x " + type.weight.toString() + " packages of "
           + type.name;
  } // toString()
  
} // class ManyPackages
