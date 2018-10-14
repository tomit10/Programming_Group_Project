package courseworkX.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import api.ripley.Incident;
import api.ripley.Ripley;

public class Model extends Observable{

	private Ripley ripley;
	private int arraySize;
	private int hoaxes = 0;
	private int nonUS = 0;
	private int likeliestState = 0;
	private int anonymous = 0;
	private String[] words;
	private ArrayList<Incident> incidents;
//	private ArrayList<ArrayList<String>> states = new ArrayList<ArrayList<String>>();
	
	private ArrayList<String> alabama = new ArrayList<String>();
	private ArrayList<String> alaska = new ArrayList<String>();
	private ArrayList<String> arizona = new ArrayList<String>();
	private ArrayList<String> arkansas = new ArrayList<String>();
	private ArrayList<String> california = new ArrayList<String>();
	private ArrayList<String> colorado = new ArrayList<String>();
	private ArrayList<String> connecticut = new ArrayList<String>();
	private ArrayList<String> delaware = new ArrayList<String>();
	private ArrayList<String> florida = new ArrayList<String>();
	private ArrayList<String> georgia = new ArrayList<String>();
	private ArrayList<String> hawaii = new ArrayList<String>();
	private ArrayList<String> idaho = new ArrayList<String>();
	private ArrayList<String> illinois = new ArrayList<String>();
	private ArrayList<String> indiana = new ArrayList<String>();
	private ArrayList<String> iowa = new ArrayList<String>();
	private ArrayList<String> kansas = new ArrayList<String>();
	private ArrayList<String> kentucky = new ArrayList<String>();
	private ArrayList<String> louisiana = new ArrayList<String>();
	private ArrayList<String> maine = new ArrayList<String>();
	private ArrayList<String> maryland = new ArrayList<String>();
	private ArrayList<String> massachusetts = new ArrayList<String>();
	private ArrayList<String> michigan = new ArrayList<String>();
	private ArrayList<String> minnesota = new ArrayList<String>();
	private ArrayList<String> mississippi = new ArrayList<String>();
	private ArrayList<String> missouri = new ArrayList<String>();
	private ArrayList<String> montana = new ArrayList<String>();
	private ArrayList<String> nebraska = new ArrayList<String>();
	private ArrayList<String> nevada = new ArrayList<String>();
	private ArrayList<String> newhampshire = new ArrayList<String>();
	private ArrayList<String> newjersey = new ArrayList<String>();
	private ArrayList<String> newmexico = new ArrayList<String>();
	private ArrayList<String> newyork = new ArrayList<String>();
	private ArrayList<String> northcarolina = new ArrayList<String>();
	private ArrayList<String> northdakota = new ArrayList<String>();
	private ArrayList<String> ohio = new ArrayList<String>();
	private ArrayList<String> oklahoma = new ArrayList<String>();
	private ArrayList<String> oregon = new ArrayList<String>();
	private ArrayList<String> pennsylvania = new ArrayList<String>();
	private ArrayList<String> rhodeisland = new ArrayList<String>();
	private ArrayList<String> southcarolina = new ArrayList<String>();
	private ArrayList<String> southdakota = new ArrayList<String>();
	private ArrayList<String> tennessee = new ArrayList<String>();
	private ArrayList<String> texas = new ArrayList<String>();
	private ArrayList<String> utah = new ArrayList<String>();
	private ArrayList<String> vermont = new ArrayList<String>();
	private ArrayList<String> virginia = new ArrayList<String>();
	private ArrayList<String> washington = new ArrayList<String>();
	private ArrayList<String> westvirginia = new ArrayList<String>();
	private ArrayList<String> wiscoswin = new ArrayList<String>();
	private ArrayList<String> wyoming = new ArrayList<String>();
	
	private int panel1;
	private int panel2;
	private int panel3;
	private int panel4;
	
	private String fromS;
	private String toS;
	private long finalTimeSecond;
	private int panelNum = 1;
	private int s1 = 0,s2 = 0,s3 = 0,s4= 0,s5= 0,s6= 0,s7= 0,s8= 0,s9= 0,s10= 0,s11= 0,s12= 0,s13= 0,s14= 0,s15= 0,s16= 0,s17= 0,s18= 0,s19= 0,s20= 0,s21= 0,s22= 0,s23= 0,s24= 0,s25= 0,s26= 0,s27= 0,s28= 0,s29= 0,s30= 0,s31= 0,s32= 0,s33= 0,s34= 0,s35= 0,s36= 0,s37= 0,s38= 0,s39= 0,s40= 0,s41= 0,s42= 0,s43= 0,s44= 0,s45= 0,s46= 0,s47= 0,s48= 0,s49 = 0,s50=0;

	// constructor for Model class
	public Model(Ripley ripley) {
		this.ripley = ripley;
		//getIncidents();
	}
	
	// method that calculates all the statistics needed for Panel 3
	public void stats() {
		if (incidents == null) arraySize = 0;
		else arraySize = incidents.size();
		for (int i = 0; i < arraySize; i++) { 
			String incidentsList = incidents.get(i).getSummary();
			words = incidentsList.split(" ");
			
			for (int j = 0; j < words.length; j++) {
				// there are two cases in which it is a hoax:
				// either there is a NUFORC Note: or it just says ((HOAX??))
				// we check for both cases and if one is true then the sighting is a Hoax
				if(words[j].contains("NUFORC") || words[j].contains("HOAX") ) {

					hoaxes++;
				}
				
				if(words[j].contains("anonymous")) {
					anonymous++;
				}
			}
			
			String variable = incidents.get(i).getState();
			
			// we check if the string corresponds to each state and assign it to each state's arrayList
			if(variable.equals("AL")) {
				alabama.add(incidents.get(i).getSummary());
				if (alabama.size() > likeliestState) {
					likeliestState = alabama.size();
				}
			} 
			if(variable.equals("AK")) {
				alaska.add(incidents.get(i).getSummary());
				if (alaska.size() > likeliestState) {
					likeliestState = alaska.size();
				}
			}
			if(variable.equals("AZ")) {
				arizona.add(incidents.get(i).getSummary());
				if (arizona.size() > likeliestState) {
					likeliestState = arizona.size();
				}
			} 
			if(variable.equals("AR")) {
				arkansas.add(incidents.get(i).getSummary());
				if (arizona.size() > likeliestState) {
					likeliestState = arizona.size();
				}
			}
			if(variable.equals("CA")) {
				california.add(incidents.get(i).getSummary());
				if (california.size() > likeliestState) {
					likeliestState = california.size();
				}
			} 
			if(variable.equals("CO")) {
				colorado.add(incidents.get(i).getSummary());
				if (colorado.size() > likeliestState) {
					likeliestState = colorado.size();
				}
			}
			if(variable.equals("CT")) {
				connecticut.add(incidents.get(i).getSummary());
				if (colorado.size() > likeliestState) {
					likeliestState = colorado.size();
				}
			} 
			if(variable.equals("DE")) {
				delaware.add(incidents.get(i).getSummary());
				if (delaware.size() > likeliestState) {
					likeliestState = delaware.size();
				}
			}
			if(variable.equals("FL")) {
				florida.add(incidents.get(i).getSummary());
				if (florida.size() > likeliestState) {
					likeliestState = florida.size();
				}
			} 
			if(variable.equals("GA")) {
				georgia.add(incidents.get(i).getSummary());
				if (georgia.size() > likeliestState) {
					likeliestState = georgia.size();
				}
			}
			if(variable.equals("HI")) {
				hawaii.add(incidents.get(i).getSummary());
				if (hawaii.size() > likeliestState) {
					likeliestState = hawaii.size();
				}
			} 
			if(variable.equals("ID")) {
				idaho.add(incidents.get(i).getSummary());
				if (idaho.size() > likeliestState) {
					likeliestState = idaho.size();
				}
			}
			if(variable.equals("IL")) {
				illinois.add(incidents.get(i).getSummary());
				if (idaho.size() > likeliestState) {
					likeliestState = idaho.size();
				}
			} 
			if(variable.equals("IN")) {
				indiana.add(incidents.get(i).getSummary());
				if (indiana.size() > likeliestState) {
					likeliestState = indiana.size();
				}
			}
			if(variable.equals("IA")) {
				iowa.add(incidents.get(i).getSummary());
				if (iowa.size() > likeliestState) {
					likeliestState = iowa.size();
				}
			} 
			if(variable.equals("KS")) {
				kansas.add(incidents.get(i).getSummary());
				if (kansas.size() > likeliestState) {
					likeliestState = kansas.size();
				}
			}
			if(variable.equals("KY")) {
				kentucky.add(incidents.get(i).getSummary());
				if (kentucky.size() > likeliestState) {
					likeliestState = kentucky.size();
				}
			} 
			if(variable.equals("LA")) {
				louisiana.add(incidents.get(i).getSummary());
				if (louisiana.size() > likeliestState) {
					likeliestState = louisiana.size();
				}
			}
			if(variable.equals("ME")) {
				maine.add(incidents.get(i).getSummary());
				if (maine.size() > likeliestState) {
					likeliestState = maine.size();
				}
			} 
			if(variable.equals("MD")) {
				maryland.add(incidents.get(i).getSummary());
				if (maryland.size() > likeliestState) {
					likeliestState = maryland.size();
				}
			}
			if(variable.equals("MA")) {
				massachusetts.add(incidents.get(i).getSummary());
				if (massachusetts.size() > likeliestState) {
					likeliestState = massachusetts.size();
				}
			} 
			if(variable.equals("MI")) {
				michigan.add(incidents.get(i).getSummary());
				if (michigan.size() > likeliestState) {
					likeliestState = michigan.size();
				}
			}
			if(variable.equals("MN")) {
				minnesota.add(incidents.get(i).getSummary());
				if (minnesota.size() > likeliestState) {
					likeliestState = minnesota.size();
				}
			} 
			if(variable.equals("MS")) {
				mississippi.add(incidents.get(i).getSummary());
				if (mississippi.size() > likeliestState) {
					likeliestState = mississippi.size();
				}
			}
			if(variable.equals("MO")) {
				missouri.add(incidents.get(i).getSummary());
				if (missouri.size() > likeliestState) {
					likeliestState = missouri.size();
				}
			}
			if(variable.equals("MT")) {
				montana.add(incidents.get(i).getSummary());
				if (montana.size() > likeliestState) {
					likeliestState = montana.size();
				}
			} 
			if(variable.equals("NE")) {
				nebraska.add(incidents.get(i).getSummary());
				if (nebraska.size() > likeliestState) {
					likeliestState = nebraska.size();
				}
			}
			if(variable.equals("NV")) {
				nevada.add(incidents.get(i).getSummary());
				if (nevada.size() > likeliestState) {
					likeliestState = nevada.size();
				}
			} 
			if(variable.equals("NH")) {
				newhampshire.add(incidents.get(i).getSummary());
				if (newhampshire.size() > likeliestState) {
					likeliestState = newhampshire.size();
				}
			}
			if(variable.equals("NJ")) {
				newjersey.add(incidents.get(i).getSummary());
				if (newjersey.size() > likeliestState) {
					likeliestState = newjersey.size();
				}
			} 
			if(variable.equals("NM")) {
				newmexico.add(incidents.get(i).getSummary());
				if (newmexico.size() > likeliestState) {
					likeliestState = newmexico.size();
				}
			}
			if(variable.equals("NY")) {
				newyork.add(incidents.get(i).getSummary());
				if (newyork.size() > likeliestState) {
					likeliestState = newyork.size();
				}
			} 
			if(variable.equals("NC")) {
				northcarolina.add(incidents.get(i).getSummary());
				if (northcarolina.size() > likeliestState) {
					likeliestState = northcarolina.size();
				}
			}
			if(variable.equals("ND")) {
				northdakota.add(incidents.get(i).getSummary());
				if (northdakota.size() > likeliestState) {
					likeliestState = northdakota.size();
				}
			} 
			if(variable.equals("OH")) {
				ohio.add(incidents.get(i).getSummary());
				if (ohio.size() > likeliestState) {
					likeliestState = ohio.size();
				}
			}
			if(variable.equals("OK")) {
				oklahoma.add(incidents.get(i).getSummary());
				if (oklahoma.size() > likeliestState) {
					likeliestState = oklahoma.size();
				}
			} 
			if(variable.equals("OR")) {
				oregon.add(incidents.get(i).getSummary());
				if (oregon.size() > likeliestState) {
					likeliestState = oregon.size();
				}
			}
			if(variable.equals("PA")) {
				pennsylvania.add(incidents.get(i).getSummary());
				if (pennsylvania.size() > likeliestState) {
					likeliestState = pennsylvania.size();
				}
			}
			if(variable.equals("RI")) {
				rhodeisland.add(incidents.get(i).getSummary());
				if (rhodeisland.size() > likeliestState) {
					likeliestState = rhodeisland.size();
				}
			} 
			if(variable.equals("SC")) {
				southcarolina.add(incidents.get(i).getSummary());
				if (southcarolina.size() > likeliestState) {
					likeliestState = southcarolina.size();
				}
			}
			if(variable.equals("SD")) {
				southdakota.add(incidents.get(i).getSummary());
				if (southdakota.size() > likeliestState) {
					likeliestState = southdakota.size();
				}
			} 
			if(variable.equals("TN")) {
				tennessee.add(incidents.get(i).getSummary());
				if (tennessee.size() > likeliestState) {
					likeliestState = tennessee.size();
				}
			}
			if(variable.equals("TX")) {
				texas.add(incidents.get(i).getSummary());
				if (texas.size() > likeliestState) {
					likeliestState = texas.size();
				}
			} 
			if(variable.equals("UT")) {
				utah.add(incidents.get(i).getSummary());
				if (utah.size() > likeliestState) {
					likeliestState = utah.size();
				}
			}
			if(variable.equals("VT")) {
				vermont.add(incidents.get(i).getSummary());
				if (vermont.size() > likeliestState) {
					likeliestState = vermont.size();
				}
			} 
			if(variable.equals("VA")) {
				virginia.add(incidents.get(i).getSummary());
				if (virginia.size() > likeliestState) {
					likeliestState = virginia.size();
				}
			}
			if(variable.equals("WA")) {
				washington.add(incidents.get(i).getSummary());
				if (washington.size() > likeliestState) {
					likeliestState = washington.size();
				}
			} 
			if(variable.equals("WV")) {
				westvirginia.add(incidents.get(i).getSummary());
				if (westvirginia.size() > likeliestState) {
					likeliestState = westvirginia.size();
				}
			}
			if(variable.equals("WI")) {
				wiscoswin.add(incidents.get(i).getSummary());
				if (wiscoswin.size() > likeliestState) {
					likeliestState = wiscoswin.size();
				}
			} 
			if(variable.equals("WY")) {
				wyoming.add(incidents.get(i).getSummary());
				if (wyoming.size() > likeliestState) {
					likeliestState = wyoming.size();
				}
			}
			
			
			// If the string does not have a corresponding state, then it is assumed it isn't in the US
			if(variable.equals("Not specified.")) {
//				System.out.println(incidents.get(i));
				nonUS++;
			} else {
//				System.out.println(incidents.get(i).getIncidentID() + " " +  incidents.get(i).getState());

			}
		}

	}
	
	// Method to determine whether each state has a UFO sighting or not 
	public void addIcon() {
		if (incidents == null) arraySize = 0;
		else arraySize = incidents.size();
		for (int i = 0; i < arraySize; i++) {
			
			String variable = incidents.get(i).getState();
			
			// we check if the string corresponds to each state and assign it to each state's arrayList
			if(variable.equals("AL")&&s1==0) {
				s1++;
			} 
			if(variable.equals("AK")&& s2==0) {
				s2++;
			}
			if(variable.equals("AZ")&& s3==0) {
				s3++;
			} 
			if(variable.equals("AR")&& s4==0) {
				s4++;
			}
			if(variable.equals("CA")&& s5==0) {
				s5++;
			} 
			if(variable.equals("CO")&& s6==0) {
				s6++;
			}
			if(variable.equals("CT")&& s7==0) {
				s7++;
			} 
			if(variable.equals("DE")&& s8==0) {
				s8++;
			}
			if(variable.equals("FL")&& s9==0) {
				s9++;
			} 
			if(variable.equals("GA")&& s10==0) {
				s10++;
			}
			if(variable.equals("HI")&& s11==0) {
				s11++;
			} 
			if(variable.equals("ID")&& s12==0) {
				s12++;
			}
			if(variable.equals("IL")&& s13==0) {
				s13++;
			} 
			if(variable.equals("IN")&& s14==0) {
				s14++;
			}
			if(variable.equals("IA")&& s15==0) {
				s15++;
			} 
			if(variable.equals("KS")&& s16==0) {
				s16++;
			}
			if(variable.equals("KY")&& s17==0) {
				s17++;
			} 
			if(variable.equals("LA")&& s18==0) {
				s18++;
			}
			if(variable.equals("ME")&& s19==0) {
				s19++;
			} 
			if(variable.equals("MD")&& s20==0) {
				s20++;
			}
			if(variable.equals("MA")&& s21==0) {
				s21++;
			} 
			if(variable.equals("MI")&& s22==0) {
				s22++;
			}
			if(variable.equals("MN")&& s23==0) {
				s23++;
			} 
			if(variable.equals("MS")&& s24==0) {
				s24++;
			}
			if(variable.equals("MO")&& s25==0) {
				s25++;
			}
			if(variable.equals("MT")&& s26==0) {
				s26++;
			} 
			if(variable.equals("NE")&& s27==0) {
				s27++;
			}
			if(variable.equals("NV")&& s28==0) {
				s28++;
			} 
			if(variable.equals("NH")&& s29==0) {
				s29++;
			}
			if(variable.equals("NJ")&& s30==0) {
				s30++;
			} 
			if(variable.equals("NM")&& s31==0) {
				s31++;
			}
			if(variable.equals("NY")&& s32==0) {
				s32++;
			} 
			if(variable.equals("NC")&& s33==0) {
				s33++;
			}
			if(variable.equals("ND")&& s34==0) {
				s34++;
			} 
			if(variable.equals("OH")&& s35==0) {
				s35++;
			}
			if(variable.equals("OK")&& s36==0) {
				s36++;
			} 
			if(variable.equals("OR")&& s37==0) {
				s37++;
			}
			if(variable.equals("PA")&& s38==0) {
				s38++;
			}
			if(variable.equals("RI")&& s39==0) {
				s39++;
			} 
			if(variable.equals("SC")&& s40==0) {
				s40++;
			}
			if(variable.equals("SD")&& s41==0) {
				s41++;
			} 
			if(variable.equals("TN")&& s42==0) {
				s42++;
			}
			if(variable.equals("TX")&& s43==0) {
				s43++;
			} 
			if(variable.equals("UT")&& s44==0) {
				s44++;
			}
			if(variable.equals("VT")&& s45==0) {
				s45++;
			} 
			if(variable.equals("VA")&& s46==0) {
				s46++;
			}
			if(variable.equals("WA")&& s47==0) {
				s47++;
			} 
			if(variable.equals("WV")&& s48==0) {
				s48++;
			}
			if(variable.equals("WI")&& s49==0) {
				s49++;
			} 
			if(variable.equals("WY")&& s50==0) {
				s50++;
			}
			
		}
		
	}

	// allows to pull data from ripley and then show the time it took
	public long getIncidents(String fromS, String toS) {
        long start = System.currentTimeMillis();
        System.out.println(fromS+"-01-01 00:00:00" + " " + toS + "-12-31 23:59:59");
        if (toS != " - " && fromS != " - " && toS != null && fromS != null) incidents = ripley.getIncidentsInRange(fromS+"-01-01 00:00:00", toS+"-12-31 23:59:59");
        long end = System.currentTimeMillis();

        finalTimeSecond=((end-start)/1000);
        return finalTimeSecond;
    }
	
	// change value of panel1 from 0 to 1 or from 1 to 0 
	public void changePanel1() {
        stats();
		if(panel1 == 0){
			panel1 = 1;
			setChanged();
			notifyObservers();
		} else {
			panel1 = 0;
			setChanged();
			notifyObservers();
		}
	}
	
	// change value of panel2 from 0 to 1 or from 1 to 0 
	public void changePanel2() {
		if(panel2 == 0){
			panel2 = 1;
			setChanged();
			notifyObservers();
		} else {
			panel2 = 0;
			setChanged();
			notifyObservers();
		}
	}
	
	// change value of panel3 from 0 to 1 or from 1 to 0 
	public void changePanel3() {
		if(panel3 == 0){
			panel3 = 1;
			setChanged();
			notifyObservers();
		} else {
			panel3 = 0;
			setChanged();
			notifyObservers();
		}
	}
	
	// change value of panel4 from 0 to 1 or from 1 to 0 
	public void changePanel4() {
		if(panel4 == 0){
			panel4 = 1;
			setChanged();
			notifyObservers();
		} else {
			panel4 = 0;
			setChanged();
			notifyObservers();
		}
	}
	
	//Getters method for Statistics' panel
	public int getPanel1(){
		return panel1;
	}
	public int getPanel2(){
		return panel2;
	}
	public int getPanel3(){
		return panel3;
	}
	public int getPanel4(){
		return panel4;
	}
	
	//Sets the starting year chosen in the JComboBox
	public void setFrom(String value)
	{
		fromS=value;
	}
	//Sets the ending year chosen in the JComboBox
	public void setTo(String value)
	{
		toS=value;
	}
	// Get method for number of hoaxes for Panel 3
	public int getHoaxes() {
		return hoaxes;
	}
	// Get method for number of non-US sightings for Panel 3 
	public int getNonUS() {
		return nonUS;
	}
	// Get method for likeliest state for Panel 3
	public int getLikeliestState() {
		return likeliestState;
	}
	// Get method for number of anonymous reports for Panel 3
	public int getAnon() {
		return anonymous;
	}
	
	// changes the counter to know which panel the main view will need to be
	public void changePanel() {
		panelNum++;
		setChanged();
		notifyObservers();
	}
	// returns the value of the current panel we should be in
	public int getPanelNum() {
		return panelNum;
		
	}
	
	// setters and getters for s1 to s50
	public int getS1() {
		return s1;
	}

	public int getS2() {
		return s2;
	}

	public void setS2(int s2) {
		this.s2 = s2;
	}

	public int getS3() {
		return s3;
	}

	public void setS3(int s3) {
		this.s3 = s3;
	}

	public int getS4() {
		return s4;
	}

	public void setS4(int s4) {
		this.s4 = s4;
	}

	public int getS5() {
		return s5;
	}

	public void setS5(int s5) {
		this.s5 = s5;
	}

	public int getS6() {
		return s6;
	}

	public void setS6(int s6) {
		this.s6 = s6;
	}

	public int getS7() {
		return s7;
	}

	public void setS7(int s7) {
		this.s7 = s7;
	}

	public int getS8() {
		return s8;
	}

	public void setS8(int s8) {
		this.s8 = s8;
	}

	public int getS9() {
		return s9;
	}

	public void setS9(int s9) {
		this.s9 = s9;
	}

	public int getS10() {
		return s10;
	}

	public void setS10(int s10) {
		this.s10 = s10;
	}

	public int getS11() {
		return s11;
	}

	public void setS11(int s11) {
		this.s11 = s11;
	}

	public int getS12() {
		return s12;
	}

	public void setS12(int s12) {
		this.s12 = s12;
	}

	public int getS13() {
		return s13;
	}

	public void setS13(int s13) {
		this.s13 = s13;
	}

	public int getS14() {
		return s14;
	}

	public void setS14(int s14) {
		this.s14 = s14;
	}

	public int getS15() {
		return s15;
	}

	public void setS15(int s15) {
		this.s15 = s15;
	}

	public int getS16() {
		return s16;
	}

	public void setS16(int s16) {
		this.s16 = s16;
	}

	public int getS17() {
		return s17;
	}

	public void setS17(int s17) {
		this.s17 = s17;
	}

	public int getS18() {
		return s18;
	}

	public void setS18(int s18) {
		this.s18 = s18;
	}

	public int getS19() {
		return s19;
	}

	public void setS19(int s19) {
		this.s19 = s19;
	}

	public int getS20() {
		return s20;
	}

	public void setS20(int s20) {
		this.s20 = s20;
	}

	public int getS21() {
		return s21;
	}

	public void setS21(int s21) {
		this.s21 = s21;
	}

	public int getS22() {
		return s22;
	}

	public void setS22(int s22) {
		this.s22 = s22;
	}

	public int getS23() {
		return s23;
	}

	public void setS23(int s23) {
		this.s23 = s23;
	}

	public int getS24() {
		return s24;
	}

	public void setS24(int s24) {
		this.s24 = s24;
	}

	public int getS25() {
		return s25;
	}

	public void setS25(int s25) {
		this.s25 = s25;
	}

	public int getS26() {
		return s26;
	}

	public void setS26(int s26) {
		this.s26 = s26;
	}

	public int getS27() {
		return s27;
	}

	public void setS27(int s27) {
		this.s27 = s27;
	}

	public int getS28() {
		return s28;
	}

	public void setS28(int s28) {
		this.s28 = s28;
	}

	public int getS29() {
		return s29;
	}

	public void setS29(int s29) {
		this.s29 = s29;
	}

	public int getS30() {
		return s30;
	}

	public void setS30(int s30) {
		this.s30 = s30;
	}

	public int getS31() {
		return s31;
	}

	public void setS31(int s31) {
		this.s31 = s31;
	}

	public int getS32() {
		return s32;
	}

	public void setS32(int s32) {
		this.s32 = s32;
	}

	public int getS33() {
		return s33;
	}

	public void setS33(int s33) {
		this.s33 = s33;
	}

	public int getS34() {
		return s34;
	}

	public void setS34(int s34) {
		this.s34 = s34;
	}

	public int getS35() {
		return s35;
	}

	public void setS35(int s35) {
		this.s35 = s35;
	}

	public int getS36() {
		return s36;
	}

	public void setS36(int s36) {
		this.s36 = s36;
	}

	public int getS37() {
		return s37;
	}

	public void setS37(int s37) {
		this.s37 = s37;
	}

	public int getS38() {
		return s38;
	}

	public void setS38(int s38) {
		this.s38 = s38;
	}

	public int getS39() {
		return s39;
	}

	public void setS39(int s39) {
		this.s39 = s39;
	}

	public int getS40() {
		return s40;
	}

	public void setS40(int s40) {
		this.s40 = s40;
	}

	public int getS41() {
		return s41;
	}

	public void setS41(int s41) {
		this.s41 = s41;
	}

	public int getS42() {
		return s42;
	}

	public void setS42(int s42) {
		this.s42 = s42;
	}

	public int getS43() {
		return s43;
	}

	public void setS43(int s43) {
		this.s43 = s43;
	}

	public int getS44() {
		return s44;
	}

	public void setS44(int s44) {
		this.s44 = s44;
	}

	public int getS45() {
		return s45;
	}

	public void setS45(int s45) {
		this.s45 = s45;
	}

	public int getS46() {
		return s46;
	}

	public void setS46(int s46) {
		this.s46 = s46;
	}

	public int getS47() {
		return s47;
	}

	public void setS47(int s47) {
		this.s47 = s47;
	}

	public int getS48() {
		return s48;
	}

	public void setS48(int s48) {
		this.s48 = s48;
	}

	public int getS49() {
		return s49;
	}

	public void setS49(int s49) {
		this.s49 = s49;
	}

	public int getS50() {
		return s50;
	}

	public void setS50(int s50) {
		this.s50 = s50;
	}
	
	
	
}

