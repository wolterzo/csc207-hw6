Part E: Design Reflections
==========================

BulkContainer vs. ManyPackages
------------------------------
BulkContainer extends BulkItem, while ManyPackages has a field that is a Package. For BulkItems we don't have to rewrite all of the methods, but for ManyPackages we do. However, we think the ManyPackages method is a little simpler to understand. We would use BulkItem when two classes are very similarly implemented and we don't want to rewrite all of the methods. 

Comparing Names
---------------
Accessing the name field directly would be the least parentheses intensive but it also allows the user to change the name directly, which is no good.

The getname is almost as simple as the previous idea but the user can no longer change the name, which is good. We have to write it for all of the classes that implement item, which is ok.

The equals(String name) would do the comparing for us, instead of us having to compare the names in merge or remove. However, items can have the same name and different weights, and this implementation would not be able to account for those differences.

hasName would do the comparing for us, as in the equals method above, as it would only compare the names this has less of an implication of equality between the two items being compared.

NonFood vs. Package
-------------------
We think it does not make sense to have them as separate classes. They do the same things, and unless it is so important to the user that they make no mistakes in dividing the food items from their nonfood items, we think combining them would add simplicity. Combining them would also allow the cart to have ManyPackages of NonFood items, which we think is a prudent decision, because nonfood items come in packages too. Combining them would make more sense in the maintainability of our code. The user should be able to destinguish between food and nonfood items themselves, and if not, we could a boolean field into Package that would address this.

Walker vs. Rebelsky
-------------------
1. Item is a class not an interface in Walker's implementation.
2. In our Package class, we make the price and price per unit fields in Walker's implementation seem repetitious.
3. Walker's implementation uses double values. We use int values in our price field to avoid rounding errors.
4. We don't have the volume of our items in any of our classes. Walker does, which adds a touch of reality into the shopping cart. It also raises the "how best to fit the items into the cart" issue, which is a real beehive to bat down, if y'all will forgive our colloquialisms.
5. Walker's version only has weights for the Beverages and Produce extensions, which complicates the final metrics when evaluating the cart, because other Items also have a weight.
