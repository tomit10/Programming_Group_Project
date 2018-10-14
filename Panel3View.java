package courseworkX.view.panel3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import api.ripley.Ripley;
import courseworkX.controller.Controller;
import courseworkX.controller.Controller.goForward;
import courseworkX.controller.Controller.panel1Listener;
import courseworkX.controller.Controller.panel2Listener;
import courseworkX.controller.Controller.panel3Listener;
import courseworkX.controller.Controller.panel4Listener;
import courseworkX.model.Model;



public class Panel3View extends JFrame implements Observer{
	
			
	// We need to make one JPanel for each statistic, 8 in total
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();
	
	private JPanel panelWest = new JPanel();
	private JPanel panelEast = new JPanel();
	
	private Controller controller;
	private Model model;
	
	private int t;


	// constructor for the class
	public Panel3View(Controller controller, Model model) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.controller = controller;
		this.model = model;
		model.addObserver(this);
		
		panel1Listener list1 = controller.new panel1Listener();
		panel2Listener list2 = controller.new panel2Listener();
		panel3Listener list3 = controller.new panel3Listener();
		panel4Listener list4 = controller.new panel4Listener();
		
		
		// Then we make a JPanel for the bottom of the screen to list all the names of the statistics
		JPanel panelSouth = new JPanel(); // going to contain JButtons to link to other statistics
		panelSouth.setLayout(new FlowLayout());
		JButton forward=new JButton(">");
        forward.addActionListener(controller.new goForward());
		JButton backward=new JButton("<");
		panelSouth.add(backward);
		panelSouth.add(forward);
		
		// 1 other panel as a big title for the frame
		JPanel panelNorth = new JPanel();
		JLabel label1 = new JLabel("Statistics");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setVerticalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD, 20));
		panelNorth.add(label1);
		
		// Let's make the 8 panels that correspond to each statistic:
		
		// Panel 1: Hoaxes, create all of its components
		JLabel panel11 = new JLabel("Hoaxes:");
		JLabel panel12 = new JLabel(Integer.toString(model.getHoaxes()));
		JButton button11 = new JButton("<");
		JButton button12 = new JButton(">");
		
		// We make the central number, the statistic, bigger and bold so we can see it better
		panel12.setVerticalAlignment(SwingConstants.CENTER);
		panel12.setHorizontalAlignment(SwingConstants.CENTER);
		panel12.setFont(new Font("Courier", Font.BOLD, 30));
		
		// And also make the name of the statistic central to be seen better
		panel11.setHorizontalAlignment(SwingConstants.CENTER);
		panel11.setVerticalAlignment(SwingConstants.CENTER);
		
		// Now we place them in the panel
		panel1.setLayout(new BorderLayout());
		panel1.add(panel11, BorderLayout.NORTH);
		panel1.add(panel12, BorderLayout.CENTER);
		panel1.add(button11, BorderLayout.WEST);
		panel1.add(button12, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button11.addActionListener(list1);
		button12.addActionListener(list1);
		
		// Panel 2: Non-US Sightings, create all of its components:
		JLabel panel21 = new JLabel("Non-US Sightings: ");
		JLabel panel22 = new JLabel(Integer.toString(model.getNonUS()));
		JButton button21 = new JButton("<");
		JButton button22 = new JButton(">");
				
		//We make the central number, the statistic bigger and bold so we can see it better
		panel22.setVerticalAlignment(SwingConstants.CENTER);
		panel22.setHorizontalAlignment(SwingConstants.CENTER);
		panel22.setFont(new Font("Courier", Font.BOLD, 30));
				
		//And also make the name of the statistic central to be seen better
		panel21.setHorizontalAlignment(SwingConstants.CENTER);
		panel21.setVerticalAlignment(SwingConstants.CENTER);
						
		// Now we place them into the panel
		panel2.setLayout(new BorderLayout());
		panel2.add(panel21, BorderLayout.NORTH);
		panel2.add(panel22, BorderLayout.CENTER);
		panel2.add(button21, BorderLayout.WEST);
		panel2.add(button22, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button21.addActionListener(list2);
		button22.addActionListener(list2);
		
		// Panel 3: Likeliest State, create all of its components
		JLabel panel31 = new JLabel("Likeliest State:");
		JLabel panel32 = new JLabel(Integer.toString(model.getLikeliestState()));
		JButton button31 = new JButton("<");
		JButton button32 = new JButton(">");
				
		// We make the central number, the statistic, bigger and bold so we can see it better
		panel32.setVerticalAlignment(SwingConstants.CENTER);
		panel32.setHorizontalAlignment(SwingConstants.CENTER);
		panel32.setFont(new Font("Courier", Font.BOLD, 30));
				
		// And also make the name of the statistic central to be seen better
		panel31.setHorizontalAlignment(SwingConstants.CENTER);
		panel31.setVerticalAlignment(SwingConstants.CENTER);
				
		// Now we place them in the panel
		panel3.setLayout(new BorderLayout());
		panel3.add(panel31, BorderLayout.NORTH);
		panel3.add(panel32, BorderLayout.CENTER);
		panel3.add(button31, BorderLayout.WEST);
		panel3.add(button32, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button31.addActionListener(list3);
		button32.addActionListener(list3);
		
		// Panel 4: Sightings via other platforms, create all of its components:
		JLabel panel41 = new JLabel("Sightings via other platforms:");
		JLabel panel42 = new JLabel("593 videos in 3 months");
		JButton button41 = new JButton("<");
		JButton button42 = new JButton(">");
		
		// We make the central number, the statistic, bigger and bold so we can see it better
		panel42.setVerticalAlignment(SwingConstants.CENTER);
		panel42.setHorizontalAlignment(SwingConstants.CENTER);
		panel42.setFont(new Font("Courier", Font.BOLD, 30));
		
		// And also make the name of the statistic central to be seen better
		panel41.setHorizontalAlignment(SwingConstants.CENTER);
		panel41.setVerticalAlignment(SwingConstants.CENTER);
		
		// Now we place them into the panel
		panel4.setLayout(new BorderLayout());
		panel4.add(panel41, BorderLayout.NORTH);
		panel4.add(panel42, BorderLayout.CENTER);
		panel4.add(button41, BorderLayout.WEST);
		panel4.add(button42, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button41.addActionListener(list4);
		button42.addActionListener(list4);
		
		// Panel 5: name, create all of its components:
		JLabel panel51 = new JLabel("Number of anonymous reports:");
		JLabel panel52 = new JLabel(Integer.toString(model.getAnon()));
		JButton button51 = new JButton("<");
		JButton button52 = new JButton(">");
		
		//We make the central number, the statistic bigger and bold so we can see it better
		panel52.setVerticalAlignment(SwingConstants.CENTER);
		panel52.setHorizontalAlignment(SwingConstants.CENTER);
		panel52.setFont(new Font("Courier", Font.BOLD, 30));
		
		//And also make the name of the statistic central to be seen better
		panel51.setHorizontalAlignment(SwingConstants.CENTER);
		panel51.setVerticalAlignment(SwingConstants.CENTER);
		
		// Now we place them into the panel
		panel5.setLayout(new BorderLayout());
		panel5.add(panel51, BorderLayout.NORTH);
		panel5.add(panel52, BorderLayout.CENTER);
		panel5.add(button51, BorderLayout.WEST);
		panel5.add(button52, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button51.addActionListener(list1);
		button52.addActionListener(list1);
		
		// Panel 6: name, create all of its components:
		JLabel panel61 = new JLabel("Least likely State for a sighting:");
		JLabel panel62 = new JLabel("New York");
		JButton button61 = new JButton("<");
		JButton button62 = new JButton(">");
		
		//We make the central number, the statistic bigger and bold so we can see it better
		panel62.setVerticalAlignment(SwingConstants.CENTER);
		panel62.setHorizontalAlignment(SwingConstants.CENTER);
		panel62.setFont(new Font("Courier", Font.BOLD, 30));
		
		//And also make the name of the statistic central to be seen better
		panel61.setHorizontalAlignment(SwingConstants.CENTER);
		panel61.setVerticalAlignment(SwingConstants.CENTER);
				
		// Now we place them into the panel
		panel6.setLayout(new BorderLayout());
		panel6.add(panel61, BorderLayout.NORTH);
		panel6.add(panel62, BorderLayout.CENTER);
		panel6.add(button61, BorderLayout.WEST);
		panel6.add(button62, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button61.addActionListener(list2);
		button62.addActionListener(list2);
		
		// Panel 7: name, create all of its components:
		JLabel panel71 = new JLabel("State with the most Hoaxes:");
		JLabel panel72 = new JLabel("Nevada");
		JButton button71 = new JButton("<");
		JButton button72 = new JButton(">");
				
		//We make the central number, the statistic bigger and bold so we can see it better
		panel72.setVerticalAlignment(SwingConstants.CENTER);
		panel72.setHorizontalAlignment(SwingConstants.CENTER);
		panel72.setFont(new Font("Courier", Font.BOLD, 30));
				
		//And also make the name of the statistic central to be seen better
		panel71.setHorizontalAlignment(SwingConstants.CENTER);
		panel71.setVerticalAlignment(SwingConstants.CENTER);
						
		// Now we place them into the panel
		panel7.setLayout(new BorderLayout());
		panel7.add(panel71, BorderLayout.NORTH);
		panel7.add(panel72, BorderLayout.CENTER);
		panel7.add(button71, BorderLayout.WEST);
		panel7.add(button72, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button71.addActionListener(list3);
		button72.addActionListener(list3);
		
		// Panel 8: name, create all of its components:
		JLabel panel81 = new JLabel("Like hour of a sighting");
		JLabel panel82 = new JLabel("8 pm");
		JButton button81 = new JButton("<");
		JButton button82 = new JButton(">");
				
		//We make the central number, the statistic bigger and bold so we can see it better
		panel82.setVerticalAlignment(SwingConstants.CENTER);
		panel82.setHorizontalAlignment(SwingConstants.CENTER);
		panel82.setFont(new Font("Courier", Font.BOLD, 30));
				
		//And also make the name of the statistic central to be seen better
		panel81.setHorizontalAlignment(SwingConstants.CENTER);
		panel81.setVerticalAlignment(SwingConstants.CENTER);
						
		// Now we place them into the panel
		panel8.setLayout(new BorderLayout());
		panel8.add(panel81, BorderLayout.NORTH);
		panel8.add(panel82, BorderLayout.CENTER);
		panel8.add(button81, BorderLayout.WEST);
		panel8.add(button82, BorderLayout.EAST);
		
		// Add action listener to the buttons
		button81.addActionListener(list4);
		button82.addActionListener(list4);
		
		// Set preferred size of the panels 
		panel1.setPreferredSize(new Dimension(600,300));
		panel2.setPreferredSize(new Dimension(600,300));
		panel3.setPreferredSize(new Dimension(600,300));
		panel4.setPreferredSize(new Dimension(600,300));
		panel5.setPreferredSize(new Dimension(600,300));
		panel6.setPreferredSize(new Dimension(600,300));
		panel7.setPreferredSize(new Dimension(600,300));
		panel8.setPreferredSize(new Dimension(600,300));
		
		// Add the displayed panels to the bigger panels which will contain them
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panel1, BorderLayout.NORTH);
		panelWest.add(panel2, BorderLayout.SOUTH);
		panelEast.setLayout(new BorderLayout());
		panelEast.add(panel3, BorderLayout.NORTH);
		panelEast.add(panel4, BorderLayout.SOUTH);
		
		
		// Add the panels to the JFrame
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panelNorth, BorderLayout.NORTH);
		this.getContentPane().add(panelWest, BorderLayout.WEST);
		this.getContentPane().add(panelEast, BorderLayout.EAST);
		this.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		this.pack();
//        frame.setSize(1400, 750);      

		
		// Make the JFrame visible
		this.setVisible(true);
		
		
	}
	
	public void setT(int t){
		this.t= t;
	}
	
	public int getT() {
		return t;
	}
	
	// method called to see if the panel1 needs to be changed to panel 5 or vice versa 
	public void changePanel1(int x) {
		if(x == 1){
			panelWest.remove(panel1);
			panelWest.add(panel5, BorderLayout.NORTH);
		} else if (x == 0){
			panelWest.remove(panel5);
			panelWest.add(panel1, BorderLayout.NORTH);
		}
	}
	
	// method called to see if the panel 2 needs to be changed to panel 6 or vice versa 
	public void changePanel2(int x) {
		if(x == 1) {
			panelWest.remove(panel2);
			panelWest.add(panel6, BorderLayout.SOUTH);
		} else if (x == 0){
			panelWest.remove(panel6);
			panelWest.add(panel2, BorderLayout.SOUTH);
		}
	}
	
	// method called to see if the panel 3 needs to be changed to panel 7 or vice versa 
	public void changePanel3(int x) {
		if(x == 1) {
			panelEast.remove(panel3);
			panelEast.add(panel7, BorderLayout.NORTH);
		} else if (x == 0) {
			panelEast.remove(panel7);
			panelEast.add(panel3, BorderLayout.NORTH);
		}
	}
	
	// method called to see if the panel 4 needs to be changed to panel 8 or vice versa 
	public void changePanel4(int x) {
		if(x == 1) {
			panelEast.remove(panel4);
			panelEast.add(panel8, BorderLayout.SOUTH);
		} else if (x == 0){
			panelEast.remove(panel8);
			panelEast.add(panel4, BorderLayout.SOUTH);
		}
	}
	
	//when the model tells the Panel3View it has been changed
	@Override
	public void update(Observable o, Object arg) {
		this.setVisible(false);
		this.changePanel1(model.getPanel1());
		this.changePanel2(model.getPanel2());
		this.changePanel3(model.getPanel3());
		this.changePanel4(model.getPanel4());
		this.setVisible(true);
	}
	
	
}
