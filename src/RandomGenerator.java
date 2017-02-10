import java.util.ArrayList;
import java.util.Random;

/**
 * Created by oriol on 10/02/17.
 */
public class RandomGenerator {
    public ArrayList<Integer> numbers = GenerateRandoms();

    private static ArrayList<Integer> GenerateRandoms(){
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
