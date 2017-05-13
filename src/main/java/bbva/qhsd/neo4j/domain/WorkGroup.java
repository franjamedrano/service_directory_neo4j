package bbva.qhsd.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Francisco Javier Medrano
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class WorkGroup {

	@GraphId
	private Long id;

	private String name;
	
	private String workGroupId;

	public WorkGroup() {
	}


	public WorkGroup(String name, String workGroupId) {
		super();
		this.name = name;
		this.workGroupId = workGroupId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getWorkGroupId() {
		return workGroupId;
	}


	public void setWorkGroupId(String workGroupId) {
		this.workGroupId = workGroupId;
	}

}
