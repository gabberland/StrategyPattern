import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Àlex on 10/2/2017.
 */
public class DiskGUI {
    private JRadioButton firstComeFirstServedRadioButton;
    private JRadioButton shortestSeekTimeFirstRadioButton;
    private JRadioButton SCANDiskElevatorRadioButton;
    private JSlider slider1;

    public DiskGUI() {
        firstComeFirstServedRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

            }
        });
    }


    public static void main(String[] args) {
        // write your code here
        Disk disk = new Disk();
        Integer state = 0; //state = 0 = default algorithm
       /* SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiskGUI gui = new DiskGUI();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(gui);
                frame.pack();
                frame.setVisible(true);
            }
        });*/
       algorithm algFifo = new FIFO();
       algorithm algDiskSched = new DiskScheduling();
       algorithm algElevat = new Elevator();
        while(true) {
            Integer candidate;
            if (state == 0) { //First in First Served algorithm
                candidate = algFifo.nextCandidade(disk);

            }
            else if (state == 1) { //DiskScheduling algorithm
                candidate = algDiskSched.nextCandidade(disk);

            }
            else { //Elevator algorithm
                candidate = algElevat.nextCandidade(disk);
                disk.checkDirection();
            }
            disk.deleteValue(candidate);
            disk.addRandom();

        }
    }
}
