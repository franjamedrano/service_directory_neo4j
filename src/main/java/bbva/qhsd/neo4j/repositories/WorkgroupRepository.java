package bbva.qhsd.neo4j.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import bbva.qhsd.neo4j.domain.WorkGroup;

/**
 * @author Francisco Javier Medrano
 */
@RepositoryRestResource(collectionResourceRel = "workgroups", path = "workgroups")
public interface WorkgroupRepository extends PagingAndSortingRepository<WorkGroup, Long> {
	
	WorkGroup findByWorkGroupId(@Param("workGroupId") String workGroupId);
	
	//GET MEMBERS
	//@Query("MATCH (wg:Workgroup) WHERE wg.workGroup_id = '{wgid}' RETURN wg.workGroup_id as id,wg.name as name")
	//WorkGroupReturn getWorkgroup(@Param("wgid") String wgid);

	//GET MEMBERS
	@Query("MATCH (wg:WorkGroup)-[:BELONGS]-(members) WHERE wg.workGroupId = {wgid} RETURN members.userId")
	Collection<String> members(@Param("wgid") String wgid);
	
	//GET SUPERVISORS
	@Query("MATCH (wg:WorkGroup)-[:SUPERVISE]-(members) WHERE wg.workGroupId = {wgid} RETURN members.userId")
	Collection<String> supervisors(@Param("wgid") String wgid);
}

