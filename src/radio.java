public class radio extends device{
	void initName() {
		this.name="radio";
	}
}

//The device subclasses are rather empty and their existence could be questioned given that the name attribute has ended not even being used. However, if in the
//the future there were plans to improve this application by adding for instance, different channels name, channel range and volume range to the 
//radio and the TV, it would be far easier in those classes.