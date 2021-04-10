package HW6_2021_04_09.collback;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;


public class EventTimer extends JFrame implements ITimer {
    private static int counter = 0;
    private static JLabel label = null;
    private static final String TEMPLE = "   New window opened from %d sec.";

    @Override
    public void callTimeMessage(int sec) throws InterruptedException {
        counter = sec;
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Timer");
        label = new JLabel(String.format(TEMPLE, counter));
        frame.getContentPane().add(label);
        frame.setPreferredSize(new Dimension(250, 150));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        label.setText(String.format(TEMPLE, counter));
        while (counter > 0) {
            Thread.sleep(1 * 1000);
            counter--;
            label.setText(String.format(TEMPLE, counter));
        }
        label.setText((String.format("  %d second passed!", sec)));
        Thread.sleep(1 * 1000);
        frame.setVisible(false);
        System.out.println("10 second passed!");
    }
}
