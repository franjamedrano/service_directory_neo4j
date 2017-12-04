package bbva.qhsd.neo4j.domain.rest;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Francisco Javier Medrano
 */
public class BelongsRest {

	private String id;
	
	private String name;

	public BelongsRest() {
	}


	public BelongsRest(String id,String name) {
        this.id = id;
        this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getId() {
		return id;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
	 
}
