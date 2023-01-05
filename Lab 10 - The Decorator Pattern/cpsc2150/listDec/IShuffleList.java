//by David Novo and Jacob Martin

package cpsc2150.listDec;

import java.util.List;

import java.util.Random;

/**
* This interface extends the List interface. It adds two default methods to List, shuffle and Swap.
* @initialization Ensures an empty list of type T
* @defines none
* @constraints [List has at least two entries]
*/

public interface IShuffleList<T> extends List<T> {
   /**
    * this function exchanges the values of two random indices swaps number of times
    * @param swaps is an int representing the number of swaps that should be made
    * @return none
    * @pre [There must be at least two values in the list AND swap >= 0]
    * @post [nothing returned AND two random values in the list are exchanged swaps number of times]
   */
   default void shuffle(int swaps){
       Random rand = new Random();
       for(int i = 0; i < swaps; i++){
           int randOne = rand.nextInt(this.size());
           int randTwo = rand.nextInt(this.size());
           swap(randOne, randTwo);
       }
   }

   /**
    * This function exchanges the values at positions i and j
    *
    * @param i - position that is used in the swap
    * @param j - other position that is used in the swap
    *
    * @pre i >= 0 && j >= 0 AND must be at least two positions in the list
    *
    * @post Values at specified positions are swapped in list AND nothing returned
    *
    * @return None
    */
   default void swap(int i, int j){
       T temp = this.get(i);
       this.set(i, this.get(j));
       this.set(j, temp);
   }
}
