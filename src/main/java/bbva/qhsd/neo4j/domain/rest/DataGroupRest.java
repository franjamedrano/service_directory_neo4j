package bbva.qhsd.neo4j.domain.rest;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Francisco Javier Medrano
 */
public class DataGroupRest {

    WorkGroupRest data;

    public DataGroupRest(){

    }

    public DataGroupRest(WorkGroupRest data){
        this.data=data;
    }

    public void setData(WorkGroupRest data){
        this.data = data;
    }

    public WorkGroupRest getData(){
        return data;
    }
}
