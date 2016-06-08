/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

/**
 *
 * @author timoumi med hedi
 */
public class PostQuery {
     public String postMethod(String url,String name,String pass) throws IOException {

    HttpConnection httpConn = null;
     
    InputStream is = null;
    OutputStream os = null;

    try {
      // Open an HTTP Connection object
      httpConn = (HttpConnection)Connector.open(url);
      // Setup HTTP Request to POST
      httpConn.setRequestMethod(HttpConnection.POST);

      httpConn.setRequestProperty("User-Agent",
        "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
      httpConn.setRequestProperty("Accept_Language","en-US");
      //Content-Type is must to pass parameters in POST Request
      httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

      // This function retrieves the information of this connection
      //getConnectionInformation(httpConn);


      os = httpConn.openOutputStream();

      String params;
      params = "name=" + name+"&pass="+pass;

      os.write(params.getBytes());

      /**Caution: os.flush() is controversial. It may create unexpected behavior
            on certain mobile devices. Try it out for your mobile device **/

      //os.flush();

      // Read Response from the Server

      StringBuffer sb = new StringBuffer();
      is = httpConn.openDataInputStream();
      int chr;
      while ((chr = is.read()) != -1)
        sb.append((char) chr);

      // Web Server just returns the birthday in mm/dd/yy format.
     
 return sb.toString();
      } finally {
        if(is!= null)
           is.close();
          if(os != null)
            os.close();
      if(httpConn != null)
            httpConn.close();
    }

    }

public String postMethodAdd(String url,String name,String pass,String mail,String tel) throws IOException {

    HttpConnection httpConn = null;
     
    InputStream is = null;
    OutputStream os = null;

    try {
      // Open an HTTP Connection object
      httpConn = (HttpConnection)Connector.open(url);
      // Setup HTTP Request to POST
      httpConn.setRequestMethod(HttpConnection.POST);

      httpConn.setRequestProperty("User-Agent",
        "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
      httpConn.setRequestProperty("Accept_Language","en-US");
      //Content-Type is must to pass parameters in POST Request
      httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

      // This function retrieves the information of this connection
      //getConnectionInformation(httpConn);


      os = httpConn.openOutputStream();

      String params;
      params = "name=" + name+"&pass="+pass+"&mail="+mail+"&tel="+tel;

      os.write(params.getBytes());

      /**Caution: os.flush() is controversial. It may create unexpected behavior
            on certain mobile devices. Try it out for your mobile device **/

      //os.flush();

      // Read Response from the Server

      StringBuffer sb = new StringBuffer();
      is = httpConn.openDataInputStream();
      int chr;
      while ((chr = is.read()) != -1)
        sb.append((char) chr);

      // Web Server just returns the birthday in mm/dd/yy format.
     
 return sb.toString();
      } finally {
        if(is!= null)
           is.close();
          if(os != null)
            os.close();
      if(httpConn != null)
            httpConn.close();
    }

    }
    
public String postMethodAdd(String url,String name,String pass,String mail,String tel,int id) throws IOException {

    HttpConnection httpConn = null;
     
    InputStream is = null;
    OutputStream os = null;

    try {
      // Open an HTTP Connection object
      httpConn = (HttpConnection)Connector.open(url);
      // Setup HTTP Request to POST
      httpConn.setRequestMethod(HttpConnection.POST);

      httpConn.setRequestProperty("User-Agent",
        "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
      httpConn.setRequestProperty("Accept_Language","en-US");
      //Content-Type is must to pass parameters in POST Request
      httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

      // This function retrieves the information of this connection
      //getConnectionInformation(httpConn);


      os = httpConn.openOutputStream();

      String params;
      params = "name=" + name+"&pass="+pass+"&mail="+mail+"&tel="+tel+"&id="+id;

      os.write(params.getBytes());

      /**Caution: os.flush() is controversial. It may create unexpected behavior
            on certain mobile devices. Try it out for your mobile device **/

      //os.flush();

      // Read Response from the Server

      StringBuffer sb = new StringBuffer();
      is = httpConn.openDataInputStream();
      int chr;
      while ((chr = is.read()) != -1)
        sb.append((char) chr);

      // Web Server just returns the birthday in mm/dd/yy format.
     
 return sb.toString();
      } finally {
        if(is!= null)
           is.close();
          if(os != null)
            os.close();
      if(httpConn != null)
            httpConn.close();
    }

    }
    

}
    

