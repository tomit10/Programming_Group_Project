package courseworkX.view.panel2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import courseworkX.controller.Controller;
import courseworkX.controller.Controller.goForward;
import courseworkX.model.Model;


public class Panel2View {
	private static JFrame panel2=new JFrame("Sightings Map");
	private static ImageIcon map=new ImageIcon("USA.jpg");
	private static JLabel labelMap=new JLabel(map);
	private static ImageIcon ufo=new ImageIcon("ufo.jpg");
	private static JLabel labelUfo=new JLabel(ufo);
	private static JPanel panel2South=new JPanel();
	private static Controller controller;
	private static Model model;
	
	// constructor class for panel2
	public Panel2View(Controller controller, Model model) {
		
		this.model = model;
		this.controller = controller;
		mapUFO();
		model.addIcon();
		this.addingIcons();
	}
	
	@SuppressWarnings("serial")
	private static JPanel panel1Center=new JPanel(){
		public void paintComponent (Graphics g){
			BufferedImage PictureMap;
			try {
				PictureMap = ImageIO.read(new File("USA.jpg"));
				g.drawImage(PictureMap, 0, 0, this.getWidth(), this.getHeight(), null);
				this.setPreferredSize(new Dimension(900,700));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	
	// makes the panel2 Frame
	public static void mapUFO()
	{
		
		panel2.setLayout(new BorderLayout());
		panel1Center.setLayout(null);
		panel2.add(panel1Center,BorderLayout.CENTER);
		
		panel2South.setLayout(new FlowLayout());
		JButton forward=new JButton(">");
        forward.addActionListener(controller.new goForward());
		JButton backward=new JButton("<");
		panel2South.add(backward);
		panel2South.add(forward);
		panel2.add(panel2South,BorderLayout.SOUTH);
		
		panel2.pack();
		panel2.setSize(900, 700);
		panel2.setVisible(true);
		panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// get method for the panel 2 frame
	public JFrame getFrame2() {
		return panel2;
	}

	// a method to add an UFO icon onto panel2 when given the coordinates
	public void setIcon(int x,int y)
	{
		JLabel iconUfo = new JLabel(ufo);
		panel1Center.add(iconUfo);
		iconUfo.setBounds(0,0,x,y);
	}
	
	// checks whether there is a sighting in each state and if there is one then it adds a UFO icon
	public void addingIcons() {
		if(model.getS1() == 1) {
			this.setIcon(1158, 858);
		}
		if(model.getS2() == 1) {
			this.setIcon(290, 970);
		}
		if(model.getS3() == 1) {
			this.setIcon(420, 758);
		}
		if(model.getS4() == 1) {
			this.setIcon(970, 776);
		}
		if(model.getS5() == 1) {
			this.setIcon(224, 652);
		}
		if(model.getS6() == 1) {
			this.setIcon(610, 616);
		}
		if(model.getS7() == 1) {
			this.setIcon(1486, 458);
		}
		if(model.getS8() == 1) {
			this.setIcon(1438, 578);
		}
		if(model.getS9() == 1) {
			this.setIcon(1338, 1000);
		}
		if(model.getS10() == 1) { // georgia
			this.setIcon(1254, 842);
		}
		if(model.getS11() == 1) {
			this.setIcon(630, 1082);
		}
		if(model.getS12() == 1) {
			this.setIcon(410, 418);
		}
		if(model.getS13() == 1) {
			this.setIcon(1058, 586);
		}
		if(model.getS14() == 1) {
			this.setIcon(1140, 602);
		}
		if(model.getS15() == 1) {
			this.setIcon(944, 526);
		}
		if(model.getS16() == 1) {
			this.setIcon(812, 644);
		}
		if(model.getS17() == 1) {
			this.setIcon(1190, 668);
		}
		if(model.getS18() == 1) {
			this.setIcon(984, 912);
		}
		if(model.getS19() == 1) {
			this.setIcon(1542, 308);
		}
		if(model.getS20() == 1) { // maryland
			this.setIcon(1396, 568);
		}
		if(model.getS21() == 1) {
			this.setIcon(1498, 430);
		}
		if(model.getS22() == 1) {
			this.setIcon(1170, 460);
		}
		if(model.getS23() == 1) {
			this.setIcon(906, 368);
		}
		if(model.getS24() == 1) {
			this.setIcon(1060, 838);
		}
		if(model.getS25() == 1) {
			this.setIcon(972, 648);
		}
		if(model.getS26() == 1) {
			this.setIcon(552, 318);
		}
		if(model.getS27() == 1) {
			this.setIcon(776, 540);
		}
		if(model.getS28() == 1) {
			this.setIcon(314, 544);
		}
		if(model.getS29() == 1) {
			this.setIcon(1498, 386);
		}
		if(model.getS30() == 1) { // new jersey
			this.setIcon(1454, 542);
		}
		if(model.getS31() == 1) {
			this.setIcon(576, 780);
		}
		if(model.getS32() == 1) {
			this.setIcon(1408,434);
		}
		if(model.getS33() == 1) {
			this.setIcon(1330, 712);
		}
		if(model.getS34() == 1) { 
			this.setIcon(764, 322);
		}
		if(model.getS35() == 1) {
			this.setIcon(1232, 560);
		}
		if(model.getS36() == 1) {
			this.setIcon(836, 754);
		}
		if(model.getS37() == 1) {
			this.setIcon(246, 374);
		}
		if(model.getS38() == 1) {
			this.setIcon(1350, 518);
		}
		if(model.getS39() == 1) {
			this.setIcon(1520, 454);
		}
		if(model.getS40() == 1) { // south carolina
			this.setIcon(1320, 780);
		}
		if(model.getS41() == 1) {
			this.setIcon(762, 430);
		}
		if(model.getS42() == 1) {
			this.setIcon(1136, 736);
		}
		if(model.getS43() == 1) {
			this.setIcon(792, 902);
		}
		if(model.getS44() == 1) {
			this.setIcon(450, 586);
		}
		if(model.getS45() == 1) {
			this.setIcon(1466, 374);
		}
		if(model.getS46() == 1) {
			this.setIcon(1352, 652);
		}
		if(model.getS47() == 1) {
			this.setIcon(201, 140);
		}
		if(model.getS48() == 1) {
			this.setIcon(1292, 610);
		}
		if(model.getS49() == 1) {
			this.setIcon(1024, 418);
		}
		if(model.getS50() == 1) {
			this.setIcon(578, 472);
		}
		
	}
	
}
