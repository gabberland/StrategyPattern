import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */

/**
 * Abstract class than implements the algorithm class.
 */
public class FIFO  implements algorithm {
    /**
     * Function than returns the next possition of the program slider using the first enter first serve algorithm.
     * It will always return a value between 0 and 99.
     * @param disk The disk than we want to obtain the next candidate. It will contains the current index position, the array of random numbers, and the direction.
     * @return returns the first value of the arraylist of random numbers.
     */
    public Integer nextCandidade(Disk disk) {
        return disk.getNumbers().get(0);
    }
}
