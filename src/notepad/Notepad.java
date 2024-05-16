package notepad;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener{
    
    JTextArea textArea;
    String text;
    
    Notepad(){
        super("Notepad");
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image icon =notepadIcon.getImage();
        setIconImage(icon);
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.WHITE);
        
        
        JMenu file = new JMenu("File");
        file.setFont(new Font("AERIAL",Font.PLAIN,14));
        
        JMenuItem newdoc = new JMenuItem("New");
        newdoc.addActionListener(this);
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N ,ActionEvent.CTRL_MASK));
        
         JMenuItem open = new JMenuItem("Open");
         open.addActionListener(this);
         open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O ,ActionEvent.CTRL_MASK));
        
         JMenuItem save = new JMenuItem("Save");
         save.addActionListener(this);
         save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S ,ActionEvent.CTRL_MASK));
        
         JMenuItem print = new JMenuItem("Print");
         print.addActionListener(this);
         print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P ,ActionEvent.CTRL_MASK));
        
         JMenuItem exit = new JMenuItem("Exit");
         print.addActionListener(this);
         exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE ,ActionEvent.CTRL_MASK));
        
         file.add(newdoc);
        
         file.add(open);
        
         file.add(save);
         
         file.add(print);
        
         file.add(exit);
        
        
        
        menubar.add(file);
        
         JMenu edit = new JMenu("Edit");
         edit.setFont(new Font("AERIAL",Font.PLAIN,14));
        
        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C ,ActionEvent.CTRL_MASK));
        
         JMenuItem paste = new JMenuItem("Paste");
         paste.addActionListener(this);
         paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V ,ActionEvent.CTRL_MASK));
        
         JMenuItem cut = new JMenuItem("Cut");
         cut.addActionListener(this);
         cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X ,ActionEvent.CTRL_MASK));
         
         JMenuItem selectAll = new JMenuItem("Select All");
         selectAll.addActionListener(this);
         selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A ,ActionEvent.CTRL_MASK));
        
         menubar.add(edit);
         
         edit.add(copy);
         edit.add(paste);
         edit.add(cut);
         edit.add(selectAll);
         
          JMenu helpMenu = new JMenu("Help");
         helpMenu.setFont(new Font("AERIAL",Font.PLAIN,14));
        
        JMenuItem about = new JMenuItem("About");
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H ,ActionEvent.CTRL_MASK));
        
        menubar.add(helpMenu);
        helpMenu.add(about);
        
        setJMenuBar(menubar);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JScrollPane pane = new JScrollPane(textArea);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        
        
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getActionCommand().equals("New")){
           textArea.setText("");
       } 
       else if(ae.getActionCommand().equals("Open")){
           JFileChooser chooser=new JFileChooser();
           chooser.setAcceptAllFileFilterUsed(false);
           FileNameExtensionFilter restrict=new FileNameExtensionFilter("Only .txt file","txt");
           chooser.addChoosableFileFilter(restrict);
           int action=chooser.showOpenDialog(this);
           
           if(action != JFileChooser.APPROVE_OPTION){
               return;
           }
           File file = chooser.getSelectedFile();
           try{
               BufferedReader reader = new BufferedReader(new FileReader(file));
               textArea.read(reader,null);
               
           } catch(Exception e){
               e.printStackTrace();
           }
           
           
       }else if(ae.getActionCommand().equals("Save")){
          
           JFileChooser saveas=new JFileChooser();
           saveas.setApproveButtonText("Save");
           int action=saveas.showOpenDialog(this);
           
           if(action != JFileChooser.APPROVE_OPTION){
               return;
           }
           File filename = new File(saveas.getSelectedFile()+".txt");
           BufferedWriter outFile = null;
           
           try{
               outFile = new BufferedWriter(new FileWriter(filename));
               textArea.write(outFile);
           }catch(Exception e){
               e.printStackTrace();  
           }
           
           
       }
       else if(ae.getActionCommand().equals("Print")){
           try{
                textArea.print();
           }catch(Exception e){
               e.printStackTrace();  
           }
       }
       else if(ae.getActionCommand().equals("Exit")){
           System.exit(0);
           
       }
       else if(ae.getActionCommand().equals("Copy")){
           text = textArea.getSelectedText();
       }
       else if(ae.getActionCommand().equals("Paste")){
           textArea.insert(text, textArea.getCaretPosition());
           
       }
       else if(ae.getActionCommand().equals("Cut")){
           
           text = textArea.getSelectedText();
           textArea.replaceRange("", textArea.getSelectionStart(),textArea.getSelectionEnd());
           
       }
       else if(ae.getActionCommand().equals("Select All")){
           textArea.selectAll();
           
       }
       else if(ae.getActionCommand().equals("About Notepad")){
           new About().setVisible(true);
           
       }
       
       
        
    }

    public static void main(String[] args) {
         new Notepad();
    }

  
}
