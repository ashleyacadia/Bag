# Bag
 a bag has a fixed capacity and does not need to keep elements in any specific order. The only way to get an item in the bag is to grab it, which gives back an item in the bag at random but does not remove it.
 It also has many other useful methods; add, for adding a new item but only if it
can fit it; remove, which removes a specific item from the bag; clear, which removes all items from the
bag; iterator, which allows items to be iterated over; isFull and isEmpty which return true if the bag is
full or empty; size, giving the number of items in the bag; capacityRemaining, returns how many items
can still be added to bag before it is full; and toArray which returns an array of the same type of all
items left in the bag.

Two classes of Bag. Once called ArrayBag which implements a bag with an
underlying array, the other called LinkedBag which implements a bag with an underlying doubly
linked list. Include two constructors for each, one which instantiates a bag with a fixed capacity of 10,
the other which allows a using program to specify capacity. Include a toString method with each
implementation and throw any suitable exceptions where needed
