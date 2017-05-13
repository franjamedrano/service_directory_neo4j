package bbva.qhsd.neo4j.repositories;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import bbva.qhsd.neo4j.domain.User;
import bbva.qhsd.neo4j.domain.WorkGroup;

/**
 * @author Francisco Javier Medrano
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class WorkgroupRepositoryTest {

	@Autowired
	private Session session;

	@Autowired
	private WorkgroupRepository wgInstance;
	
	@Autowired
	private UserRepository uInstance;


	public WorkgroupRepositoryTest() {
	}

	@Before
	public void setUp() {
		
		WorkGroup wg = new WorkGroup("group","groupId");
		wgInstance.save(wg);
		
		User user1 = new User("user1");
		User user2 = new User("user2");
		User user3 = new User("user3");
		User user4 = new User("user4");
		
		user1.addBelong(wg);
		user2.addBelong(wg);
		user3.addBelong(wg);
		user4.addBelong(wg);
		user1.addSupervise(wg);

		uInstance.save(user1);
		uInstance.save(user2);
		uInstance.save(user3);
		uInstance.save(user4);


		
	}

	@After
	public void tearDown() {
		session.purgeDatabase();
	}

	/**
	 * Test of findWorkgroup method, of class WorkgroupRepository.
	 */
	@Test
	public void testFindWorkgroup() {

		String wgId = "groupId";
		WorkGroup result = wgInstance.findByWorkGroupId(wgId);
		assertNotNull(result);
		assertEquals("group", result.getName());
	}
	

	
	/**
	 * Test of findUser method, of class UserRepository.
	
	@Test
	public void testFindUser() {

		String uId = "user1";
		UserSave result = uInstance.findByName(uId);
		assertNotNull(result);
		assertEquals("user1", result.getName());
	}
 */
	/**
	 * Test of findByTitleContaining method, of class MovieRepository.
	 
	@Test
	public void testFindByTitleContaining() {
		String title = "Matrix";
		Collection<Movie> result = instance.findByTitleLike(title);
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Test of graph method, of class MovieRepository.
	 
	@Test
	public void testGraph() {
		Collection<Movie> graph = instance.graph(5);

		assertEquals(1, graph.size());

		Movie movie = graph.iterator().next();

		assertEquals(1, movie.getRoles().size());

		assertEquals("The Matrix", movie.getTitle());
		assertEquals("Keanu Reeves", movie.getRoles().iterator().next().getPerson().getName());
	}
	*/
}
