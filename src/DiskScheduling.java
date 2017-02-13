import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */

/**
 * Abstract class than implements the algorithm class.
 */
public class DiskScheduling implements algorithm {
    /**
     * Function than returns the next possition of the program slider using the shortest seek time algorithm.
     * It will always return a value between 0 and 99.
     * @param disk The disk than we want to obtain the next candidate. It will contains the current index position, the array of random numbers, and the direction.
     * @return it will return the value closest to the index. The return value will always be a value of the arrylist of random numbers.
     */
    public Integer nextCandidade(Disk disk) {
        Integer next = disk.getNumbers().get(0);
        for (int i =1; i < disk.getNumbers().size(); ++i){
            Integer x = disk.getIndex()-disk.getNumbers().get(i);
            if(Math.abs(disk.getIndex()-next) > Math.abs(x))
                next = disk.getNumbers().get(i);
        }
        return next;
    }
}
