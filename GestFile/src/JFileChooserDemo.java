import java.awt.*;
//import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.text.*;
import javax.swing.filechooser.FileFilter;
import java.util.*;
import java.util.Scanner;


public class JFileChooserDemo extends JPanel {

  private JTextArea textArea;

  public JFileChooserDemo() {
    super(new BorderLayout());
    createPanel();
  }

  private void createPanel() {
    JButton openFileChooser = new JButton("Apri File");
    JButton saveFileChooser = new JButton("Salva File");
    openFileChooser.addActionListener(new OpenFileChooser());
    saveFileChooser.addActionListener(new SaveFileChooser());
    textArea = new JTextArea(10, 20);
    //textArea.setLineWrap(true);
    //textArea.getDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\r\n");
    add(new JScrollPane(textArea), BorderLayout.CENTER);
    JPanel panelButton = new JPanel();
    panelButton.add(openFileChooser);
    panelButton.add(saveFileChooser);
    add(panelButton, BorderLayout.SOUTH);
  }

  private class OpenFileChooser implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      try {
        textArea.setText("");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new TxtFileFilter());
        int n = fileChooser.showOpenDialog(JFileChooserDemo.this);
        if (n == JFileChooser.APPROVE_OPTION) {
          File f = fileChooser.getSelectedFile();
          BufferedReader read = new BufferedReader(new FileReader(f));
          String line = read.readLine();
          while(line != null) {
            textArea.append(line + "\r\n");
            line = read.readLine();
          }
          read.close();
          textArea.setText(textArea.getText() + "insert text when you want a new line add \r\nThen more text....");
          //String input = "1-2 antonio-3.14";
          //Scanner scanner = new Scanner(input).useDelimiter(null);
          String input = "1 fish-2 fish-3 red fish-4 blue fish";

          // \\s* means 0 or more repetitions of any whitespace character 
          // fish is the pattern to find
          Scanner scanner = new Scanner(input);
          scanner.useDelimiter("-");
          System.out.println("The delimiter use is " + scanner.delimiter());
          
          while(scanner.hasNext())
          {
        	  // output: 1 2 antonio 3.14
        	  System.out.println(scanner.next());
          }
          scanner.close();
          
        }
      } catch (Exception ex) {}
    }
  }

  private class SaveFileChooser implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      try {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new TxtFileFilter());
        int n = fileChooser.showSaveDialog(JFileChooserDemo.this);
        if (n == JFileChooser.APPROVE_OPTION) {
          File f = fileChooser.getSelectedFile();
          BufferedWriter write = new BufferedWriter(new FileWriter(f, true));  //true = append
          write.append(textArea.getText());          
          //write.write(textArea.getDocument().getText(0, textArea.getDocument().getLength()));
          //write.write("testoa");  
          write.flush();
          write.close();
          
          
        }
      } catch (Exception ex) {}
    }
  }

  private class TxtFileFilter extends FileFilter {

    public boolean accept(File file) {
      if (file.isDirectory()) return true;
        String fname = file.getName().toLowerCase();
        return fname.endsWith("txt");
    }

    public String getDescription() {
      return "File di testo";
    }
  }

  public static void main(String[] argv) {
    JFrame frame = new JFrame("JFileChooserDemo");
    JFileChooserDemo demo = new JFileChooserDemo();
    
    frame.setTitle("KametFrame");
    frame.setLocation(50, 50);
    frame.setSize(500, 400);
//    frame.getContentPane().setLayout(null);
//    frame.getContentPane().setBackground(Color.gray);
//    frame.setResizable(false);
//    frame.setLocationRelativeTo(null);
//    frame.setVisible(true);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    frame.getContentPane().add(demo);
//    frame.pack();
    frame.setVisible(true);
  }
}