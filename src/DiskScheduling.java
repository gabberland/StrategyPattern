import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */
public class DiskScheduling implements algorithm {
    public Integer nextCandidade(Disk disk) {
        Integer next = 10000;
        for (int i =0; i < disk.getNumbers().size(); ++i){
            Integer x = disk.getNumbers().get(i)-disk.getIndex();
            if(next > Math.abs(x))
                next = Math.abs(x);
        }
        return next;
    }
}
