package bbva.qhsd.neo4j.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bbva.qhsd.neo4j.domain.rest.WorkGroupAddRest;
import bbva.qhsd.neo4j.domain.rest.WorkGroupRest;
import bbva.qhsd.neo4j.services.WorkgroupService;

/**
 * @author Francisco Javier Medrano
 */
@RestController
@RequestMapping("/workGroups")
public class WorkgroupController {

	final WorkgroupService wgService;

	@Autowired
	public WorkgroupController(WorkgroupService wgService) {
		this.wgService = wgService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveWorkGroup(@RequestBody WorkGroupRest input) {
		return wgService.saveWorkGroup(input);
	}

	@RequestMapping(value = "/{workGroupId}", method = RequestMethod.GET, produces = "application/json")
	public WorkGroupRest getWorkGroup(@PathVariable("workGroupId") String workGroupId,@RequestParam(value = "expand", required = false) String expand) {
		return wgService.getWorkgroup(workGroupId,expand);
	}

	@RequestMapping(value = "/{workGroupId}", method = RequestMethod.DELETE)
	public void deleteWorkGroup(@PathVariable("workGroupId") String workGroupId) {
		wgService.deleteWorkGroup(workGroupId);
	}

	@RequestMapping(value = "/{workGroupId}/members", method = RequestMethod.POST)
	public void add(@PathVariable("workGroupId") String workGroupId,@RequestBody WorkGroupAddRest input) {
		wgService.addMember2WorkGroup(workGroupId,input);
	}
	
	@RequestMapping(value = "/{workGroupId}/members/{userId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("workGroupId") String workGroupId,@PathVariable("userId") String userId) {
		wgService.deleteMember2WorkGroup(workGroupId,userId);
	}
}
