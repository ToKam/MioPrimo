import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ListenerDemo extends JPanel implements MouseMotionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel labelX;
    JLabel labelY;

    public ListenerDemo() {
        addMouseMotionListener(this);
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 50);
        TitledBorder borderX = new TitledBorder("Mouse X");
        TitledBorder borderY = new TitledBorder("Mouse Y");

        borderX.setTitleJustification(TitledBorder.CENTER);
        borderY.setTitleJustification(TitledBorder.CENTER);

        labelX = new JLabel("0");
        labelX.setBorder(borderX);
        labelY = new JLabel("0");
        labelY.setBorder(borderY);

        labelX.setFont(f);
        labelY.setFont(f);
        super.add(labelX);
        super.add(labelY);

    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
         labelX.setText("X : "+e.getX());
         labelY.setText("Y : "+e.getY());
    }

    public static void main(String [] argv) {
        WindowAdapter adpt = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        JFrame frame = new JFrame("ListenerDemo");
        frame.setLocation(50, 50);
        frame.setSize(500, 400);
        frame.addWindowListener(adpt);
        frame.getContentPane().add(new ListenerDemo(), null);
        //frame.pack();
        frame.setVisible(true);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}