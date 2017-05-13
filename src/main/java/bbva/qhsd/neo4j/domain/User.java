package bbva.qhsd.neo4j.domain;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Francisco Javier Medrano
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class User {

	@GraphId
	private Long id;
	
	private String userId;

	@Relationship(type = "BELONGS")
	private List<WorkGroup> belongs = new ArrayList<>();
	
	@Relationship(type = "SUPERVISE")
	private List<WorkGroup> supervises = new ArrayList<>();

	public User() {
	}


	public User(String userId) {
		super();
		this.userId = userId;
	}


	public Long getId() {
		return id;
	}


	public List<WorkGroup> getBelongs() {
		return belongs;
	}
	
	public void addBelong(WorkGroup wg) {
		this.belongs.add(wg);
	}


	public List<WorkGroup> getSupervises() {
		return supervises;
	}


	public void addSupervise(WorkGroup wgs) {
		this.supervises.add(wgs);
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	 
}
