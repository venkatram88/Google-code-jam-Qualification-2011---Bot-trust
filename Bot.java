
public class Bot {
	
	public static int codesPressed=0;
	public static int totalCodes;
	public static String code[];
	
	private int currentPosn= 1;
	private int lastPressed;
	private int nextToPress;
	private String name;
	private int stay;
	private int from;
	private int stepsReq;
	
	public boolean canPress;
	public boolean canMove;
	
	public void move(Bot otherBot){
		
		if(currentPosn==nextToPress || nextToPress==-1){
			if(canPress==false){
			
				//System.out.println(name+" is waiting at "+currentPosn);
			}
			else if(canPress==true){
				lastPressed=nextToPress;
				codesPressed++;
			//	System.out.println(name+"** pressed ** "+nextToPress);
				
			}
			
		}
		
		else if(currentPosn>nextToPress){
			currentPosn--;
		//	System.out.println(name + " moved to " + currentPosn);
		}
		
		else if(currentPosn<nextToPress){
			currentPosn++;
			//System.out.println(name + " moved to " + currentPosn);
		}
	}
	
	
	
	
	
	public int getCurrentPosn() {
		return currentPosn;
	}
	public void setCurrentPosn(int currentPosn) {
		this.currentPosn = currentPosn;
	}
	public int getLastPressed() {
		return lastPressed;
	}
	public void setLastPressed(int lastPressed) {
		this.lastPressed = lastPressed;
	}
	public int getNextToPress() {
		return nextToPress;
	}
	public void setNextToPress(int nextToPress) {
		this.nextToPress = nextToPress;
	}
	public int getStay() {
		return stay;
	}
	public void setStay(int stay) {
		this.stay = stay;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}

	public void setStepsReq(int stepsReq) {
		this.stepsReq = stepsReq;
	}

	public int getStepsReq() {
		return stepsReq;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	
}
