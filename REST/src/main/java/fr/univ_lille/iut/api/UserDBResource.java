package fr.univ_lille.iut.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univ_lille.iut.web.WebApplication;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/userdb")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserDBResource {
	private static UserDao dao = BDDFactory.getDbi().open(UserDao.class);
    final static Logger logger = LoggerFactory.getLogger(UserDBResource.class);


    public UserDBResource() {
		try {
			dao.createUsersTable();
			dao.insert(new User("Margaret", "Thatcher"));
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public User createUser(User user) {
        user.resetPasswordHash();
        int id = dao.insert(user);
        user.setId(id);
		return user;
	}
	
	@DELETE
	@Path("/{id}")
	public User removeUserById(@PathParam("id") int id) {
		User user = dao.findById(id);
		if (user == null) {
			throw new WebApplicationException(404);
		}
		dao.delete(id);
		return user;
	}
	
	/*@PUT
	@Path("/{id}")
	public User updateUser(@PathParam("id") int id, User user) {
		logger.debug("id : " + id);
		User u = dao.findById(id);
		if (u == null) {
			throw new WebApplicationException(404);
		}
		//dao.update(id, user);
		return user;
	}
	*/
	
	@GET
	@Path("/{login}")
	public User getUser(@PathParam("login") String login) {
		User user = dao.findByLogin(login);
		if (user == null) {
			throw new WebApplicationException(404);
		}
		return user;
	}

	@GET
	public List<User> getAllUsers() {
		return dao.all();
	}

}
