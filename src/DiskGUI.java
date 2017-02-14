import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Àlex on 10/2/2017.
 */
public class DiskGUI extends JFrame {
    private JPanel panelMain;
    private static Integer state;

    public DiskGUI() {


    }


    public static void main(String[] args) {
        // write your code here
        Disk disk = new Disk();
        DiskGUI gui = new DiskGUI();
        JFrame frame = new JFrame("Disk");
        frame.setPreferredSize(new Dimension(800, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        state = 0;

        JSlider slider2 = new JSlider(JSlider.VERTICAL,0,99,0);
        slider2.setMajorTickSpacing(99);
        slider2.setMinorTickSpacing(0);
        slider2.setPaintLabels(true);
        slider2.setPaintTicks(true);

        java.util.List<Integer> listAux = disk.getNumbers();


        JList list = new JList(listAux.toArray());

        JRadioButton fifo = new JRadioButton();
        JRadioButton scheduled = new JRadioButton();
        JRadioButton elevator = new JRadioButton();
        fifo.setSelected(true);

        fifo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                super.mouseClicked(mouseEvent);
                state = 0;

            }
        });

        scheduled.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                super.mouseClicked(mouseEvent);
                state = 1;

            }
        });

        elevator.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                super.mouseClicked(mouseEvent);
                state = 2;

            }
        });

        fifo.setText("First In First Server");
        scheduled.setText("Shortest Seek Time First");
        elevator.setText("SCAN disk elevator");

        ButtonGroup bg = new ButtonGroup();
        bg.add(fifo);
        bg.add(scheduled);
        bg.add(elevator);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;

        JTextArea currentValue = new JTextArea();
        currentValue.setText(String.valueOf(disk.getNumbers().get(0)));


        frame.add(list, gbc);
        frame.add(slider2, gbc);
        frame.add(fifo, gbc);
        frame.add(scheduled, gbc);
        frame.add(elevator, gbc);
        frame.add(currentValue, gbc);



        frame.pack();
        frame.setVisible(true);

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
            }
            currentValue.setText("Current value: " + String.valueOf(candidate));

            System.out.println("Estat: " + state);
            System.out.println("Candidat: " + candidate);
            System.out.println("Posicio index: " + disk.getIndex());

            slider2.setValue(candidate);
            disk.setIndex(candidate);
            if(state == 2) disk.checkDirection();
            disk.deleteValue(candidate);
            disk.addRandom();

            JList newList = new JList(disk.getNumbers().toArray());

            list.setModel(newList.getModel());



            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
