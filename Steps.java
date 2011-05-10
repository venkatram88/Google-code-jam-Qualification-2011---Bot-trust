import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Steps {

	/**
	 * @param args
	 */
	
	
	
	
	
	
	public int calculate(int totalCodes, String[] code){
		
		Bot orange = new Bot();
		Bot blue = new Bot();
		int steps=0;
		
		Bot.totalCodes = totalCodes;
		Bot.code=code;
		
		orange.setName("O");
		blue.setName("B");
		
		int nextForOrange;
		int nextForBlue;
		
		
		
		
			while(Bot.codesPressed<Bot.totalCodes){
				
				nextForOrange =this.findNextfor(orange);
				nextForBlue= this.findNextfor(blue);
				
				if(nextForOrange>nextForBlue){
					orange.canPress = false;
					blue.canPress = true;
				}
				else{
					orange.canPress = true;
					blue.canPress = false;
				}
				
				if(nextForOrange<0){
					orange.canPress = false;
					blue.canPress = true;
					//orange.canMove=false;
				}
				if(nextForBlue<0){
					blue.canPress = false;
					orange.canPress = true;
					//blue.canMove=false;				
				}	
					
			orange.move(blue);
			blue.move(orange);
			
			steps++;
			//System.out.println(" ");
			}
			
		//	System.out.println("Total steps:"+steps);
			
			return steps;
		
		
		
		
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = null;
		try {
			File f = new File("A-small.in");
			
			bf = new BufferedReader(new FileReader("A-large.in"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			int numberOfCases = Integer.parseInt(bf.readLine());
			String[] output = new String[numberOfCases];
			for(int testCase=0;testCase<numberOfCases;testCase++){
				
					String codePattern = bf.readLine();
					//System.out.println(codePattern);
					String[] splittedCodePattern = codePattern.split(" ");
					int length = Integer.parseInt(splittedCodePattern[0]);
					
					String[] code = new String[length];
					int j=1;
					for (int i = 0; i < code.length; i++) {
						code[i]=splittedCodePattern[j]+splittedCodePattern[j+1];
						j=j+2;
					}
					
					
					
				int steps=(new Steps()).calculate(length,code);
				
				Bot.code=null;
				Bot.codesPressed=0;
				Bot.totalCodes=0;
				
				output[testCase]="Case #"+(testCase+1)+": "+steps;
				
				
			}
			bf.close();
			File fw = new File("A-large-output.in");
			BufferedWriter bfw = new BufferedWriter(new FileWriter(fw));
			
			for (int i = 0; i < output.length; i++) {
				
				if(i!=output.length-1)
					bfw.write(output[i]+"\n");
				else
					bfw.write(output[i]);
			}
			bfw.close();
	}
	
int findNextfor(Bot bot){
		
		for (int i = Bot.codesPressed; i < Bot.totalCodes; i++) {
			if(Bot.code[i].startsWith(bot.getName())){
					bot.setNextToPress(Integer.parseInt(Bot.code[i].substring(1)));
					return i;
			}
			else
				continue;
		}
		
		bot.setNextToPress(-1);
		return -1;
		
	}

}
