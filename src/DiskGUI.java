import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Àlex on 10/2/2017.
 */

/**
 * Contains all the frames of the application and the aplication main. The main will be an infinite bucle than always will find
 * a next candidate will set the index slider on it and will generarte a new randomNumber.
 */
public class DiskGUI extends JFrame {
    private JRadioButton firstComeFirstServedRadioButton;
    private JRadioButton shortestSeekTimeFirstRadioButton;
    private JRadioButton SCANDiskElevatorRadioButton;
    private JSlider slider1;
    private JPanel panelMain;
    private JList list;
    private static Integer state;

    public DiskGUI() {
        firstComeFirstServedRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                state = 0;

            }
        });
        shortestSeekTimeFirstRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                state = 1;
            }
        });
        SCANDiskElevatorRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                state = 2;
            }
        });
    }


    public static void main(String[] args) {
        // write your code here
        Disk disk = new Disk();
        state = 0;
        DiskGUI gui = new DiskGUI();
        JFrame frame = new JFrame("Disk");
        frame.setContentPane(new DiskGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

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
            disk.setIndex(candidate);
        }
    }
}
