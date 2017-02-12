import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */
public class FIFO  extends algorithm {
    @Override
    public Integer nextCandidade(ArrayList<Integer> list, Integer index) {
        return list.get(0);
    }
}
