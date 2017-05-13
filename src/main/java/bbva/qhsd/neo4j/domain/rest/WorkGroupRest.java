package bbva.qhsd.neo4j.domain.rest;

import java.util.Collection;

/**
 * @author Francisco Javier Medrano
 */
public class WorkGroupRest {

	private String name;
	
	private String id;
	
	private Collection<String> members;
	
	private Collection<String> supervisors;

	public WorkGroupRest() {
	}


	public WorkGroupRest(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public Collection<String> getMembers() {
		return members;
	}

	public void setMembers(Collection<String> members) {
		this.members = members;
	}

	public Collection<String> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(Collection <String> supervisors) {
		this.supervisors = supervisors;
	}
	
}
