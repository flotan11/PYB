package fr.univ_lille.iut;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Ressource User (accessible avec le chemin "/users")
 */
@Path("users")
public class UserResource {
    // Pour l'instant, on se contentera d'une variable statique
    // pour conserver l'état
    private static Map<String, User> users = new HashMap<>();

    /**
     * Méthode de création d'un utilisateur qui prend en charge les requêtes
     * HTTP POST
     * La méthode renvoie l'URI de la nouvelle instance en cas de succès
     *
     * @param  user Instance d'utilisateur à créer
     * @return Response le corps de la réponse est vide, le code de retour HTTP
     * est fixé à 201 si la création est faite.
     * L'en-tête contient un champs Location avec l'URI de la nouvelle ressource
     */
    @POST
    public User createUser(User user) {
        // Si l'utilisateur existe déjà, renvoyer 409
        if ( users.containsKey(user.getLogin()) ) {
            return null;
        }
        else {
            users.put(user.getLogin(), user);
            return user;
        }
    }

    /**
     * Methode prenant en charge les requêtes HTTP GET.
     * @return Une liste d'utilisateurs
     */
    @GET
    public List<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    /** 
     * Méthode prenant en charge les requêtes HTTP GET sur /users/{login}
     *
     * @return Une instance de User
     */
    @GET
    @Path("{login}")
    @Produces("application/json, application/xml")
    public User getUser(@PathParam("login") String login) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if ( ! users.containsKey(login) ) {
            throw new NotFoundException();
        }
        else {
            return users.get(login);
        }
    }

    @DELETE
    @Path("{login}")
    public Response deleteUser(@PathParam("login") String login) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (  ! users.containsKey(login) ) {
            throw new NotFoundException();
        }
        else {
            users.remove(login);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    /** 
     * Méthode prenant en charge les requêtes HTTP PUT sur /users/{login}
     *
     * @param login le login de l'utilisateur à modifier
     * @param user l'entité correspondant à la nouvelle instance
     * @return Un code de retour HTTP dans un objet Response
     */
    @PUT
    @Path("{login}")
        public Response modifyUser(@PathParam("login") String login, User user) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (  ! users.containsKey(user.getLogin()) ) {
            throw new NotFoundException();
        }
        else {
            users.put(user.getLogin(), user);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
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
        public User createUser(@FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("login") String login, @FormParam("mdp") String mdp, @FormParam("adresse") String adresse, @FormParam("codePostal") int codePostal, @FormParam("ville") String ville, @FormParam("mail") String mail, @FormParam("age") int age, @FormParam("mobile") String mobile) {
        // Si l'utilisateur existe déjà, renvoyer NULL
        if ( users.containsKey(login) ) {
            return null;
        }
        else {
        	User nouveau = new User(nom, prenom, login, mdp, adresse, codePostal, ville, mail, age, mobile);
            users.put(login, nouveau);
            return nouveau;
        }
    }
}
