package Enums;


public enum eTypeOfTreatment {


	Clean (0),
	TeethWhitening(1),
	denture(2),
	ToothRestoration(3),
	Composite(4),
	Amalgam(5),
	SRP(6),
	Crown (7),
	RCT(8),
	Sealing(9),
	SIZE(10) ; //(not a treatment)size of types
	

	private int index;
	
	public int getIndex()
	{
		return this.index;
	}
	
	private eTypeOfTreatment(int index)
	{
		this.index = index;
	}
	
}
