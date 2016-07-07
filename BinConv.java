import java.io.*;
import java.util.Random;

class BinConv
{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
 	public static void main(String[] argv)
 		throws IOException
 	{
		System.out.println("Welcome to the Binary conversion trainer.");
		System.out.println("This program is designed for pracitce with Binary, Hexadecimal and Decimal conversions.");
	
		//set up the reader object
		
		Random rand = new Random();
		//infinite loop
		while(true)
		{
			//get a random value between 0 and 255
			int value = rand.nextInt(256);
			//decide which conversion to do (d-b, d-h, b-d, b-h, h-d, h-b)
			//values 0 through 5
			int conversion = rand.nextInt(6);
			
			switch (conversion){
				case 0: d2b(value); break;
				case 1: d2h(value); break;
				case 2: b2d(value); break;
				case 3: h2d(value); break;
				case 4: b2h(value); break;
				case 5: h2b(value); break;
			}
		}
	}
	
	//read a binary number from the command line, convert to decimal
	static int readbin()
		throws IOException
	{
		while(true)
		{
			try
			{
				byte[] input = reader.readLine().getBytes();
				
				//if there is a bad input, throw an error
				if(input.length != 8) throw new IOException();
				int total = 0;
				//Starting with MSB = 128
				if(input[0] == '1') total += 128;
					else if(input[0] != '0') throw new IOException();
				if(input[1] == '1') total += 64;
					else if(input[1] != '0') throw new IOException();
				if(input[2] == '1') total += 32;
					else if(input[2] != '0') throw new IOException();
				if(input[3] == '1') total += 16;
					else if(input[3] != '0') throw new IOException();
				if(input[4] == '1') total += 8;
					else if(input[4] != '0') throw new IOException();
				if(input[5] == '1') total += 4;
					else if(input[5] != '0') throw new IOException();
				if(input[6] == '1') total += 2;
					else if(input[6] != '0') throw new IOException();
				if(input[7] == '1') total += 1;
					else if(input[7] != '0') throw new IOException();
		
				return total;
			}
			catch(IOException e)
			{
				System.out.println("Bad Input");
			}
		}
	}
	
	//read a decimal value from the command line
	static int readdec()
		throws IOException
	{
		while(true)
		{
			try
			{
				int input = Integer.parseInt(reader.readLine());
			
				if(input > 255) throw new IOException();
				
				return input;
			}
			catch(IOException e)
			{
				System.out.println("Bad Input");
			}
			catch(NumberFormatException e)
			{
				System.out.println("Bad Input");
			}
		}
	}
	
		
	//reads a hexadecimal value from the command line
	static int readhex()
		throws IOException
	{
		while(true)
		{
			try
			{
				byte[] input = reader.readLine().getBytes();
				int total = 0;
			
				if(input.length != 2) throw new IOException();
			
				//Starting with MSB = 16*x
				//then LSB = x
			
				total += Hex(input[0]) * 16;
				total += Hex(input[1]);
				
				return total;
			}
			catch(IOException e)
			{
				System.out.println("Bad Input");
			}
		}
	}
	
	static String writehex(int value)
	{
		String output = "";

		output += hexval((value - value % 16)/16);
		output += hexval(value % 16);

		return output;
	}
	
	static String hexval(int value)
	{
		switch (value){
			case 0: return "0";
			case 1: return "1";
			case 2: return "2";
			case 3: return "3";
			case 4: return "4";
			case 5: return "5";
			case 6: return "6";
			case 7: return "7";
			case 8: return "8";
			case 9: return "9";
			case 10: return "A";
			case 11: return "B";
			case 12: return "C";
			case 13: return "D";
			case 14: return "E";
			case 15: return "F";
		}
		
		return "0";
	}
	
	//taken an int and returns the binary representation in string
	static String writebin(int value)
	{
		String output = "";
		
		if(value >= 128)
		{
			output += "1";
			value -= 128;
		}else output +="0";
		if(value >= 64)
		{
			output += "1";
			value -= 64;
		}else output +="0";
		if(value >= 32)
		{
			output += "1";
			value -= 32;
		}else output +="0";
		if(value >= 16)
		{
			output += "1";
			value -= 16;
		}else output +="0";
		if(value >= 8)
		{
			output += "1";
			value -= 8;
		}else output +="0";
		if(value >= 4)
		{
			output += "1";
			value -= 4;
		}else output +="0";
		if(value >= 2)
		{
			output += "1";
			value -= 2;
		}else output +="0";
		if(value >= 1)
		{
			output += "1";
			value -= 1;
		}else output +="0";
		
		return output;
	}

	
	static int Hex(byte Letter)
		throws IOException
	{
		int value = 0;
		
		switch(Letter){
			case '0': return 0;
			case '1': return 1;
			case '2': return 2;
			case '3': return 3;
			case '4': return 4;
			case '5': return 5;
			case '6': return 6;
			case '7': return 7;
			case '8': return 8;
			case '9': return 9;
			case 'A': return 10;
			case 'B': return 11;
			case 'C': return 12;
			case 'D': return 13;
			case 'E': return 14;
			case 'F': return 15;
			case 'a': return 10;
			case 'b': return 11;
			case 'c': return 12;
			case 'd': return 13;
			case 'e': return 14;
			case 'f': return 15;
		}
	
		throw new IOException();
	}
  
	//get the user to convert a decimal to binary
 	static void d2b(int value)
 		throws IOException
	{
	  	System.out.println("Convert " + value + " from Decimal to Binary");
	  	int input = readbin();
	  	
	  	if(input == value)
	  	{
	  		System.out.println("Correct");
	  	}
	  	else
	  	{
	  		System.out.println("Incorrect, answer was " + writebin(value));
	  	}
	}
	
		//get the user to convert a decimal to binary
 	static void d2h(int value)
 		throws IOException
	{
	  	System.out.println("Convert " + value + " from Decimal to Hexadecimal");
	  	int input = readhex();
	  	
	  	if(input == value)
	  	{
	  		System.out.println("Correct");
	  	}
	  	else
	  	{
	  		System.out.println("Incorrect, answer was " + writehex(value));
	  	}
	}
	
		//get the user to convert a binary to decimal
 	static void b2d(int value)
 		throws IOException
	{
	  	System.out.println("Convert " + writebin(value) + " from Binary to Decimal");
	  	int input = readdec();
	  	
	  	if(input == value)
	  	{
	  		System.out.println("Correct");
	  	}
	  	else
	  	{
	  		System.out.println("Incorrect, answer was " + value);
	  	}
	}
	
	static void h2d(int value)
 		throws IOException
	{
	  	System.out.println("Convert " + writehex(value) + " from Hexadecimal to Decimal");
	  	int input = readdec();
	  	
	  	if(input == value)
	  	{
	  		System.out.println("Correct");
	  	}
	  	else
	  	{
	  		System.out.println("Incorrect, answer was " + value);
	  	}
	}
	
	static void h2b(int value)
 		throws IOException
	{
	  	System.out.println("Convert " + writehex(value) + " from Hexadecimal to Binary");
	  	int input = readbin();
	  	
	  	if(input == value)
	  	{
	  		System.out.println("Correct");
	  	}
	  	else
	  	{
	  		System.out.println("Incorrect, answer was " + writebin(value));
	  	}
	}
	
	static void b2h(int value)
 		throws IOException
	{
	  	System.out.println("Convert " + writebin(value) + " from Binary to Hexadecimal");
	  	int input = readhex();
	  	
	  	if(input == value)
	  	{
	  		System.out.println("Correct");
	  	}
	  	else
	  	{
	  		System.out.println("Incorrect, answer was " + writehex(value));
	  	}
	}
}
