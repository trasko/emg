package communication;
 
import java.io.*;
import java.net.*;



public class Messenger implements Runnable {

public Object msg = new String("Connection established.");
private Socket skt;
private boolean closing= false;

 		public Messenger(Socket skt){
 			this.skt=skt;
 		}
 		
 		
		public synchronized void run() {
		      try {
		    	  System.out.println("connecting outputstream ...");	         
		    	  ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
			        	System.out.println("Messenger ready! "); 
				         while (! msg.equals("/quit")&&!closing){
				        	 out.writeObject(msg);
				        	 msg=null;
				        	 out.flush();
				        	 while ((msg==null)&&!closing)
				        	 Thread.sleep(300);  //keep waiting until there is stuff in msg again
				         }	 
			        System.out.println("shutting down ...");
			         out.close();
			         skt.close();
			         System.out.println("done.");

			      }
			      catch(Exception e) {
			         System.out.print("Error in Messenger: "+e.getMessage()+"\n");
			      }
			
		}

		
		public void close() {
			closing = true;
			
		}

		}

	