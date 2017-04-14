package ResultSetMapper;

import AnnotationOfLabel.Label;

public class SamplePojo {
	@Label("User_Id")
	private int id;
	@Label("User_Name")
	private String name;
	@Label("Address")
	private String address;
	@Label("Gender")
	private boolean gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return 	"id: " + id + "\n" + 
				"name: " + name + "\n"+
				"address: " + address + "\n" +
				"gender: " + (gender ? "Male" : "Female") + "\n\n";
	}
}