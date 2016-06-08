package omar;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mahmoud
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;


import com.jappit.midmaps.googlemaps.GoogleMaps;
import com.jappit.midmaps.googlemaps.GoogleMapsCoordinates;
import com.jappit.midmaps.googlemaps.GoogleMapsGeocoderHandler;
import com.jappit.midmaps.googlemaps.GoogleMapsMarker;
import com.jappit.midmaps.googlemaps.GoogleMapsPath;
import com.jappit.midmaps.googlemaps.GoogleStaticMap;
import com.jappit.midmaps.googlemaps.GoogleStaticMapHandler;
import javax.microedition.location.Coordinates;
import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationProvider;
import tnMallMidlet.Login;

public class GoogleMapsPathCanvas extends GoogleMapsTestCanvas implements GoogleStaticMapHandler
{
	GoogleMaps gMaps = null;
	
	GoogleStaticMap map = null;
        Retriever12 res=new Retriever12();
          
        double lat ;
        double lon;
	
	public GoogleMapsPathCanvas(MIDlet m, Displayable testListScreen,double a,double b)
	{
		super(m, testListScreen);
                
		
		gMaps = new GoogleMaps();
		
		map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
		
		map.setHandler(this);
		
		map.setCenter(new GoogleMapsCoordinates(36.899313, 10.188750));
		
		map.setZoom(15);
		
		GoogleMapsPath path = new GoogleMapsPath();
		path.addPoint(new GoogleMapsCoordinates(36.899313, 10.188750));
		path.addPoint(new GoogleMapsCoordinates(a,b));
		path.setColor(GoogleStaticMap.COLOR_RED);
		path.setWeight(10);
		map.addPath(path);
		
		map.update();
	}
	
	protected void paint(Graphics g)
	{
		map.draw(g, 0, 0, Graphics.TOP | Graphics.LEFT);
	}
	
	public void GoogleStaticMapUpdateError(GoogleStaticMap map, int errorCode, String errorMessage)
	{
		//showError("map error: " + errorCode + ", " + errorMessage);
	}
	public void GoogleStaticMapUpdated(GoogleStaticMap map)
	{
		repaint();
	}
        	protected void keyPressed(int key)
	{
		int gameAction = getGameAction(key);
		
		if(gameAction == Canvas.UP || gameAction == Canvas.RIGHT || gameAction == Canvas.DOWN || gameAction == Canvas.LEFT)
		{
			map.move(gameAction);
		}
	}
                	

	
}