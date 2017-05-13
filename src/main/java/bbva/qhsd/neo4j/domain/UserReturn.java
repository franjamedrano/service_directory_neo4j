package bbva.qhsd.neo4j.domain;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Francisco Javier Medrano
 */
public class UserReturn {

	private String name;

	private List<String> belongs = new ArrayList<>();
	
	private List<String> supervises = new ArrayList<>();
	
	private List<String> user_supervises = new ArrayList<>();

	public UserReturn() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getBelongs() {
		return belongs;
	}

	public void setBelongs(List<String> belongs) {
		this.belongs = belongs;
	}

	public List<String> getSupervises() {
		return supervises;
	}

	public void setSupervises(List<String> supervises) {
		this.supervises = supervises;
	}

	public List<String> getUser_supervises() {
		return user_supervises;
	}

	public void setUser_supervises(List<String> user_supervises) {
		this.user_supervises = user_supervises;
	}
	
	

	
	 
}
