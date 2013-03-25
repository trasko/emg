package main;

import java.util.Scanner;

import mechanical.*;

import communication.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mecha test = null;
		
		Connector connector = null ;		
		Scanner scanIn = new Scanner(System.in); 
		do{String[] items= {"set up server", "connect to server", "quit", "get a Mecha", "display Mecha"};
		switch (menuInt(items)){
			case 0:{
				connector = new Connector();
				break;
			}
			case 1:{
				System.out.print("Host IP: ");
				String host = scanIn.nextLine();			
				connector = new Connector(host); 
				break;
			}
			case 2:{
				return;
			}
			case 3:{
				test = new Mecha();
				test.systems.put("Chassis", new MechSystem(test,"LoL Torso Mk .5", 10, 50, 100, 300));
				test.systems.put("Movement", new MovementSystem(test,"OmFgLeGs Mk .1", 5, 30, 100, 300,5,150,0.1));
				test.systems.put("Weapon", new WeaponSystem(test,"PewGun Mk 0",1,5,100,300,5,0.1));
				break;
			}
			case 4:{
				if (test != null){
					System.out.print(test.toString());
				}
				break;
			}
		}}while (connector == null);
		String msg="";
		connector.setAutoLog(true);
		System.out.println(connector.toString());
		while (!msg.equals("/quit")){
				msg = scanIn.nextLine();
				if (msg.equals("/sendMecha")){
					connector.send(test);					
				} else
				if (msg.equals("/receiveMecha")){
					test = (Mecha)connector.receive();	// without further checks !!				
				} else
				if (msg.equals("/displayMecha")){
					connector.send(test);					
				} else
						connector.send(msg);
		}
		connector.close();
		
		
	}
	
	public static String menuStr(String[] options){
		for (int i=0; i<options.length;i++){
			if (i<10) System.out.print(" ");
			System.out.println((1+i)+": "+options[i]);
		}
	 Scanner scanIn = new Scanner(System.in); 
	 String inp=" ";
   	   do{ 		    		   
   	       inp = scanIn.nextLine();
   	       try{
   	    	   return options[Integer.parseInt(inp)-1];
   	       }
   	       catch(Exception e){}
   	   }while(true);	    
		
	}
	public static int menuInt(String[] options){
		for (int i=0; i<options.length;i++){
			if (i<10) System.out.print(" ");
			System.out.println((1+i)+": "+options[i]);
		}
	 Scanner scanIn = new Scanner(System.in); 
	 String inp=" ";
   	   do{ 		    		   
   	       inp = scanIn.nextLine();
   	       try{
   	    	   return Integer.parseInt(inp)-1;
   	       }
   	       catch(Exception e){}
   	   }while(true);	    
		
	}

}
