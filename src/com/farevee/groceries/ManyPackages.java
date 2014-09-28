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
  
  /**
   * Determines if this has fields equal to the feilds of other, a 
   * ManyPackages object
   * @param other
   * @return boolean
   */
  public boolean equals(ManyPackages other)
  {
    return this.type.equals(other.type) && (this.count == other.count);
  } // equals(ManyPackages)
  
  /**
   * Determines if this is equal to other, an Object
   */
  public boolean equals(Object other)
  {
    if (this == other)
      {
        return true;
      } // if
    else if (other instanceof ManyPackages) 
    {
      return this.equals((ManyPackages) other);
    } // else if
    else
      {
        return false;
      } // else
  } // equals(Object)
  
} // class ManyPackages
