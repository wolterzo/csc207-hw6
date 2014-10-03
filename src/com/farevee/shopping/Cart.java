package com.farevee.shopping;

import java.io.PrintWriter;

import java.util.ArrayList;

import com.farevee.groceries.BulkItem;
import com.farevee.groceries.Item;
import com.farevee.groceries.Package;
import com.farevee.groceries.ManyPackages;
import com.farevee.groceries.Units;
import com.farevee.groceries.Weight;

/**
 * Cart of groceries. 
 * @author wolterzo
 * @author Sam Rebelsky
 * @author students in review session on 10/2/14
 *
 */
public class Cart
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Linked list that contains the items in the cart.
   */
  ArrayList<Item> items;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public Cart()
  {
    this.items = new ArrayList<Item>();
  } // Cart()

  // +---------+-----------------------------------------------------------
  // | Helpers |
  // +---------+  

  /**
   * Remove the jth item in the card, putting the last value in 
   * position j.  Return the new length.
   */
  int replace(int j)
  {
    int last = this.items.size() - 1;
    this.items.set(j, this.items.get(last));
    this.items.remove(last);
    return last;
  } // replace(int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
  /**
   * Add an item to the cart. 
   * @param item
   */
  public void addItem(Item item)
  {
    this.items.add(item);
  } // addItem(Item)

  /**
   * Determine the number of things in the cart.
   * @return an int
   */
  public int numThings()
  {
    int count = 0;
    int len = items.size();
    for (int i = 0; i < len; i++)
      {
        if (items.get(i) instanceof ManyPackages)
          {
            count = count + ((ManyPackages) items.get(i)).count();
          } // if ManyPackages
        else
          {
            count++;
          } // else
      } // for
    return count;
  } // numThings()

  /**
   * Determine the number of entries in the cart.
   * @return an int
   */
  public int numEntries()
  {
    return this.items.size();
  } // numEntries()

  /**
   * Print the contents of the cart.
   * @param pen, a PrintWriter
   */
  public void printContents(PrintWriter pen)
  {
    int len = items.size();
    for (int i = 0; i < len; i++)
      {
        pen.println(items.get(i).toString());
      } // for
  } // printContents(PrintWriter)

  /**
   * Compute the total price of the order, in cents.
   * @return an int
   * 
   */
  public int getPrice()
  {
    int total = 0;
    int len = items.size();
    for (int i = 0; i < len; i++)
      {
        total = total + items.get(i).getPrice();
      } // for
    return total;
  } // getPrice()

  /**
   * Returns an array of weights, organized by units in the order of
   * [0] GRAM
   * [1] KILOGRAM
   * [2] OUNCE
   * [3] POUND
   * @return Weight[]
   */
  public Weight[] getWeight()
  {
    //Initialize Weight array
    Weight[] totals =
        new Weight[] { new Weight(Units.GRAM, 0),
                      new Weight(Units.KILOGRAM, 0),
                      new Weight(Units.OUNCE, 0), new Weight(Units.POUND, 0) };
    Weight currWeight;
    int len = items.size();
    // add weights to appropriate place in the array
    for (int i = 0; i < len; i++)
      {
        currWeight = items.get(i).getWeight();

        if (currWeight.unit().equals(Units.GRAM))
          {
            totals[0].addWeight(currWeight.amount());
          } // if GRAM
        else if (currWeight.unit().equals(Units.KILOGRAM))
          {
            totals[1].addWeight(currWeight.amount());
          } // else if KILOGRAM
        else if (currWeight.unit().equals(Units.OUNCE))
          {
            totals[2].addWeight(currWeight.amount());
          } // else if OUNCE
        else if (currWeight.unit().equals(Units.POUND))
          {
            totals[3].addWeight(currWeight.amount());
          } // else if POUND
      } // for
    return totals;
  } // getWeight()

  /**
   * Removes all the items whose name exactly matches name
   * @param name, a String
   */
  public void remove(String name)
  {
    Item currItem;
    int len = items.size();
    for (int i = 0; i < len; i++)
      {
        currItem = items.get(i);
        if (currItem.getName().equals(name))
          {
            items.remove(i);
            i--;
            len--;
          } // if
      } // for
  } // remove(String)

  /**
   * Finds identical items and merges them into a single item.
   */
  public void merge()
  {
    Item item1;
    Item item2;
    int len = items.size();
    for (int i = 0; i < len; i++)
      {
        item1 = items.get(i);
        for (int j = i + 1; j < len; j++)
          {
            item2 = items.get(j);
            //check if item1 is a Package
            if (item1 instanceof Package)
              {
                if (item1.equals(item2))
                  {
                    // Merge the ith and jth items.
                    items.set(i, new ManyPackages((Package) item1, 2));
                    // Drop the jth item and replace it by the last item
                    len = replace(j);
                  } // if item1 == item2
                else if (item2 instanceof ManyPackages
                         && item1.equals(((ManyPackages) item2).packageType()))
                  {
                    ((ManyPackages) item2).addPackage(1);
                    // Make item1 the new compound package
                    item1 = item2;
                    items.set(i, item2);
                    // And move the lasts item to the newly freed space
                    len = replace(j);
                  } // else if item2.type == item1
              } // if item1 is a Package

            else if (item1 instanceof ManyPackages)
              {
                ManyPackages mp1 = (ManyPackages) item1;
                // item2 is a package stored in item1
                if (mp1.packageType().equals(item2))
                  {
                    mp1.addPackage(1);
                    len = replace(j);
                  } // if item2 is a Package of the same type as item1
                if ((item2 instanceof ManyPackages)
                    && (mp1.packageType().equals(((ManyPackages) item2).packageType())))
                  {
                    ((ManyPackages) item2).addPackage(((ManyPackages) item1).count());
                    len = replace(j);
                  } // if item1 and item2 are ManyPackages with the same type
              } // else if item1 is ManyPackages
            else if (item1 instanceof BulkItem
                     && item2 instanceof BulkItem
                     && ((BulkItem) item1).food()
                                          .equals(((BulkItem) item2).food()))
              {
                items.set(i,
                          new BulkItem(((BulkItem) item1).food(),
                                       ((BulkItem) item1).units(),
                                       ((BulkItem) item1).amount()
                                           + ((BulkItem) item2).amount()));
                len = replace(j);
              } // else if item1 and item2 are a BulkItem of the same BulkFood
          } // for (item2)
      } // for (item1)
  } // merge()
} // class Cart
