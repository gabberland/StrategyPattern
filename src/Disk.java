import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by oriol on 10/02/17.
 */

/**
 * The class disk is the class than stores the actual information of the disk. The index value stores the current position
 * of the slider. It also stores the list of random numbers than we have to find. Once a value of the array is found, it will be
 * erased and we will generate a new random number. There will be a boolean than shows the current direction of the pointer.
 */
public class Disk {
    private Integer index;
    private boolean up;
    private ArrayList<Integer> numbers;

    /**
     * Constructor class. The initial state of a disk will be the slicer pointing to the first position, an array with 20 values,
     * and the current direction will be upwards.
     */
    Disk(){
        index = 0;
        numbers = InitRandoms();
        up = true;
    }

    /**
     * Check which is the current direction of the elevator. If we are going up wards and we are on the max value or if
     * we are going downwards and we are on the min value we have to change the direction. This function will be ONLY used
     * for the elevator algorithm.
     */
    public void checkDirection(){
        if(up) {
            if (index == Collections.max(numbers))
                up = false;
        }
        else{
            if (index == Collections.min(numbers))
                up = true;
        }
    }

    /**
     * If the array has less than 20 values, adds a new random number to the array.
     */
    public void addRandom(){
        if (numbers.size() < 20){
            Random randomGenerator = new Random();
            int n = randomGenerator.nextInt(100);
            if (!numbers.contains(n))
                numbers.add(n);
        }
    }

    /**
     * Delete the desired value of the array.
     * @param val Number we want to delete of the array.
     */
    public void deleteValue(Integer val){
        if(numbers.contains(val))
            numbers.remove(val);
    }

    /**
     * Set the index to the desired value
     * @param i New position of the index
     */
    public  void setIndex(Integer i){
        index = i;
    }

    /**
     * Function than generates an array of 20 diferent positive number between 0 and 99
     * @return ArrayList with the 20 desired random numbers
     */
    private static ArrayList<Integer> InitRandoms(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        int it = 0;
        while(it < 20){
            Random randomGenerator = new Random();
            int n = randomGenerator.nextInt(100);
            if (!array.contains(n)) {
                array.add(n);
                ++it;
            }
        }
        return array;
    }

    /**
     * Function than get the ArrayList of random numbers of the disk.
     * @return ArrayList of random numbers.
     */
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    /**
     * Function than gets the current position of the slider of the disk.
     * @return The value of the of the index.
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Function than gets the direction of the dlider of the disk.
     * @return Returns true if we are going upwards, otherwise returns false.
     */
    public boolean getUp() {
        return up;
    }
}
