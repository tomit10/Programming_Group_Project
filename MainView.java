package courseworkX.view;

import api.ripley.Ripley;

import courseworkX.controller.Controller;
import courseworkX.model.Model;
import courseworkX.view.panel2.Panel2View;
import courseworkX.view.panel3.Panel3View;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainView extends JFrame implements Observer{

    private Model model;
    String fromS;
    String toS;
    private Panel2View view2;
    private Panel3View view3;
    private int viewTrack = 1;

    private Ripley ripley;

    //widgets for main frame
    private JPanel northPanel; 
    private JPanel centerPanel; 
    private JPanel southPanel;
    private JLabel fromLabel;
    private JLabel toLabel; 
    private JLabel bottomLabel;
    private JLabel welcomeLabel;
    private JButton forward;
    private JButton backward;
    private JComboBox fromDropDown; 
    private JComboBox toDropDown;
    private Controller controller;
    private String timeTaken;

    //constructor for main view
    public MainView(Controller controller, Model model, Ripley ripley) {

        super();
        //set fields
        this.model = model;
        this.controller=controller;
        this.ripley = ripley;
        fromS = " - ";
        toS = " - ";
        //calls initialise widgets method
        initWidgets();
        model.addObserver(this);
        
    }

    //method sets up the frame
    private void initWidgets() {

        //panels
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        //labels
        fromLabel = new JLabel("From: ");
        toLabel = new JLabel("To: ");
        bottomLabel = new JLabel(" " +ripley.getLastUpdated()+" ");
        
        //buttons
        forward=new JButton(">");
        forward.addActionListener(controller.new goForward());
        backward=new JButton("<");
        forward.setEnabled(false);
        backward.setEnabled(false);

        //adding panels to frame
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        //drop down menus
        fromDropDown = new JComboBox();
        dateDropDown(fromDropDown);
        //Listener for the JComboBox option
        fromDropDown.addActionListener(e -> {
            fromS = (String)fromDropDown.getSelectedItem();
            if (toS != " - " && toS != null) updateMessage1();
            controller.setFromVariable(fromS);
            timeTaken = "Time taken to grab data: " + model.getIncidents(fromS, toS) + " seconds.";
            model.stats();
            System.out.println(timeTaken);
            if (toS != " - " && toS != null) updateMessage2();
            model.changePanel1();
        });
        
        toDropDown = new JComboBox();
        dateDropDown(toDropDown);
        //Listener for the JComboBox option
        toDropDown.addActionListener(e -> {
            toS = (String)toDropDown.getSelectedItem();
            if (fromS != " - " && fromS != null) updateMessage1();
            controller.setToVariable(toS);
            timeTaken = "Time taken to grab data: " + model.getIncidents(fromS, toS) + " seconds.";
            model.stats();
            System.out.println(timeTaken);
            if (fromS != " - " && fromS != null) updateMessage2();
            forward.setEnabled(true);
            backward.setEnabled(true);
            model.changePanel1();
        });

        //adding drop downs and corresponding labels to top right of the frame
        northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        northPanel.add(fromLabel);
        northPanel.add(fromDropDown);
        northPanel.add(toLabel);
        northPanel.add(toDropDown);

        //last updated label added to bottom of frame
        southPanel.setLayout(new BorderLayout());
        southPanel.add(bottomLabel,BorderLayout.CENTER);
        southPanel.add(forward,BorderLayout.EAST);
        southPanel.add(backward,BorderLayout.WEST);

        welcome();

        pack();
        //set default size of frame
        setSize(550, 600);
        setVisible(true);
        //exits on close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // welcome message for panel1
    private void welcome() {
        welcomeLabel = new JLabel("<html><body><center>Welcome to the Ripley API v"+Double.toString(ripley.getVersion())+"<br><br>Please select from the dates above in order to <br><br>begin analysing UFO sighting data.</center></body></html>");
        centerPanel.add(welcomeLabel);
    }

    private void dateDropDown(JComboBox dropDown) {
        dropDown.addItem(" - ");
        //options for date drop down menus
        for (int i = ripley.getStartYear(); i <= ripley.getLatestYear(); i++){
            dropDown.addItem(Integer.toString(i));
        }
    }

    // initial welcome message
    public void updateMessage1() {

        welcomeLabel.setText("<html><body><center>Welcome to the Ripley API v"+Double.toString(ripley.getVersion())+"<br><br>Please select from the dates above in order to <br>begin analysing UFO sighting data.<br><br>Grabbing data...");
        pack();
        setSize(550, 600);
        //model.changePanel1();
    }
    
    // welcome message after the data has been grabbed
    public void updateMessage2() {

        welcomeLabel.setText("<html><body><center>Welcome to the Ripley API v"+Double.toString(ripley.getVersion())+"<br><br>Please select from the dates above in order to <br>begin analysing UFO sighting data.<br><br>Grabbing data...<br><br>" + timeTaken+"</center></body></html>");
        pack();
        setSize(550, 600);
        //model.changePanel1();
    }
    
    // method called to change from a panel to the next one
    public void goForward() {
    	if (viewTrack == 1) {
    		// does nothing because we stay in the current panel
    	}
    	else if( viewTrack == 2 ) {
    		this.setVisible(false);
    		view2 = new Panel2View(controller, model);
    		view2.getFrame2().setVisible(true);
    	}
    	
    	else if ( viewTrack == 3) {
    		view2.getFrame2().setVisible(false);
    		view3 = new Panel3View(controller, model);
    		view3.setVisible(true);
    	}
    }

    // when the model tells the main view it has been changed
	@Override
	public void update(Observable o, Object arg) {
			viewTrack = model.getPanelNum();
			this.goForward();
	}


}