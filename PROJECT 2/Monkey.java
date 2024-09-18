public class Monkey extends RescueAnimal {
	//Specific monkey attributes
	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;
	
	public Monkey() {
		
	}
	

	//Constructors
	public Monkey(String name, String gender, String age, String weight, String tailLength, String acquisitionDate, String acquisitionCountry, String trainingStatus,String inServiceCountry, boolean reserved) {
		super();
		super.setName(name);
		super.setGender(gender);
		super.setAge(age);
		super.setWeight(weight);
		super.setAcquisitionDate(acquisitionDate);
		super.setAcquisitionLocation(acquisitionCountry);
		super.setTrainingStatus(trainingStatus);
		super.setReserved(reserved);
		super.setInServiceCountry(inServiceCountry);
		
	}
		
	
	//Accessors and Mutators
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String monkeySpecies) {
		species = monkeySpecies;
	}
	
	public String getTailLength() {
		return tailLength;
	}
	
	public void setTailLength(String monkeyTailLength) {
		tailLength = monkeyTailLength;
	}
	
	public String getHeight() {
		return height;
	}
	
	public void setHeight(String monkeyHeight) {
		height = monkeyHeight;
	}
	
	public String getBodyLength() {
		return bodyLength;
	}
	
	public void setBodyLength(String monkeyBodyLength) {
		bodyLength = monkeyBodyLength;
	}
}