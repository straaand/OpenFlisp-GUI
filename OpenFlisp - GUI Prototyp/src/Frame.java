import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 
 * @author Johan Strand
 * This class constructs the frame and the menus where the user gets access to application.
 */

public class Frame implements ActionListener	{
	private JLabel window;
	private JMenuItem menu_close, menu_item1, menu_item2, menu2;
	
	public Frame()	{
		makeFrame();
	}
	
	//construct the application window
	private void makeFrame()	{
		JFrame frame = new JFrame("OpenFlisp - GUI-prototyp");
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize(); //get size of screen
		frame.setBounds(0,0,screensize.width,screensize.height);	//set to fill screen
		//frame.setIconImage(new ImageIcon(URL_TO_FILE).getImage()); //set OpenFlisp icon to frame
		
		//the menubar
		JMenuBar menubar = new JMenuBar();
		JMenu menu;
		
		menu = new JMenu("Arkiv");	//the arkiv menu
		menubar.add(menu);	//add the menu to the menubar
		
		//the first item in Arkiv
		menu_item1 = new JMenuItem("Logik"); 
		menu_item1.addActionListener(this);
		menu.add(menu_item1);
		
		//the second item in Arkiv
		//menu.addSeparator();
		menu_item2 = new JMenuItem("Kopplingsboxen");
		menu_item2.addActionListener(this);
		menu.add(menu_item2);
		
		//the third item in Arkiv - the close operation
		menu.addSeparator();
		menu_close = new JMenuItem("Avsluta");
		menu_close.addActionListener(this);
		menu.add(menu_close);
		
		//the second menu
		menu2 = new JMenuItem("Hjälp");
		menu2.addActionListener(this);
		menubar.add(menu2);
		
		frame.setJMenuBar(menubar); //add the menubar to the frame
		
		//the window where everything appears..
		window = new JLabel();
		window.setHorizontalAlignment(SwingConstants.CENTER); //set text to center of window
		frame.add(window);
		
		//frame.setLayout(new GridLayout(2,2));
		//frame.setSize(300,300);
		//frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);		
	}
	
	//listener for the menuitems in the menubar. 
	public void actionPerformed(ActionEvent e)	{
		//avsluta programmet
		if (e.getSource() == menu_close)	{	
			System.exit(0);
		}
		//visa hjälprutan
		else if (e.getSource() == menu2)	{
			JOptionPane.showMessageDialog(null,"Detta är en prototyp. \nVersion: 2014-01-31\nAv: Johan & Fiona","OpenFlisp", JOptionPane.INFORMATION_MESSAGE);
		}
		//visa övriga menyalternativ
		else	{
			window.setText(e.getActionCommand());
			//JOptionPane.showMessageDialog(null, "Nu ska " + e.getActionCommand() + " startas..");			
		}

	}
}
