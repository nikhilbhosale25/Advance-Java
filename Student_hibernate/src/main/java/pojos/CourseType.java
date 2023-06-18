package pojos;

public enum CourseType {

	DAC(100000),DBDA(150000),DITTIS(120000);
	
	private int fee;
	CourseType(int fee)
	{
		this.fee=fee;
	}
}
