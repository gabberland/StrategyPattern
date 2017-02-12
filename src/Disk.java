import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by oriol on 10/02/17.
 */
public class Disk {
    private Integer index;
    private boolean up;
    private ArrayList<Integer> numbers;

    Disk(){
        index = 0;
        numbers = InitRandoms();
        up = true;
    }

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

    public void addRandom(){
        if (numbers.size() < 20){
            Random randomGenerator = new Random();
            int n = randomGenerator.nextInt(100);
            if (!numbers.contains(n))
                numbers.add(n);
        }
    }

    public void deleteValue(Integer val){
        if(numbers.contains(val))
            numbers.remove(val);
    }

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
}
