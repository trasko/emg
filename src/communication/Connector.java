package communication;

import java.net.*;


public class Connector {


	private Listener listener = null;
    private Messenger messenger = null;	    
	
		public boolean isAutoLog() {
		return listener.isAutoLog();
	}
	public void setAutoLog(boolean autoLog) {
		listener.setAutoLog(autoLog);
	}
		public void send(Object message){
			while(!(messenger.msg == null))
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					return;
				}
			messenger.msg = message;
		}
		@Override
		public String toString() {
			return "Connector [listener=" + listener + ", messenger="
					+ messenger + "]";
		}
		public Object receive(){
			return listener.getMsg();
		}
		
		public void  close(){
			 listener.close();
			messenger.close();
		}
		
		public Connector (String host){
			try{
				System.out.print("Connecting...\n");
				Socket skt = new Socket(host, 1337);
				Thread.sleep(500);
		        System.out.print("This has connected!\n"); 
		        listener = new Listener(skt);
		        messenger = new Messenger(skt);	 
		        
		        Thread listenerThread = new Thread(listener);
		        Thread messengerThread = new Thread(messenger);
		        
		        System.out.println("starting threads ...");
		        listenerThread.start();
		        messengerThread.start();
		        Thread.sleep(50);
		        System.out.println("all started ...");
		        
		         //Scanner scanIn = new Scanner(System.in); debug
		    	 //  while (!messenger.msg.equals("/quit")){ 		    		   
		    	 //      messenger.msg = scanIn.nextLine();
		    	 //  }	    
		 }
	      catch(Exception e) {
	         System.out.print("Error in main: "+e.getMessage()+"\n");
	      }
	}
		
		public Connector (){
			try{
				ServerSocket srvr = new ServerSocket(1337);
			    System.out.print("Waiting for connection...\n");
			    Socket skt = srvr.accept();
		        System.out.print("This has connected!\n"); 
		        listener = new Listener(skt);
		        messenger = new Messenger(skt);	        
		        Thread listenerThread = new Thread(listener);
		        Thread messengerThread = new Thread(messenger);
		        System.out.println("starting threads ...");
		        listenerThread.start();
		        messengerThread.start();
		        Thread.sleep(50);
		        System.out.println("all started ...");
		         //Scanner scanIn = new Scanner(System.in); debug
		    	 //  while (!messenger.msg.equals("/quit")){ 		    		   
		    	 //      messenger.msg = scanIn.nextLine();
		    	 //  }	   
		 }
	      catch(Exception e) {
	         System.out.print("Error in main: "+e.getMessage()+"\n");
	      }
	}
}
	