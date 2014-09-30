package com.farevee.shopping;

import java.io.PrintWriter;
import java.util.LinkedList;

import com.farevee.groceries.BulkItem;
import com.farevee.groceries.Item;
import com.farevee.groceries.ManyPackages;
import com.farevee.groceries.Units;
import com.farevee.groceries.Weight;

public class Cart
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Linked list that contains the items in the cart.
   */
  LinkedList<Item> items;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public Cart()
  {
    this.items = new LinkedList<Item>();
  } // Cart()
  
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
    LinkedList<Item> items = this.items;
    for (int i = 0; i < items.size(); i++)
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
    LinkedList<Item> items = this.items;
    for (int i = 0; i < items.size(); i++)
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
    LinkedList<Item> items = this.items;
    int total = 0;
    for (int i = 0; i < items.size(); i++)
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
    LinkedList<Item> items = this.items;
    Weight currWeight;
    // add weights to appropriate place in the array
    for (int i = 0; i < items.size(); i++)
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
    LinkedList<Item> items = this.items;
    Item currItem;
    for (int i = 0; i < items.size(); i++)
      {
        currItem = items.get(i);
        if (currItem.getName().equals(name))
          {
            items.remove(i);
            i--;
          } // if
      } // for
  } // remove(String)

  /**
   * Finds identical items and merges them into a single item.
   * 
   * **Doesn't work, for some reason it's not getting into any of the 
   * conditionals.**
   */
  public void merge()
  {
    LinkedList<Item> items = this.items;
    Item item1;
    Item item2;
    for (int i = 0; i < items.size(); i++)
      {
        item1 = items.get(i);
        for (int j = i + 1; j < items.size(); j++)
          {
            item2 = items.get(j);
            //check if item1 is a Package
            if (item1 instanceof Package)
              {
                if (item1.equals(item2))
                  {
                    items.set(j,
                              new ManyPackages(
                                               (com.farevee.groceries.Package) item1,
                                               2));
                    items.remove(i);
                    i--;
                  } // if item1 == item2
                else if (item2 instanceof ManyPackages
                         && item1.equals(((ManyPackages) item2).packageType()))
                  {
                    ((ManyPackages) item2).addPackage(1);
                    items.remove(i);
                    i--;
                  } // else if item2.type == item1
              } // if item1 is a Package
            else if (item1 instanceof ManyPackages)
              {
                if (((ManyPackages) item1).packageType().equals(item2))
                  {
                    items.set(j,
                              new ManyPackages(
                                               (com.farevee.groceries.Package) item2,
                                               ((ManyPackages) item1).count() + 1));
                    items.remove(i);
                    i--;
                  } // if item2 is a Package of the same type as item1
                if ((item2 instanceof ManyPackages)
                    && ((ManyPackages) item1).packageType()
                                             .equals(((ManyPackages) item2).packageType()))
                  {
                    ((ManyPackages) item2).addPackage(((ManyPackages) item1).count());
                    items.remove(i);
                    i--;
                  } // if item1 and item2 are ManyPackages with the same type
              } // else if item1 is ManyPackages
            else if (item1 instanceof BulkItem
                     && item2 instanceof BulkItem
                     && ((BulkItem) item1).food()
                                          .equals(((BulkItem) item2).food()))
              {
                items.set(j,
                          new BulkItem(((BulkItem) item1).food(),
                                       ((BulkItem) item1).units(),
                                       ((BulkItem) item1).amount()
                                           + ((BulkItem) item2).amount()));
                items.remove(i);
                i--;
              } // else if item1 and item2 are a BulkItem of the same BulkFood
          } // for (item2)
      } // for (item1)
  } // merge()
} // class Cart
