package bbva.qhsd.neo4j.domain.rest;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Francisco Javier Medrano
 */
public class DataRest {

    UserRest data;

    public DataRest(){

    }

    public DataRest(UserRest data){
        this.data=data;
    }

    public void setData(UserRest data){
        this.data = data;
    }

    public UserRest getData(){
        return data;
    }
}
