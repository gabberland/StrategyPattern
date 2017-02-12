import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */
public class Elevator extends algorithm {
    @Override
    public Integer nextCandidade(ArrayList<Integer> list, Integer index) {
        Integer candidate = 100;
        for (int i =0; i < list.size(); ++i){
            Integer x = list.get(i)-i;
            if(candidate > Math.abs(x))
                candidate = Math.abs(x);
        }
        return next;
    }
}
}

