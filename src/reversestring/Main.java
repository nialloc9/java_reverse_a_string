package reversestring;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
    
    private static final long serialVersionUID = 1L;
    
    //MAIN CONSTRUCTOR    
    public Main(){
        super("Java Reverse String");
        gui();
	contents();
    }
    
    private void gui(){
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //If null centers
        setVisible(true);
        setResizable(false);
    }
    
    //CONTENTS METHOD
    private void contents(){
        //set layout
        setLayout(null);
		
        //set font
	Font font = new Font("Tahoma", Font.PLAIN, 12);
		
        //set components
	JLabel welcome = new JLabel("Welcome, this application can reverse string.");
	JLabel str = new JLabel("Enter a string : ");
	JTextField txt = new JTextField(25);
	JButton reverse = new JButton("Reverse");
	JButton back = new JButton("Back");
	JLabel result = new JLabel("Result :  ");
	
        //set font and color
	welcome.setFont(font);
	welcome.setForeground(Color.BLACK);
	str.setFont(font);
	str.setForeground(Color.BLACK);
	txt.setFont(font);
	txt.setForeground(Color.BLACK);
	reverse.setFont(font);
	reverse.setForeground(Color.BLACK);
	back.setFont(font);
	back.setForeground(Color.BLACK);
	result.setFont(font);
	result.setForeground(Color.RED);
		
        //set location and size
	welcome.setBounds(10,10,350,30);
	str.setBounds(10,50,100,30);
	txt.setBounds(110,50,150,30);
	reverse.setBounds(275,50,100,30);
	result.setBounds(10,100,200,30);
	back.setBounds(275,100,100,30);
	
        //add components
	add(welcome);
	add(str);
	add(txt);
	add(reverse);
	add(result);
	add(back);
        
        //add action listeners
        reverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = reverseString(txt.getText());
                result.setText("Result : " + s);
            }
        });
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = backString(txt.getText());
                result.setText("Result : " + s);
            }
        });
    }
    
    //REVERSE STRING METHOD
    public static String reverseString(String str){
        int len = str.length();
        int count = len-1;
        
        String result = "";
        
        //gets the character at the end of the string and loops back by 1 each time getting the next character and adding it to the result variable
        for(int i = count; i>=0; i--){
            result += str.substring(i, len);  
            len--;
        }
        
        return result;
    }
    
    //BACK STRING METHOD.. returns reversed string to normal
    public static String backString(String str){
        int len = str.length();
        int count = 1;
        
        String result = "";
        
        for(int i = 0; i <len; i++){
            result += str.substring(i, count);
            count++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        try{
            //sets out how it the JFrame will look and feel for the user. It will use the Nimbus one.
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception ex){
            
        }
        
        //put calculation to the end of the GUI's event list. So it happends after the GUI has done setting up.
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    
}
