package fr.univ_lille.iut.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/paridb")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PariDBResource {
	private static PariDao dao = BDDFactory.getDbi().open(PariDao.class);
    final static Logger logger = LoggerFactory.getLogger(PariDBResource.class);


    public PariDBResource() {
		try {
			dao.createParisTable();
			dao.insert(new Pari("Paris-Lille", "Allez ! Allez, allez, allez !"));
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public Pari createPari(Pari pari) {
        int id = dao.insert(pari);
        pari.setId(id);
		return pari;
	}
	
	@PUT
	@Path("/{id}")
	public void updateMises(@PathParam("id") int id, @PathParam("side") String side, @PathParam("mise") int mise) {
		Pari pari = dao.findById(id);
		logger.debug("pari-content: " + pari);
		if (pari == null) {
			throw new WebApplicationException(404);
		}
		
		if (side == null) {
			throw new IllegalArgumentException("No side has been specified");
		} else if (side.equals(pari.getSideOne())) {
			pari.addMiseSideOne(mise);
		} else if (side.equals(pari.getSideTwo())) {
			pari.addMiseSideTwo(mise);
		} else {
			throw new IllegalArgumentException("No such team");
		}
		
		dao.updateValues(pari);
	}
	
	@DELETE
	@Path("/{id}")
	public Pari removePariById(@PathParam("id") int id) {
		Pari pari = dao.findById(id);
		if (pari == null) {
			throw new WebApplicationException(404);
		}
		dao.delete(id);
		return pari;
	}
	
	@GET
	@Path("/{id}")
	public Pari getPari(@PathParam("id") int id) {
		Pari pari = dao.findById(id);
		if (pari == null) {
			throw new WebApplicationException(404);
		}
		return pari;
	}

	@GET
	public List<Pari> getAllParis() {
		return dao.all();
	}

}
