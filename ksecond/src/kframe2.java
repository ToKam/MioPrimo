import javax.swing.*;   //controls



import java.awt.*;      //Color
import java.awt.event.ActionEvent;   //button event
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.MouseAdapter;  //mouse event
//import java.awt.event.MouseEvent;

public class kframe2 {
	
	JFrame frame;
    JLabel label = new JLabel("testo form2");
//    JTextField textField0 = new JTextField("0");
//    JTextField textField1 = new JTextField("0");
    JButton button0 = new JButton("button0");
    JButton button1 = new JButton("Close");
    
	public kframe form1;
    
    kframe2(kframe form1) {
    	this.form1 = form1;
        prepareGUI();
        addComponents();
        //addActionEvent
}
    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("KametFrame");
        //frame.setLocationRelativeTo(null);
        frame.setLocation(50, 50);
        frame.setSize(500, 400);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);        
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        		form1.label.setText(label.getText());
        		frame.dispose();
        	}

        });
    }
 
    public void addComponents() {
    	//label
        label.setBounds(25, 20, 150, 40);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText("nuovo testo2");
        label.setToolTipText("label tooltip");
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        label.setOpaque(true);label.setBackground(Color.red);
        label.setForeground(Color.white);        
        frame.add(label);
        
        //button
        button0.setBounds(25, 330, 150, 30);
        button0.setHorizontalAlignment(SwingConstants.CENTER);
        button0.setFont(new Font("Arial", Font.BOLD, 20));
        button0.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        button0.setToolTipText("button tooltip close");
        //button.addActionListener(this); 
        button0.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
            	//label.setText(button0.getText());
            	form1.label.setText(label.getText());
            }
        });
        frame.add(button0);
       
        button1.setBounds(325, 330, 150, 30);
        button1.setHorizontalAlignment(SwingConstants.CENTER);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        button1.setToolTipText("Close Form2");
        //button1.addActionListener(this);
        button1.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {            	
            	form1.f_form2 = false;
            	//System.exit(0);
            	frame.dispose();
            }
        });
        frame.add(button1);
        
    	
    }
    
    
}