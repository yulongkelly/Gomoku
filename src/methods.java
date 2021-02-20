
import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import javax.swing.*;
import java.util.*;
class theMethods {
	String name1,name2;
	int player1win = 0;//if player1's numbers and characters are the same,player1win change to 1 
	int player2win = 0;
	int k1 = 0,k2 = 0;
	public void printTable(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(30, 30, 280, 280);
		int a = 30;
	  	for(int ctr = 0;ctr<15;ctr++)
	  	{
	    	g.setColor(Color.black);
	    	g.drawLine(30,a,310,a);
	    	a = a+20;
	  	}
	  	a = 30;
	  	for(int ctr = 0;ctr<15;ctr++) {
	    	g.setColor(Color.black);
	       	g.drawLine(a,30,a,310);
	       	a = a+20;
	  	}
	  	g.setColor(Color.black);
	  	String b = "1";
	  	a = 30;
	  	for(int ctr = 0;ctr<15;ctr++)
	  	{
	    	g.drawString(b,a,25);
	    	a += 20;
	    	int b1 = Integer.parseInt(b);
	    	b1++;
	    	b = Integer.toString(b1);	
	  	}
	  	g.drawString("A",20,35);
	  	g.drawString("B",20,55);
	  	g.drawString("C",20,75);
	  	g.drawString("D",20,95);
	  	g.drawString("E",20,115);
	  	g.drawString("F",20,135);
	  	g.drawString("G",20,155);
	  	g.drawString("H",20,175);
	  	g.drawString("I",20,195);
	  	g.drawString("J",20,215);
	  	g.drawString("K",20,235);
	  	g.drawString("L",20,255);
	  	g.drawString("M",20,275);
	  	g.drawString("N",20,295);
	  	g.drawString("O",20,315);
	  	name1 = JOptionPane.showInputDialog("Please put player 1's name");
	  	name2 = JOptionPane.showInputDialog("Please put player 2's name");
	 }
	 public void playandwon(Graphics g){
		 //建几个array为了判断输赢
		 int array1[] = new int[700];
		 int array2[] = new int[700];
		 char array3[] = new char[700];
		 char array4[] = new char[700];
	     int judge = 0,a = 30,b = 30;
	     String player1 = "0",player2 = "0";//plary1 and player2 both should not be 700,then while can run.It means any of them be 700,while ended.
	     while(!player1.equals("700") && !player2.equals("700")) {
			 if(judge == 0){
			 	 b = 30;
			 	 a = 30;
			 	 int x2 = 0,y2 = 0;
				 player1 = JOptionPane.showInputDialog("It's " + name1 + " 's turn,Plese write letters first(A~O,1~15),put 700 to exit");
				 setThePoint(player1,array1,array3,k1);
				 int num1 = array1[k1];
				 char letter1 = array3[k1]; 
				 for(int ctr = 0;ctr < k2;ctr++) {
					 if(array1[k1] == array2[ctr] && array3[k1] == array4[ctr]) {
			 			player1 = JOptionPane.showInputDialog("It's already used,please put again");
			 			setThePoint(player1,array1,array3,k1);
			 			if(num1 == array1[k1] && letter1 == array3[k1]) {
			 				player1 = JOptionPane.showInputDialog("Don't be stupid, you just write the same thing.Put again");
				 			setThePoint(player1,array1,array3,k1);
			 			}
					 }
					 else if(array1[k1] == array1[ctr] && array3[k1] == array3[ctr]) {
				 			player1 = JOptionPane.showInputDialog("It's already used,please put again");
				 			setThePoint(player1,array1,array3,k1);
				 			if(num1 == array1[k1] && letter1 == array3[k1]) {
				 				player1 = JOptionPane.showInputDialog("Don't be stupid, you just write the same thing.Put again");
					 			setThePoint(player1,array1,array3,k1);
				 			}
				 	}
			 	 }
			 	 //放棋子
			 	 for(char alphabet = 'a'; alphabet <= 'o'; alphabet++)
			 	 {
			 		 if(array3[k1] == alphabet){
				 		 y2 = b;
				    	 for(int ctr = 1;ctr<=15;ctr++){
					    	 if(array1[k1] == ctr){
					    		 x2 = a;
					    	 }
					    	 else{
					    		 a += 20;
					    	 }
				    	 }
			 		 }	
				 	 else{
				 		  b += 20; 
				 	 } 
			 	 }
			 	g.setColor(Color.white);
			 	g.fillOval( x2-5, y2-5, 10, 10 );
			 	judge = 1;
			 	k1++;
			 }
	    	else if(judge == 1){
			 	b = 30;
			 	a = 30;
			 	int m2 = 0, n2 = 0;
	    		player2 = JOptionPane.showInputDialog("It's " + name2 +" 's turn,Plese write letters first(A~O,1~15),put 700 to exit");
	    		setThePoint(player2,array2,array4,k2);
	    		int num2 = array2[k2];
	    		char letter2 = array4[k2];
	    		for(int ctr = 0; ctr < k1;ctr++) {
			 		 if(array2[k2] == array1[ctr] && array4[k2] == array3[ctr]) {
			 			player2 = JOptionPane.showInputDialog("It's already used,please put again");
			 			setThePoint(player2,array2,array4,k2);
			 			if(num2 == array2[k2] && letter2 == array4[k2]) {
			 				player2 = JOptionPane.showInputDialog("Don't be stupid, you just put the same thing.Put again");
				 			setThePoint(player2,array2,array4,k2);
			 			}
			 		 }
			 		else if(array2[k2] == array2[ctr] && array4[k2] == array4[ctr]) {
			 			if(k2 != ctr) {	
			 			player2 = JOptionPane.showInputDialog("It's already used,please put again");
				 			setThePoint(player2,array2,array4,k2);
				 			if(num2 == array2[k2] && letter2 == array4[k2]) {
				 				player2 = JOptionPane.showInputDialog("Don't be stupid, you just put the same thing.Put again");
					 			setThePoint(player2,array2,array4,k2);
				 			}
			 			}
			 		 }
			 	}
			 	for(char alphabet = 'a'; alphabet <= 'o'; alphabet++){
			 		 if(array4[k2] == alphabet){
			 			 n2 = b;
			 			 for(int ctr1 = 1;ctr1<=15;ctr1++){
				 				if(array2[k2] == ctr1){
				 					m2 = a;
				 				}
			 					else{
			 						a += 20;
			 					}
			 			 }
			 		 }	
			 		 else{
			 			 b += 20; 
			 		 } 
			 	}
			 	g.setColor(Color.black);
			 	g.fillOval( m2-5, n2-5, 10, 10 );
			 	judge = 0;
			 	k2++;
	    }
			 //judge
			 //if there are five same numbers,someone wins
			 int win1 = 0;
			 for(int c = 0;c < k1;c++) {
				 win1 = 0;//won 0 time
				 for(int d = 0;d < k1;d++) {
					 if(array1[d] == array1[c]) {
						 win1++;//if win1 = 5 表示有五个棋子连成一排
					 }
				 }
				 if(win1 == 5) {
					 JOptionPane.showMessageDialog(null, name1 + " is win.");
					 //for test
					 PrintArray(array1,array3,k1);
				 	 PrintArray(array2,array4,k2);
					 player1 = "700";
					 break;
				 }
			 }
			 int win2 = 0;
			 for(int c = 0;c < k2;c++) {
				 win2 = 0;//won 0 time
				 for(int d = 0;d < k2;d++) {
					 if(array2[d] == array2[c]) {
						 win2++;//if win2 = 5 表示有五个棋子连成一排
					 }
				 }
				 if(win2 == 5) {
					 JOptionPane.showMessageDialog(null, name2+ " is win.");
					//test
					 PrintArray(array1,array3,k1);
				 	 PrintArray(array2,array4,k2);
					 player1 = "700";
					 break;
				 }
			 }			 
			 //if there are five same characters,someone wins.
			 int win3 = 0;
			 for(int c = 0;c < k1;c++) {
				 win3 = 0;
				 for(int d = 0;d < k1;d++) {
					 if(array3[d] == array3[c]) {
						 win3++;//if win3 = 5 表示有五个棋子连成一排
					 }
				 }
				 if(win3 == 5) {
					 JOptionPane.showMessageDialog(null, name1 + " is win.");
					//test
					 PrintArray(array1,array3,k1);
				 	 PrintArray(array2,array4,k2);
					 player1 = "700";
					 break;
				 }
			 }
			 int win4 = 0;
			 for(int c = 0;c < k2;c++) {
				 win4 = 0;//won 0 time
				 for(int d = 0;d < k2;d++) {
					 if(array4[d] == array4[c]) {
						 win4++;//if win4 = 5 表示有五个棋子连成一排
					 }
				 }
				 if(win4 == 5) {
					 JOptionPane.showMessageDialog(null, name2+ " is win.");
					 //test
					 PrintArray(array1,array3,k1);
				 	 PrintArray(array2,array4,k2);
					 player1 = "700";
					 break;
				 }
			 }	
			 	//judging the number and characters of player1 is continuous or not
			 	for(int ctr1 = 0; ctr1 < k1;ctr1++) {
					 for(int ctr2 = 0;ctr2 < k1;ctr2++) {
						 if(array1[ctr1] == array1[ctr2] + 1 && array3[ctr1] == array3[ctr2] + 1) {
							 for(int ctr3 = 0;ctr3 < k1;ctr3++) {
								 if(array1[ctr2] == array1[ctr3] + 1 && array3[ctr2] == array3[ctr3] + 1) {
									 for(int ctr4 = 0;ctr4 < k1;ctr4++) {
										 if(array1[ctr3] == array1[ctr4] + 1 && array3[ctr3] == array3[ctr4] + 1) {
											 for(int ctr5 = 0;ctr5 < k1;ctr5++) {
												 if(array1[ctr4] == array1[ctr5] + 1 && array3[ctr4] == array3[ctr5] + 1) {
													 player1win = 1;
											 }
										 } 
									 }
								 }
							 }
						 }
					}
						 else if(array1[ctr1] == array1[ctr2] - 1 && array3[ctr1] == array3[ctr2] - 1) {
							 for(int ctr3 = 0;ctr3 < k1;ctr3++) {
								 if(array1[ctr2] == array1[ctr3] - 1 && array3[ctr2] == array3[ctr3] - 1) {
									 for(int ctr4 = 0;ctr4 < k1;ctr4++) {
										 if(array1[ctr3] == array1[ctr4] - 1 && array3[ctr3] == array3[ctr4] - 1) {
											 for(int ctr5 = 0;ctr5 < k1;ctr5++) {
												 if(array1[ctr4] == array1[ctr5] - 1 && array3[ctr4] == array3[ctr5] - 1) {
													 player1win = 1;
												 }
											 }
										 } 
									 }
								 }
							 }
						 }
						 else if(array1[ctr1] == array1[ctr2] + 1 && array3[ctr1] == array3[ctr2] - 1) {
							 for(int ctr3 = 0;ctr3 < k1;ctr3++) {
								 if(array1[ctr2] == array1[ctr3] + 1 && array3[ctr2] == array3[ctr3] - 1) {
									 for(int ctr4 = 0;ctr4 < k1;ctr4++) {
										 if(array1[ctr3] == array1[ctr4] + 1 && array3[ctr3] == array3[ctr4] - 1) {
											 for(int ctr5 = 0;ctr5 < k1;ctr5++) {
												 if(array1[ctr4] == array1[ctr5] + 1 && array3[ctr4] == array3[ctr5] - 1) {
													 player1win = 1;
												 }
											 }
										 } 
									 }
								 }
							 }
						 }
						 else if(array1[ctr1] == array1[ctr2] - 1 && array3[ctr1] == array3[ctr2] + 1) {
							 for(int ctr3 = 0;ctr3 < k1;ctr3++) {
								 if(array1[ctr2] == array1[ctr3] - 1 && array3[ctr2] == array3[ctr3] + 1) {
									 for(int ctr4 = 0;ctr4 < k1;ctr4++) {
										 if(array1[ctr3] == array1[ctr4] - 1 && array3[ctr3] == array3[ctr4] + 1) {
											 for(int ctr5 = 0;ctr5 < k1;ctr5++) {
												 if(array1[ctr4] == array1[ctr5] - 1 && array3[ctr4] == array3[ctr5] + 1) {
													 player1win = 1;
												 }
											 }
										 } 
									 }
								 }
							 }
						 }
					 }
				 }
				//judging the number and characters of player2 is continuous or not
				 for(int ctr1 = 0; ctr1 < k2;ctr1++) {
					 for(int ctr2 = 0;ctr2 < k2;ctr2++) {
						 if(array2[ctr1] == array2[ctr2] + 1 && array4[ctr1] == array4[ctr2] + 1) {
							 for(int ctr3 = 0;ctr3 < k2;ctr3++) {
								 if(array2[ctr2] == array2[ctr3] + 1 && array4[ctr2] == array4[ctr3] + 1) {
									 for(int ctr4 = 0;ctr4 < k2;ctr4++) {
										 if(array2[ctr3] == array2[ctr4] + 1 && array4[ctr3] == array4[ctr4] + 1) {
											 for(int ctr5 = 0;ctr5 < k2;ctr5++) {
												 if(array2[ctr4] == array2[ctr5] + 1 && array4[ctr4] == array4[ctr5] + 1) {
													 player2win = 1;
												 }
											 }
										 } 
									 }
								 }
							 }
						 }
						 else if(array2[ctr1] == array2[ctr2] - 1 && array4[ctr1] == array4[ctr2] - 1) {
							 for(int ctr3 = 0;ctr3 < k2;ctr3++) {
								 if(array2[ctr2] == array2[ctr3] - 1 && array4[ctr2] == array4[ctr3] - 1) {
									 for(int ctr4 = 0;ctr4 < k2;ctr4++) {
										 if(array2[ctr3] == array2[ctr4] - 1 && array4[ctr3] == array4[ctr4] - 1) {
											 for(int ctr5 = 0;ctr5 < k2;ctr5++) {
												 if(array2[ctr4] == array2[ctr5] - 1 && array4[ctr4] == array4[ctr5] - 1) {
													 player2win = 1;
												 }
											 }
										 } 
									 }
								 }
							 }
						 }
						 else if(array2[ctr1] == array2[ctr2] + 1 && array4[ctr1] == array4[ctr2] - 1) {
							 for(int ctr3 = 0;ctr3 < k2;ctr3++) {
								 if(array2[ctr2] == array2[ctr3] + 1 && array4[ctr2] == array4[ctr3] - 1) {
									 for(int ctr4 = 0;ctr4 < k2;ctr4++) {
										 if(array2[ctr3] == array2[ctr4] + 1 && array4[ctr3] == array4[ctr4] - 1) {
											 for(int ctr5 = 0;ctr5 < k2;ctr5++) {
												 if(array2[ctr4] == array2[ctr5] + 1 && array4[ctr4] == array4[ctr5] - 1) {
													 player2win = 1;
												 }
											 }
										 } 
									 }
								 }
							 }
						 }
						 else if(array2[ctr1] == array2[ctr2] - 1 && array4[ctr1] == array4[ctr2] + 1) {
							 for(int ctr3 = 0;ctr3 < k2;ctr3++) {
								 if(array2[ctr2] == array2[ctr3] - 1 && array4[ctr2] == array4[ctr3] + 1) {
									 for(int ctr4 = 0;ctr4 < k2;ctr4++) {
										 if(array2[ctr3] == array2[ctr4] - 1 && array4[ctr3] == array4[ctr4] + 1) {
											 for(int ctr5 = 0;ctr5 < k2;ctr5++) {
												 if(array2[ctr4] == array2[ctr5] - 1 && array4[ctr4] == array4[ctr5] + 1) {
													 player2win = 1;
												 }
											 }
										 } 
									 }
								 }
							 }
						 }
					 }
				 }
				 if(player1win == 1) {
					 JOptionPane.showMessageDialog(null, name1 + " is win.");
				 	 player1 = "700";
				 	 //for test
				 	 PrintArray(array1,array3,k1);
				 	 PrintArray(array2,array4,k2);
				 }
				 else if(player2win == 1) {
					 JOptionPane.showMessageDialog(null, name2 + " is win.");
				 	 player1 = "700";
				 	 //for test
				 	 PrintArray(array1,array3,k1);
				 	 PrintArray(array2,array4,k2);
				 }
	     }
	 }
	 public void setThePoint (String player,int array1[], char array2[], int k) {
		 String num;
		 char letter;
	 	 letter = player.charAt(0);
	 	 array2[k] = Character.toLowerCase(letter);
	 	 num = player.substring(1);
	 	 array1[k] = Integer.parseInt(num);
	 }
	 public void PrintArray (int array1[],char array2[],int k) {
		 System.out.println();
		 for(int ctr = 0;ctr < k;ctr++) {
			 System.out.print(array1[ctr] + "");
		 }
		 System.out.println();
		 for(int ctr = 0;ctr < k;ctr++) {
			 System.out.print(array2[ctr] + "");
		 }
	 }
}

