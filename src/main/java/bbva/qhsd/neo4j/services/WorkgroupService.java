package bbva.qhsd.neo4j.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbva.qhsd.neo4j.domain.User;
import bbva.qhsd.neo4j.domain.WorkGroup;
import bbva.qhsd.neo4j.domain.rest.WorkGroupAddRest;
import bbva.qhsd.neo4j.domain.rest.WorkGroupRest;
import bbva.qhsd.neo4j.repositories.UserRepository;
import bbva.qhsd.neo4j.repositories.WorkgroupRepository;

@Service
public class WorkgroupService {

	@Autowired WorkgroupRepository wgRepository;
	
	@Autowired UserRepository uRepository;
	
	final static Logger logger = Logger.getLogger(WorkgroupService.class);

	@Transactional(readOnly = true)
	public WorkGroupRest getWorkgroup(String wgid,String expand) {
		
		WorkGroup wg=  wgRepository.findByWorkGroupId(wgid);
		
		WorkGroupRest wgr = new WorkGroupRest(wg.getName(), wg.getWorkGroupId());
		
		if (expand!= null && expand.equals("members")){
			wgr.setMembers(wgRepository.members(wgid));
		}
		
		if (expand!= null && expand.equals("supervisors")){
			wgr.setSupervisors(wgRepository.supervisors(wgid));
		}
		
		return wgr;
	}
	
	public String saveWorkGroup(WorkGroupRest wgr){
		
		WorkGroup wg= new WorkGroup(wgr.getName(), wgr.getId());
		WorkGroup wgNew = wgRepository.save(wg);
		
		Collection<User> usersUpdate = new ArrayList<User>();
		
		for (String u : wgr.getMembers()){
			User uSave = uRepository.findByUserId(u);
			if (uSave != null){
				uSave.addBelong(wgNew);
				usersUpdate.add(uSave);
			}
		}
		
		for (String u : wgr.getSupervisors()){
			User uSave = uRepository.findByUserId(u);
			if (uSave != null){
				uSave.addSupervise(wgNew);
				usersUpdate.add(uSave);
			}
		}
		
		uRepository.save(usersUpdate);
		
		return wgNew.getWorkGroupId();
		
	}
	
	public void addMember2WorkGroup(String workGroupId,WorkGroupAddRest wgar){
		
		WorkGroup wg = wgRepository.findByWorkGroupId(workGroupId);
		User u = uRepository.findByUserId(wgar.getUserId());
		
		u.addBelong(wg);
		
		uRepository.save(u);
		
	}
	
	public void deleteMember2WorkGroup(String workGroupId,String userId){
		
		WorkGroup wg = wgRepository.findByWorkGroupId(workGroupId);
		User u = uRepository.findByUserId(userId);
		
		u.getBelongs().remove(wg);
		
		uRepository.save(u);
		
	}
	
	public void addSupervisor2WorkGroup(String workGroupId,WorkGroupAddRest wgar){
		
		WorkGroup wg = wgRepository.findByWorkGroupId(workGroupId);
		User u = uRepository.findByUserId(wgar.getUserId());
		
		u.addSupervise(wg);
		
		uRepository.save(u);
		
	}
	
	public void deleteSupervisor2WorkGroup(String workGroupId,String userId){
		
		WorkGroup wg = wgRepository.findByWorkGroupId(workGroupId);
		User u = uRepository.findByUserId(userId);
		
		u.getSupervises().remove(wg);
		
		uRepository.save(u);
		
	}
	
	public void deleteWorkGroup(String wgId){
		WorkGroup wg=  wgRepository.findByWorkGroupId(wgId);
		
		if (wg != null){
			wgRepository.delete(wg);
		}
	}
	

	

}
