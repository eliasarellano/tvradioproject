public abstract class device {
	boolean onOff;
	int volume;
	int channel;
	String name;
	int tempVolume=0;		//the temp values exist to be either undone by the undo function or be added to the volume/channel variable
	int tempChannel=0;      //they should always be equal to -1,0 or 1
	boolean testLoop;
	
	
	void setOnOff(boolean onOff){
		this.onOff = onOff;          //true if on, false if off
	}
	boolean getOnOff() {
		return this.onOff;
	}
	void setVolume(int volume) {
		this.notUndo();
		this.tempVolume=volume-this.volume;
		this.testLoop();
	}
	int getVolume() {
		return this.volume;
	}
	int getTotalVolume() {
		return this.volume + this.tempVolume;
	}
	void setChannel(int channel) {
		this.notUndo();
		this.tempChannel=channel-this.channel;
		this.testLoop();
	}
	int getChannel() {
		return this.channel;
	}
	int getTotalChannel() {
		return this.channel+this.tempChannel;
	}
	String getName() {
		return this.name;
	}
	abstract void initName();
	
	public final void initDevice(){
		initName();
		setOnOff(false);
		setVolume(5);
		setChannel(5);
	}
	
	public final void testLoop() {               //the channel range has been set to [1,10] and loop. Going up from 10 go back to 1 and reciprocally
		if(this.channel+this.tempChannel<1) {
			this.channel = 10;
			this.tempChannel = 0;
			this.testLoop = true;                //testLoop's purpose is to insure the good functioning of the undo function in case of a channel loop
		}
		else if(this.channel+this.tempChannel>10) {
			this.channel = 1;
			this.tempChannel = 0;
			this.testLoop = true;
		}
		else
			this.testLoop = false;
		if(this.volume+this.tempVolume>10 || this.volume+this.tempVolume<0) //the volume range is [0,10] but does not loop.
			this.tempVolume=0;
	}
	
	public final void notUndo() {              //notUndo add the tempValues to the values and insure the good variable are negated by undo
		this.channel+=this.tempChannel;
		this.volume+=this.tempVolume;
		this.tempChannel=0;
		this.tempVolume=0;
	}
	
	public final void undo() {                        //Undo set to 0 every tempValue, because each time channel or volume is changed, the notUndo is
		if(this.tempChannel+this.tempVolume==0)       //called, there is only one non null tempValue which is nullified   
		
		if(this.testLoop)
			this.channel=((this.channel-1)/9-1)*-9+1; //Transform channel 10 into channel 1 and reciprocally (you can calculate to verify if you want)
		this.tempChannel=0;
		this.tempVolume=0;
	}

	
}