import javax.swing.*;   //controls
import java.awt.*;      //Color
import java.awt.event.ActionEvent;   //button event
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;  //mouse event
import java.awt.event.MouseEvent;



public class kframe  implements ActionListener{ 
	JFrame frame;
    JLabel label = new JLabel("testo form1");
    JTextField textField0 = new JTextField("0");
    JTextField textField1 = new JTextField("0");
    JButton button0 = new JButton("button0");
    JButton button1 = new JButton("button1");
    
    kframe() {
        prepareGUI();
        addComponents();
        //addActionEvent();
}
    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("KametFrame");
        frame.setLocation(50, 50);
        frame.setSize(500, 400);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textField0.requestFocus(); textField0.setBackground(Color.yellow);
    }
    
    public void addComponents() {
    	//label
        label.setBounds(25, 20, 150, 40);
        label.setFont(new Font("Arial", Font.BOLD, 10));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText("nuovo testo1");
        label.setToolTipText("label tooltip");
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        label.setOpaque(true);label.setBackground(Color.red);
        label.setForeground(Color.white);        
        frame.add(label);

        //textField0
        textField0.setBounds(200, 20, 270, 40);
        textField0.setFont(new Font("Arial", Font.BOLD, 20));
        //textField0.setEditable(false);
        textField0.setHorizontalAlignment(SwingConstants.RIGHT);
        textField0.setToolTipText("<html><b><font color=red>" + "Please only numbers here" + "</font></b></html>");
        //textField.addActionListener(this);
        textField0.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
            	label.setText(textField0.getText());
            	textField1.requestFocus();  //textField1.requestFocusInWindow();
            	textField0.setBackground(Color.white); textField1.setBackground(Color.yellow);
            }
        });        
        textField0.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
        		char ch = e.getKeyChar();
        		
        		if ("0123456789. ".indexOf(ch) < 0) e.setKeyChar('\0');  //funziona (ma accetta ancora <bkspace>)
//        		if (!isNumber(ch) && !validatePoint(ch)  && ch != '\b') {
//        			//e.setKeyChar('\0');  //funziona
//        			e.consume();
//        			label.setText("stringa errata");
//        		}
        	}
        });        
        textField0.addMouseListener(new MouseAdapter(){
            //@Override
            public void mouseClicked(MouseEvent e){
                //textField0.setText("0");
                textField0.requestFocus();
            	textField1.setBackground(Color.white); textField0.setBackground(Color.yellow);
            }
        });
        frame.add(textField0);
        
        //textField1
        textField1.setBounds(200, 80, 270, 40);
        textField1.setFont(new Font("Arial", Font.BOLD, 20));
        //textField1.setEditable(false);
        textField1.setHorizontalAlignment(SwingConstants.RIGHT);
        textField1.setToolTipText("<html><b><font color=red>" + "Please enter name here" + "</font></b></html>");
        //textField.addActionListener(this);
        textField1.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
            	label.setText(textField1.getText());
            	textField0.requestFocus();
            	textField1.setBackground(Color.white); textField0.setBackground(Color.yellow);
            }
        });
        frame.add(textField1);
        
        //button
        button0.setBounds(25, 330, 150, 30);
        button0.setHorizontalAlignment(SwingConstants.LEFT);
        button0.setFont(new Font("Arial", Font.BOLD, 20));
        button0.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        button0.setToolTipText("button0 tooltip");
        button0.addActionListener(this);  
        frame.add(button0);
        
        button1.setBounds(325, 330, 150, 30);
        button1.setHorizontalAlignment(SwingConstants.RIGHT);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        button1.setToolTipText("Close Form2");
        button1.addActionListener(this);  
        frame.add(button1);
    }
	
    public kframe2 form2;
    public boolean f_form2 = false;

    public void actionPerformed(ActionEvent e) {  
        String s1=textField0.getText();   
        int a = Integer.parseInt(s1);  
  
        if(e.getSource()==button0){  
            a++;
            textField0.setText(String.valueOf(a));
            
        }
        else if(e.getSource()==button1){  
        	//System.exit(0);
        	if (!f_form2) form2 = new kframe2(this);
        	f_form2 = true;
        	form2.label.setText(textField0.getText());
        }
//        else if(e.getSource()==textField){  
//            label.setText(textField.getText()); 
//        }
        
          
    }  
    
    private boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }

    private boolean validatePoint(char ch){
        return ch == '.';
    }
}