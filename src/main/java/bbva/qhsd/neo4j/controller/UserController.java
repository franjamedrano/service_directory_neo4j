package bbva.qhsd.neo4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bbva.qhsd.neo4j.domain.rest.UserRest;
import bbva.qhsd.neo4j.domain.rest.WorkGroupAddRest;
import bbva.qhsd.neo4j.domain.rest.WorkGroupRest;
import bbva.qhsd.neo4j.services.UserService;
import bbva.qhsd.neo4j.services.WorkgroupService;

/**
 * @author Francisco Javier Medrano
 */
@RestController
@RequestMapping("/users")
public class UserController {

	final UserService uService;

	@Autowired
	public UserController(UserService uService) {
		this.uService = uService;
	}
	

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
	public UserRest getWorkGroup(@PathVariable("userId") String userId,@RequestParam(value = "expand", required = false) String expand) {
		return uService.getUser(userId,expand);
	}

}
