
package notepad;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class About extends JFrame implements ActionListener{
    About(){
        setBounds(400,100,600,500);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/windows.png"));
        Image i2 =i1.getImage().getScaledInstance(300, 60, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel headerIcon = new JLabel(i3);
        headerIcon.setBounds(70, 40, 400, 80);
        add(headerIcon);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image i5 =i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel icon = new JLabel(i6);
        icon.setBounds(50, 180, 70, 70);
        add(icon);
        
        JLabel text = new JLabel("<html>Notepad Clone <br>Version 0.1.0 - Build in JAVA<br>All rights reserved by Vivek Singh<br>Contact: vivekbhadoria09@gmail.com</html>");
        text.setBounds(150,80,500,300);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(text);
        
        JButton button = new JButton("Ok");
        button.setBounds(150, 350, 120, 25);
        button.addActionListener(this);
        add(button);
        
        
        
            }
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }
    public static void main(String args[]){
        new About().setVisible(true);

    }

    
            
    
}
