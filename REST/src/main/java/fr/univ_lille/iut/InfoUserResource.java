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
@Path("infoUser")
public class InfoUserResource {
    // Pour l'instant, on se contentera d'une variable statique
    // pour conserver l'état
    private static Map<Integer, InfoUser> infoUsers = new HashMap<>();

    // L'annotation @Context permet de récupérer des informations sur
    // le contexte d'exécution de la ressource.
    // Ici, on récupère les informations concernant l'URI de la requête HTTP,
    // ce qui nous permettra de manipuler les URI de manière générique.
    @Context
    public UriInfo uriInfo;

    /**
     * Une ressource doit avoir un contructeur (éventuellement sans arguments)
     */
    public InfoUserResource() {
    }

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
    public Response createUser(InfoUser infoUser) {
        // Si l'utilisateur existe déjà, renvoyer 409
        if ( infoUsers.containsKey(infoUser.getIdUser()) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            infoUsers.put(infoUser.getIdUser(), infoUser);

            // On renvoie 201 et l'instance de la ressource dans le Header
            // HTTP 'Location'
            URI instanceURI = uriInfo.getAbsolutePathBuilder().path(String.valueOf(infoUser.getIdUser())).build();
            return Response.created(instanceURI).build();
        }
    }

    /**
     * Methode prenant en charge les requêtes HTTP GET.
     * @return Une liste d'utilisateurs
     */
    @GET
    public List<InfoUser> getInfoUsers() {
        return new ArrayList<InfoUser>(infoUsers.values());
    }

    /** 
     * Méthode prenant en charge les requêtes HTTP GET sur /users/{login}
     *
     * @return Une instance de User
     */
    @GET
    @Path("{idUser}")
    @Produces("application/json,application/xml")
    public InfoUser getInfoUser(@PathParam("idUser") Integer idUser) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (  ! infoUsers.containsKey(idUser) ) {
            throw new NotFoundException();
        }
        else {
            return infoUsers.get(idUser);
        }
    }

    @DELETE
    @Path("{idUser}")
    public Response deleteInfoUser(@PathParam("IdUser") Integer idUser) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (  ! infoUsers.containsKey(idUser) ) {
            throw new NotFoundException();
        }
        else {
            infoUsers.remove(idUser);
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
    @Path("{idUser}")
        public Response modifyInfoUser(@PathParam("IdUser") int idUser, InfoUser infoUser) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (  ! infoUsers.containsKey(infoUser.getIdUser()) ) {
            throw new NotFoundException();
        }
        else {
            infoUsers.put(infoUser.getIdUser(), infoUser);
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
        public Response createInfoUser(@FormParam("idUser") int idUser, @FormParam("solde") double solde, @FormParam("parisPerdus") int parisPerdus, @FormParam("parisGagnes") int parisGagnes, @FormParam("argentGagner") int argentGagner, @FormParam("argentPerdu") int argentPerdu) {
        // Si l'utilisateur existe déjà, renvoyer 409
        if ( infoUsers.containsKey(idUser) ) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            infoUsers.put(idUser, new InfoUser(idUser, solde, parisPerdus, parisGagnes, argentGagner, argentPerdu));

            // On renvoie 201 et l'instance de la ressource dans le Header HTTP 'Location'
            URI instanceURI = uriInfo.getAbsolutePathBuilder().path(String.valueOf(idUser)).build();
            return Response.created(instanceURI).build();
        }
    }
}
