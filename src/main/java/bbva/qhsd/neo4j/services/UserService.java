package bbva.qhsd.neo4j.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbva.qhsd.neo4j.domain.User;
import bbva.qhsd.neo4j.domain.WorkGroup;
import bbva.qhsd.neo4j.domain.rest.UserRest;
import bbva.qhsd.neo4j.domain.rest.WorkGroupAddRest;
import bbva.qhsd.neo4j.domain.rest.WorkGroupRest;
import bbva.qhsd.neo4j.repositories.UserRepository;
import bbva.qhsd.neo4j.repositories.WorkgroupRepository;

@Service
public class UserService {

	@Autowired WorkgroupRepository wgRepository;
	
	@Autowired UserRepository uRepository;
	
	final static Logger logger = Logger.getLogger(UserService.class);

	public UserRest getUser(String uid,String expand) {
		
		User u=  uRepository.findByUserId(uid);
		
		UserRest ur = new UserRest(u.getUserId());
		
		if (expand!= null && expand.equals("supervises")){
			ur.setSupervises(workGroup2wgIds(u.getSupervises()));
		}
		
		if (expand!= null && expand.equals("belongs")){
			ur.setBelongs(workGroup2wgIds(u.getBelongs()));
		}
		
		if (expand!= null && expand.equals("user_supervises")){
			ur.setUser_supervises(workGroup2uIds(u.getSupervises()));
		}
		
		return ur;
	}
	
	private List<String> workGroup2wgIds(List<WorkGroup> wgs){
		
		List<String> result = new ArrayList<String>();
		
		for( WorkGroup wg  : wgs){
			result.add(wg.getWorkGroupId());
		}
		
		return result;
	}
	
	private List<String> workGroup2uIds(List<WorkGroup> wgs){
		
		List<String> result = new ArrayList<String>();
		
		Set<String> aux = new LinkedHashSet<String>();
		
		for( WorkGroup wg  : wgs){
			
			Collection<String> members = wgRepository.members(wg.getWorkGroupId());
			
			aux.addAll(members);
			
		}
		
		result.addAll(aux);
		
		return result;
	}

}
