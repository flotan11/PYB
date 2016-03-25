package fr.univ_lille.iut.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private static Map<Integer, User> users = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(UserResource.class);

    @POST
    public User createUser(User user) {
        int id = users.size();
        user.setId(id + 1);
        users.put(user.getId(), user);
        return user;
    }

   /**
     * Méthode de création d'un utilisateur qui prend en charge les requêtes HTTP POST au format application/x-www-form-urlencoded
     * La méthode renvoie l'URI de la nouvelle instance en cas de succès
     *
     * @param login login de l'utilisateur
     * @param name nom de l'utilisateur
     * @param mail le mail de l'utilisateur
     * @return Response le corps de la réponse est vide, le code de retour HTTP est fixé à 201 si la création est faite
     *         L'en-tête contient un champs Location avec l'URI de la nouvelle ressource
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
        public User createUser(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname, @FormParam("login") String login) {
        // Si l'utilisateur existe déjà, renvoyer NULL
        int id = users.size() + 1;
        if ( users.containsKey(login) ) {
            return null;
        }
        else {
        	User nouveau = new User(id, firstname, lastname, login);
            users.put(id, nouveau);
            return nouveau;
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        if (users.containsKey(id)) {
            return Response.accepted().status(Status.ACCEPTED).build();
        }
        return Response.accepted().status(Status.NOT_FOUND).build();
    }

    protected User find(String login) {
        for (User user : users.values()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    protected User find(int id) {
        return users.get(id);
    }

    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id, User user) {
        User oldUser = find(id);
        logger.info("Should update user with id: " + id + " (" + oldUser + ") to " + user);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        oldUser.setLogin(user.getLogin());
        return Response.status(200).entity(oldUser).build();
    }

    @GET
    @Path("/{login}")
    public User getUser(@PathParam("login") String login) {
        User out = find(login);
        if (out == null) {
            throw new WebApplicationException(404);
        }
        return out;
    }

    @GET
    public List<User> getUsers(@DefaultValue("10") @QueryParam("limit") int limit) {
        return new ArrayList<>(users.values());
    }

}
