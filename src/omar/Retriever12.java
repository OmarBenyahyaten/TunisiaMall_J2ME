package omar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.location.*;

public class Retriever12 extends Thread {

        public double a;
        public double b;

	public Retriever12()
		{
			/**
			  * Constructor
			  *
			  * EFFECTS: Initialise the server and store midlet information
			  *
			  * @param midlet The main application midlet
			  * @param server Forecast Server URL
			  *
			  */
			//this.midlet = midlet;

	}

	public void run()
		{
			/**
			* Entry point of the thread
			*
			* EFFECTS: call to connect() method
			*/
			try {
							checkLocation();
						} catch (Exception ex)
						{
							ex.printStackTrace();
							//midlet.displayString(ex.toString());
			}


		}

	public String checkLocation() throws Exception
	{
		String string;
                String string2;
		Location l;
		LocationProvider lp;
		Coordinates c;
		// Set criteria for selecting a location provider:
		// accurate to 500 meters horizontally
		Criteria cr= new Criteria();
		cr.setHorizontalAccuracy(500);

		// Get an instance of the provider
		lp= LocationProvider.getInstance(cr);

		// Request the location, setting a one-minute timeout
		l = lp.getLocation(60);
		c = l.getQualifiedCoordinates();










		if(c != null ) {
		  // Use coordinate information
		  double lat = c.getLatitude();
		  double lon = c.getLongitude();
		  string = "\nLatitude : " + lat + "\nLongitude : " + lon;
                  string2=lat+","+lon;
                   this.a=lat;
                   this.b=lon;

		} else {
			string ="Location API failed";
                        string2="";
		}

		//midlet.displayString(string);
                return string2;

	}



}