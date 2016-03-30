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
			dao.insert(new User("Margaret", "Thatcher", "maggy", "maggy"));
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
	
	@PUT
	@Path("/{id}")
	public void updateUserInfos(@PathParam("id") int id, User userUpdate) {
		logger.debug("info-user-update : " + userUpdate);
		User user = dao.findById(id);
		if (user == null) {
			throw new WebApplicationException(404);
		}
		
		// Getting changed values
    	String firstName = userUpdate.getFirstName();
    	String lastName = userUpdate.getLastName();
    	String login = userUpdate.getLogin();
    	String address = userUpdate.getAddress();
    	String postalCode = userUpdate.getPostalCode();
    	String location = userUpdate.getLocation();
    	String mobile = userUpdate.getMobile();
    	String password = userUpdate.getPassword();
    	int betz = userUpdate.getBetz();
    	
    	// Checking changes
    	if (firstName != null) user.setFirstName(firstName);
    	if (lastName != null) user.setLastName(lastName);
    	if (login != null) user.setLogin(login);
    	if (address != null) user.setAddress(address);
    	if (postalCode != null) user.setPostalCode(postalCode);
    	if (location != null) user.setLocation(location);
    	if (mobile != null) user.setMobile(mobile);
    	if (password != null) user.setPassword(password);
    	if (betz != 0) user.setBetz(betz);
		
		dao.updateInfos(user);
	}
	
	@PUT
	@Path("/{id}/{betz}")
	public void updateUserBetz(@PathParam("id") int id, @PathParam("betz") int betz) {
		logger.debug("betz-user-update : id=" + id + "/betz=" + betz);
		User user = dao.findById(id);
		if (user == null) {
			throw new WebApplicationException(404);
		}
		
		dao.updateSolde(id, betz);
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
