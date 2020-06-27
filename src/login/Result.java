package login;

import java.sql.*;
import java.util.*;

public class Result {
	private int student_id;
	private int computer;
    private int software;
    private int java;
    private int operating;
    private int virtu;
    private int biometric;
    private int intership;
    
     
    public Result() {
    	
    }
    
    
    
    
    
	public Result(int student_id, int computer, int software, int java, int operating, int virtu, int biometric,
			int intership) {
		super();
		this.student_id = student_id;
		this.computer = computer;
		this.software = software;
		this.java = java;
		this.operating = operating;
		this.virtu = virtu;
		this.biometric = biometric;
		this.intership = intership;
	}





	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public int getSoftware() {
		return software;
	}
	public void setSoftware(int software) {
		this.software = software;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getOperating() {
		return operating;
	}
	public void setOperating(int operating) {
		this.operating = operating;
	}
	public int getVirtu() {
		return virtu;
	}
	public void setVirtu(int virtu) {
		this.virtu = virtu;
	}
	public int getBiometric() {
		return biometric;
	}
	public void setBiometric(int biometric) {
		this.biometric = biometric;
	}
	public int getIntership() {
		return intership;
	}
	public void setIntership(int intership) {
		this.intership = intership;
	}





	@Override
	public String toString() {
		return "Result [student_id=" + student_id + ", computer=" + computer + ", software=" + software + ", java="
				+ java + ", operating=" + operating + ", virtu=" + virtu + ", biometric=" + biometric + ", intership="
				+ intership + "]";
	}
	
    
}