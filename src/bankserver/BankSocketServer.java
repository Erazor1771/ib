/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankserver;

import internetbankieren.Bankrekeningen;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 310054544
 */
public class BankSocketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          		try {
			// establish server socket
			ServerSocket s = new ServerSocket(8189);

			// wait for client connection
			Socket incoming = s.accept();
			System.out.println("Connected");
			try {
				OutputStream outStream = incoming.getOutputStream();
				InputStream inStream = incoming.getInputStream();
 
				ObjectInputStream in = new ObjectInputStream(inStream);
				ObjectOutputStream out = new ObjectOutputStream(outStream);

				out.writeObject("Hello! Enter BYE to exit.");
				out.flush();
 
				// echo client Object input
				boolean done = false;
				Object inObject = null;
				while (!done) {
					try {
						inObject = in.readObject();
						if (inObject instanceof Bankrekeningen) {
							String mb = (String) inObject;
							System.out.println("Beurs ontvangen: "
									+ mb.toString());
							
							out.writeObject(mb);
							out.flush();
						}
                                                else if (inObject instanceof String) {
							String woord = (String) inObject;
							System.out.println("String ontvangen: "+woord);
							if (woord.equals("BYE"))
								done = true;
							out.writeObject(woord);
							out.flush();
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("Object type not known");
					}
					//
				}
			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }

}
