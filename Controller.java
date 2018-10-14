package courseworkX.controller;

import courseworkX.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	private Model model;

	//Initialise the controller object
	public Controller(Model model) 
	{
		this.model = model;
	}


	//Listener for Statistics' panel number 1
	public class panel1Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.changePanel1();			
		}
		
	}

	//Listener for Statistics' panel number 2
	public class panel2Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.changePanel2();
			
		}
		
	}

	//Listener for Statistics' panel number 3
	public class panel3Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.changePanel3();
			
		}
		
	}

	//Listener for Statistics' panel number 4
	public class panel4Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.changePanel4();
			
		}
		
	}
	
	// Listener for Forward button to change between panels
	public class goForward implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.changePanel();
			
		}
		
	}
	
	//Permits to set the starting year chosen in the JComboBox
	public void setFromVariable(String variable1)
    {
        model.setFrom(variable1);
    }
	
	//Permits to set the ending year chosen in the JComboBox
    public void setToVariable(String variable2)
    {
        model.setTo(variable2);
    }

   
}

