import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by oriol on 12/02/17.
 */

/**
 * Abstract class than implements the algorithm class.
 */
public class Elevator implements algorithm {
    /**
     *Function than returns the next possition of the program slider using the elevator algorithm.
     * It will always return a value between 0 and 99.
     * @param disk The disk than we want to obtain the next candidate. It will contains the current index position, the array of random numbers, and the direction.
     * @return it will return the value closest to the index than u will found folling the current direction. The return value will always be a value of the arrylist of random numbers.
     */
    public Integer nextCandidade(Disk disk) {
        if (disk.getUp() == true){
            Integer candidate = Collections.max(disk.getNumbers());
            for(int i = 0; i < disk.getNumbers().size(); ++i){
                if(disk.getNumbers().get(i) > disk.getIndex() && disk.getNumbers().get(i) < candidate)
                    candidate = disk.getNumbers().get(i);
            }
            return candidate;
        }
        else{
            Integer candidate = Collections.min(disk.getNumbers());
            for(int i = 0; i < disk.getNumbers().size(); ++i){
                if(disk.getNumbers().get(i) < disk.getIndex() && disk.getNumbers().get(i) > candidate)
                    candidate = disk.getNumbers().get(i);
            }
            return candidate;
        }
    }
}
