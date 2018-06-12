import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
public class Generator {
	//******************Customization*****************
	public static HashSet<String> hs;
	public final static int numOfString=1000; //enter how many numbers do u want to generate
	public final static int length=6; //enter generated string's length>0
	public final static String symbols=RandomString.alphanum; //enter what you want to use for symbols to generate  also you can use RandomString.upper , RandomString.lower, RandomString.digits 
	//*****************Customization END***************
	
	public static RandomString rs=new RandomString(length,symbols);
	public static void main(String[] args) {
		hs=new HashSet<>();
		int i=0;
		if(calcMax()<numOfString) {
			System.err.println("Customize your symbols,numofString or length. Not enough symbols to generate unique strings");
			return;
		}
		while(i<numOfString) {
			String tmp=generate(); // if you want to prepend or append special string for generated string just change this line String tmp="YOURSTRING"+generate() OR String tmp=generate()+"YOURSTRING"
			if(!hs.contains(tmp)) {
				hs.add(tmp);
				i++;
			}
		}
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
			for(String s :hs) {
				bw.write(s+"\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	private static String generate() {
		return rs.nextString();
	}
	private static int calcMax() {
		int len=symbols.length();
		int result=len;
		for(int i=0;i<length-1 && len>1;i++) {
			result*=--len;
		}
		return result;
	}

}
