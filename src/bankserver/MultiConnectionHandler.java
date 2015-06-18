
package bankserver;

import internetbankieren.Bankrekeningen;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lars
 */
public class MultiConnectionHandler extends Thread {
    protected Socket socket;

    public MultiConnectionHandler(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        
          // TODO code application logic here
          		try {
			// establish server socket
			//ServerSocket s = new ServerSocket(8189);
                        
			System.out.println("Connected");
			try {
				OutputStream outStream = new DataOutputStream(socket.getOutputStream());
				InputStream inStream = socket.getInputStream();
 
				ObjectInputStream instream = new ObjectInputStream(inStream);
				ObjectOutputStream outstream = new ObjectOutputStream(outStream);

				outstream.writeObject("Hello! Enter BYE to exit.");
				outstream.flush();
 
				// echo client Object input
				boolean done = false;
				Object inObject = null;
				while (!done) {
					try {
						inObject = instream.readObject();
						if (inObject instanceof Bankrekeningen) {
							String mb = (String) inObject;
							System.out.println("Bankrekeningen ontvangen: "
									+ mb.toString());
							
							outstream.writeObject(mb);
							outstream.flush();
						}
                                                else if (inObject instanceof String) {
							String woord = (String) inObject;
							System.out.println("String ontvangen: "+woord);
							if (woord.equals("BYE"))
								done = true;
							outstream.writeObject(woord);
							outstream.flush();
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("Object type not known");
					}
					//
				}
			} finally {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }
}
