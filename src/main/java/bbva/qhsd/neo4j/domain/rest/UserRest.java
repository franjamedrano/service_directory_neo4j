package bbva.qhsd.neo4j.domain.rest;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Francisco Javier Medrano
 */
public class UserRest {

	private String id;
	
	private Collection<BelongsRest> belongs = new ArrayList<>();
	
	//private List<String> supervises = new ArrayList<>();
	
	//private List<String> user_supervises = new ArrayList<>();

	public UserRest() {
	}


	public UserRest(String id) {
		super();
		this.id = id;
	}


	public Collection<BelongsRest> getBelongs() {
		return belongs;
	}


	public void setBelongs(Collection<BelongsRest> belongs) {
		this.belongs = belongs;
	}

	/*
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
	*/


	public void setId(String id) {
		this.id = id;
	}


	public String getId() {
		return id;
	}

	


	 
}
