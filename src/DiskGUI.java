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
}
