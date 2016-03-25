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
import java.sql.Date;

/**
 * Ressource User (accessible avec le chemin "/events")
 */
@Path("events")
public class EvenementResource {
    // Pour l'instant, on se contentera d'une variable statique
    // pour conserver l'état
    private static Map<String, Evenement> evenements = new HashMap<>();

    /**
     * Méthode de création d'un événement qui prend en charge les requêtes
     * HTTP POST
     *
     * @param  evenement Instance d'evenement à créer
     * @return Evenement le nouvel evenement
     */
    @POST
    public Evenement createEvenement(Evenement evenement) {
        // Si l'evenement existe déjà, renvoyer null
        if ( evenements.containsKey(evenement.getTitre()) ) {
            return null;
        }
        else {
            evenements.put(evenement.getTitre(), evenement);
            return evenement;
        }
    }

    /**
     * Methode prenant en charge les requêtes HTTP GET.
     * @return Une liste d'evenements
     */
    @GET
    public List<Evenement> getEvenement() {
        return new ArrayList<Evenement>(evenements.values());
    }

    /** 
     * Méthode prenant en charge les requêtes HTTP GET sur /users/{login}
     *
     * @return Une instance de Evenement
     */
    @GET
    @Path("{titre}")
    @Produces("application/json, application/xml")
    public Evenement getEvenement(@PathParam("titre") String titre) {
        // Si l'evenement est inconnu, on renvoie 404
        if ( ! evenements.containsKey(titre) ) {
            throw new NotFoundException();
        }
        else {
            return evenements.get(titre);
        }
    }

    @DELETE
    @Path("{titre}")
    public Response deleteEvenement(@PathParam("titre") String titre) {
        // Si l'evenement est inconnu, on renvoie 404
        if (  ! evenements.containsKey(titre) ) {
            throw new NotFoundException();
        }
        else {
            evenements.remove(titre);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    /** 
     * Méthode prenant en charge les requêtes HTTP PUT sur /users/{login}
     *
     * @param titre le titre de l'evenement à modifier
     * @return Un code de retour HTTP dans un objet Response
     */
    @PUT
    @Path("{titre}")
        public Response modifyEvenement(@PathParam("titre") String titre, Evenement evenement) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if ( ! evenements.containsKey(evenement.getTitre()) ) {
            throw new NotFoundException();
        }
        else {
            evenements.put(evenement.getTitre(), evenement);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

   /**
     * Méthode de création d'un utilisateur qui prend en charge les requêtes HTTP POST au format application/x-www-form-urlencoded
     * La méthode renvoie l'URI de la nouvelle instance en cas de succès
     *
     * @param titre titre de l'evenement
     * @param idUser nom de l'utilisateur createur de l'evenement
     * @param description la description de l'evenement
     * @param nbParieurs le nombre de parieurs
     * @param miseMin la mise minimale obligatoire pour pouvoir participer
     * @param nbParieursMin le nombre minimum de parieurs
     * @param cote la cote de l'evenement
     * @param datef la date limite pour parier sur l'evenement
     * @param prive la visibilite de l'evenement
     * @return Evenement le nouvel evenement
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
        public Evenement createEvenement(@FormParam("titre") String titre, @FormParam("idUser") int idUser, @FormParam("description") String description, @FormParam("nbParieurs") int nbParieurs, @FormParam("miseMin") int miseMin, @FormParam("nbParieursMin") int nbParieursMin, @FormParam("cote") int cote, @FormParam("datef") Date datef, @FormParam("prive") boolean prive) {
        // Si l'utilisateur existe déjà, renvoyer null
        if ( evenements.containsKey(titre) ) {
            return null;
        }
        else {
        	Evenement nouveau = new Evenement(idUser, titre, description, nbParieurs, nbParieursMin, miseMin, cote, datef, prive);
            evenements.put(titre, nouveau);
            return nouveau;
        }
    }
}
