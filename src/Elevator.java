import java.util.ArrayList;

/**
 * Created by oriol on 12/02/17.
 */
public class Elevator implements algorithm {
    public Integer nextCandidade(Disk disk) {
        if (disk.getUp() == true){
            Integer candidate = 10000;
            for(int i = 0; i < disk.getNumbers().size(); ++i){
                if(disk.getNumbers().get(i) > disk.getIndex() && disk.getNumbers().get(i) < candidate)
                    candidate = disk.getNumbers().get(i);
            }
            return candidate;
        }
        else{
            Integer candidate = -1;
            for(int i = 0; i < disk.getNumbers().size(); ++i){
                if(disk.getNumbers().get(i) < disk.getIndex() && disk.getNumbers().get(i) > candidate)
                    candidate = disk.getNumbers().get(i);
            }
            return candidate;
        }
    }
}
