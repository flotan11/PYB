package fr.univ_lille.iut.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			dao.createUserTable();
			dao.insert(new User("Margaret", "Thatcher"));
		} catch (Exception e) {
			//System.out.println("Table déjà là !");
			logger.debug(e.getStackTrace().toString());
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
	@Path("/{login}")
	public User removeUser(@PathParam("login") String login) {
		User user = dao.findByLogin(login);
		if (user == null) {
			throw new WebApplicationException(404);
		}
		dao.delete(login);
		return user;
	}

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
