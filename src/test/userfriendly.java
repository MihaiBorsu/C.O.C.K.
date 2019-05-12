package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;

import com.javapapers.java.SFM;
import com.javapapers.java.panica;

public class userfriendly {
  static ProgressMonitor monitor;

  static int progress;

  static Timer timer;

  public void AWT() {

    JFrame frame = new JFrame("COCK Spaceship");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Container contentPane = frame.getContentPane();
    //contentPane.setLayout(new GridLayout(0, 1));
   
    
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    
    
    JPanel firstPanel = new JPanel();
    
    firstPanel.setLayout(new GridLayout(3, 3));
    firstPanel.setMaximumSize(new Dimension(400, 400));

    
    
    
    
    // Define Start Button
    JButton startButton = new JButton("Test CPU.");
    ActionListener startActionListener = new ActionListener() 
    {
      public void actionPerformed(ActionEvent actionEvent) 
      {
          SFM send = new SFM();
          ((SFM) send).SendFromYahoo();

      }
    };
    startButton.addActionListener(startActionListener);
   startButton.setPreferredSize(new Dimension(100, 100));
    firstPanel.add(startButton);
   // contentPane.add(startButton);

    JButton increaseButton = new JButton("Panic!");
    ActionListener increaseActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) 
      {
            panica pnk = new panica();
          ((panica) pnk).SendFromYahoo();
            JOptionPane.showMessageDialog(null,"Hold on tight. Reinforcements "
                + "are on their way to you.");
      }
    };
    increaseButton.addActionListener(increaseActionListener);
    startButton.setPreferredSize(new Dimension(100, 100));
    firstPanel.add(increaseButton);
    ///contentPane.add(increaseButton);


    JButton autoIncreaseButton = new JButton("Abort mission.");
    ActionListener autoIncreaseActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) 
      {
            JOptionPane.showMessageDialog(null,"See you later.");
            System.exit(0);
      }
    };
    autoIncreaseButton.addActionListener(autoIncreaseActionListener);
autoIncreaseButton.setPreferredSize(new Dimension(100, 100));
    firstPanel.add(autoIncreaseButton);
    //contentPane.add(autoIncreaseButton);
  
    mainPanel.add(firstPanel);
   
   mainPanel.setBackground(new Color(146,205,130));
   frame.setContentPane(mainPanel);
    frame.setSize(520,600);
   // frame.setBackground(Color.blue);
   // frame.setMinimumSize(new Dimension(520,600));
    frame.setVisible(true);
  }
}
  