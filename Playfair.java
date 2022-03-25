import java.util.Arrays;
import java.util.Scanner;

public class Playfair {
	
	Playfair()
	{
		
	}
	
	public void encode(String diagram,char[][] ref) {
		int row1=0,row2=0,col1=0,col2=0;
		char[] dia = diagram.toCharArray();
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(dia[0]==ref[i][j]) {
					row1=i;
					col1=j;
				}
				if(dia[1]==ref[i][j]) {
					row2=i;
					col2=j;
				}
			}
		}
		if(row1 == row2) {
			dia[0] = ref[row1][(col1+1)%5];
			dia[1] = ref[row2][(col2+1)%5];
		}
		else if(col1 == col2) {
			dia[0] = ref[(row1+1)%5][col1];
			dia[1] = ref[(row2+1)%5][col2];
		}
		else {
			dia[0] = ref[row1][col2];
			dia[1] = ref[row2][col1];
		}
		 
		System.out.println(diagram+" is encoded as :");
		System.out.println(Arrays.toString(dia));
	}
	public void decode(String diagram,char[][] ref) {
		int row1=0,row2=0,col1=0,col2=0;
		char[] dia = diagram.toCharArray();
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(dia[0]==ref[i][j]) {
					row1=i;
					col1=j;
				}
				if(dia[1]==ref[i][j]) {
					row2=i;
					col2=j;
				}
			}
		}
		if(row1 == row2) {
			dia[0] = ref[row1][(col1-1)%5];
			dia[1] = ref[row2][(col2-1)%5];
		}
		else if(col1 == col2) {
			dia[0] = ref[(row1-1)%5][col1];
			dia[1] = ref[(row2-1)%5][col2];
		}
		else {
			dia[0] = ref[row1][col2];
			dia[1] = ref[row2][col1];
		}
		 
		System.out.println(diagram+" is decoded as :");
		System.out.println(Arrays.toString(dia));
	}
	

	public static void main(String[] args) {
		Playfair pf = new Playfair();
		Scanner sc= new Scanner(System.in);
		char matrix[][] = new char[5][5];
		System.out.println("Enter the playfair matrix");
		for(int i=0;i<5;i++) 
		  { 
			  for(int j=0;j<5;j++) 
			  {
		  
				  matrix[i][j]=sc.next().charAt(0); 
				  } 
			  } 
		  for (char[] m :matrix)
		  System.out.println(Arrays.toString(m));
		 String dia = new String();
		 char[] d1 = new char[5];
		//to create diagrams
		
		 
		  for(;;) {
			 System.out.println("Enter your choice ");
			System.out.println("1:Encoding "+"\n"+"2:Decoding");
			int ch = sc.nextInt();
		  switch(ch) 
		  {
		  case 1:System.out.println("Enter the message to be encrypted using playfair cipher");
		  		 String en_message = sc.next();
		  		 for(int k=0;k<en_message.length();k=k+2) 
		  		 { 
		  			 dia = en_message.substring(k,k+2);
		  			 StringBuffer m1 = new StringBuffer(en_message);
		  			 d1 = dia.toCharArray();
			  
		  			 if(d1[0]==d1[1])
		  			 {
		  				 m1.insert(k+1,'x');
		  				 en_message=m1.toString();
		  				 dia = en_message.substring(k, k+2);
		  			 }
		  			pf.encode(dia, matrix);
		  		 }//for loop
		  			 break;
		  case 2 :	System.out.println("Enter the message to be decrypted using playfair cipher");
		  			String de_message = sc.next();
		  			for(int k=0;k<de_message.length();k=k+2) 
		  			{ 
	  		 		dia = de_message.substring(k,k+2);
	  		 		StringBuffer m1 = new StringBuffer(de_message);
	  		 		d1 = dia.toCharArray();
		  
	  		 		if(d1[0]==d1[1])
	  		 		{
	  		 			m1.insert(k+1,'x');
	  		 			de_message=m1.toString();
	  		 			dia = de_message.substring(k, k+2);
	  		 		}
	  		 		pf.decode(dia, matrix);
	  		 	}//for loop
	  		 		break;
			
		
		}//switch
	  }//for infinite loop
	}//main
}//class
