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
 * Ressource User (accessible avec le chemin "/info")
 */
@Path("info")
public class InfoUserResource {
    // Pour l'instant, on se contentera d'une variable statique
    // pour conserver l'état
    private static Map<Integer, InfoUser> infoUsers = new HashMap<>();
    
    /**
     * Méthode de création d'une fiche informative d'un utilisateur qui prend en charge les requêtes HTTP POST
     * La méthode renvoie l'URI de la nouvelle instance en cas de succès
     *
     * @param  user Instance d'utilisateur à créer
     * @return InfoUser les nouvelles infos
     */
    @POST
    public InfoUser createUser(InfoUser infoUser) {
        // Si l'utilisateur existe déjà, renvoyer 409
        if ( infoUsers.containsKey(infoUser.getIdUser()) ) {
            return null;
        }
        else {
            infoUsers.put(infoUser.getIdUser(), infoUser);
            return infoUser;
        }
    }

    /**
     * Methode prenant en charge les requêtes HTTP GET.
     * @return Une liste d'informations sur les utilisateurs
     */
    @GET
    public List<InfoUser> getInfoUsers() {
        return new ArrayList<InfoUser>(infoUsers.values());
    }

    /** 
     * Méthode prenant en charge les requêtes HTTP GET sur /users/{login}
     *
     * @return Une instance de InfoUser
     */
    @GET
    @Path("{idUser}")
    @Produces("application/json, application/xml")
    public InfoUser getInfoUser(@PathParam("idUser") Integer idUser) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if ( ! infoUsers.containsKey(idUser) ) {
            throw new NotFoundException();
        }
        else {
            return infoUsers.get(idUser);
        }
    }

    @DELETE
    @Path("{idUser}")
    public Response deleteInfoUser(@PathParam("idUser") Integer idUser) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if ( ! infoUsers.containsKey(idUser) ) {
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
     * @param idUser l'id de l'utilisateur à modifier
     * @param infoUser l'entité correspondant à la nouvelle instance
     * @return Un code de retour HTTP dans un objet Response
     */
    @PUT
    @Path("{idUser}")
        public Response modifyInfoUser(@PathParam("idUser") int idUser, InfoUser infoUser) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if ( ! infoUsers.containsKey(infoUser.getIdUser()) ) {
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
     * @param idUser id de l'utilisateur
     * @param solde solde de l'utilisateur
     * @param parisPerdus le nombre de paris perdus par l'utilisateur
     * @param parisGagnes le nombre de paris gagnes par l'utilisateur
     * @param argentPerdu la quantite d'argent perdue par l'utilisateur
     * @param argentGagne la quantite d'argent gagnee par l'utilisateur
     * @return Response le corps de la réponse est vide, le code de retour HTTP est fixé à 201 si la création est faite
     *         L'en-tête contient un champs Location avec l'URI de la nouvelle ressource
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
        public InfoUser createInfoUser(@FormParam("idUser") int idUser, @FormParam("solde") double solde, @FormParam("parisPerdus") int parisPerdus, @FormParam("parisGagnes") int parisGagnes, @FormParam("argentGagne") double argentGagne, @FormParam("argentPerdu") double argentPerdu) {
        // Si l'utilisateur existe déjà, renvoyer 409
        if ( infoUsers.containsKey(idUser) ) {
            return null;
        }
        else {
        	InfoUser nouveau = new InfoUser(idUser, solde, parisPerdus, parisGagnes, argentGagne, argentPerdu);
            infoUsers.put(idUser, nouveau);
            return nouveau;
        }
    }
}
