import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */

/**
 * Interface than will contains the three abstract classes of the three possible algorithms than the program can set.
 * There will be only one interface active at a time.
 */
public interface algorithm {
    /**
     * Function than returns the next possition of the program slider depending of which interface is active. It will always
     * return a value between 0 and 99.
     * @param disk The disk than we want to obtain the next candidate. It will contains the current index position, the array of random numbers, and the direction.
     * @return The future position of the index of the disk. It will always be a value of the array of randomnumbers of the disk.
     */
    public  Integer nextCandidade(Disk disk);

}
