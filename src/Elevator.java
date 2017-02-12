import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */
public class Elevator implements algorithm {
    public Integer nextCandidade(ArrayList<Integer> list, Integer index, boolean up) {
        if (up == true){
            Integer candidate = -1;
            for(int i = 0; i < list.size(); ++i){
                if(candidate < list.get(i))
                    candidate = list.get(i);
            }
            return candidate;
        }
        else{
            Integer candidate = 1000;
            for(int i = 0; i < list.size(); ++i){
                if(candidate > list.get(i))
                    candidate = list.get(i);
            }
            return candidate;
        }
    }
}
