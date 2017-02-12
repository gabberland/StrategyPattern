import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */
public class DiskScheduling implements algorithm {
    public Integer nextCandidade(ArrayList<Integer> list, Integer index) {
        Integer next = 10000;
        for (int i =0; i < list.size(); ++i){
            Integer x = list.get(i)-index;
            if(next > Math.abs(x))
                next = Math.abs(x);
        }
        return next;
    }
}
