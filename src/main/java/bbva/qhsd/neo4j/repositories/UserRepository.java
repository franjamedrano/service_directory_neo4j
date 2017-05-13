package bbva.qhsd.neo4j.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bbva.qhsd.neo4j.domain.User;
import bbva.qhsd.neo4j.domain.WorkGroup;

/**
 * @author Francisco Javier Medrano
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	
	User findByUserId(@Param("userId") String userId);
	
	//GET MEMBERS
	@Query("MATCH (m:User)-[:BELONGS]-(wg) WHERE m.name = {uid} RETURN wg")
	Collection<User> workgroups(@Param("uid") String wgid,@Param("limit") int limit);
	
	//GET SUPERVISORS
	@Query("MATCH (m:User)-[:SUPERVISE]-(wg) WHERE m.name = {uid} RETURN wg")
	Collection<User> supervisors(@Param("wgid") String wgid,@Param("limit") int limit);

}
