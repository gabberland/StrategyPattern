import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by oriol on 12/02/17.
 */
public class Elevator implements algorithm {
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
