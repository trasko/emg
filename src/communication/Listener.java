package communication;
 
import java.io.*;
import java.net.*;


public class Listener implements Runnable {
private Object msg = new String("Connection established.");
public Object getMsg() {
	Object tmp = msg;
	msg = null;
	return tmp;
}
private Socket skt; 
private boolean closing = false;
private boolean autoLog = false;

	public boolean isAutoLog() {
	return autoLog;
}


public void setAutoLog(boolean autoLog) {
	this.autoLog = autoLog;
}


	public Listener(Socket skt){
		this.skt=skt;
	}


		public synchronized void run() {
		      try {
		    	    System.out.println("connecting inputstream ...");
		    	    ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
			         System.out.println("entering loop ...");
			         
			         while (!msg.equals("/quit")&&!closing){
			        	 Thread.sleep(300); //poll every 300 ms
			        	 if (msg==null){		//if there is a message waiting to be pulled from the listener, do not overwrite;
			        		 msg=in.readObject(); //if there is something to be rad msg will now be !null
			        		 				//else Listener will try again in 300 ms
			        		 if ((msg != null)&&(msg.getClass() == String.class ))
			        				 System.out.println(msg); //if its a string, log it
			        	 }
			         }
			         
			         
			         System.out.println("shutting down ...");
			         in.close();
			         skt.close();
			         System.out.println("done ...");

			      }
			      catch(Exception e) {
			         System.out.print("Whoops! It didn't work!\n Why? Because: "+e.getMessage()+"\n");
			      }
			
		}


		public void close() {
			closing = true; //should shut everything down
			
		}
		}

	