import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import javax.swing.*;
import java.io.*;
public class myFirstProject extends Applet{
	static private BufferedReader br = new BufferedReader(new InputStreamReader (System.in),1);
	int a = 0;
	public void paint(Graphics g){
		try {
			register();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a == 1) {
			theMethods sl = new theMethods();
			sl.printTable(g);
			sl.playandwon(g);
		}
	}
	public void register() throws IOException {
		int b = 1;
		while(b != 0) {
			PrintWriter lineOut = new PrintWriter(new FileWriter("keeperOfRegister.txt"));
			System.out.println("if you have already register,just put exit");
			String exit = br.readLine();
			if(!exit.equals("exit")) {
				System.out.println("registering");
				System.out.println("Please put your user name");
				String username = br.readLine();
				System.out.println("Please put your password");
				String password = br.readLine();
				lineOut.println(username);
				lineOut.println(password);
			}
			lineOut.close();
			BufferedReader lineIn2 = new BufferedReader(new FileReader("keeperOfRegister.txt"));
			System.out.println("Please put your user name");
			String username1 = br.readLine();
			System.out.println("Please put your password");
			String password1 = br.readLine();
			String line = lineIn2.readLine();
			while(line != null)
			{
				if(username1.equals(line)) {
					line = lineIn2.readLine();
					if(password1.equals(line)) {
						System.out.println("Successful");
						b = 0;
						a = 1;
					}
				}
				line = lineIn2.readLine();
			}
			if(b != 0) {
				System.out.println("Sorry, you should register first");
			}
			lineIn2.close();
		}
	}

}
