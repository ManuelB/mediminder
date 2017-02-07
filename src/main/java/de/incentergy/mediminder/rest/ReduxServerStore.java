package de.incentergy.mediminder.rest;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("reduxServerStore")
public class ReduxServerStore {

    private static final Logger log = Logger
            .getLogger(ReduxServerStore.class.getName());

    @PersistenceContext(unitName="mediminder")
    EntityManager em;

    @POST
    @Path("/ADD_MEDICINE")
    @Consumes(MediaType.APPLICATION_JSON)
    public void ADD_MEDICINE(JsonObject jsonObject) {
    	
    }
    
    @POST
    @Path("/DELETE_MEDICINE")
    @Consumes(MediaType.APPLICATION_JSON)
    public void DELETE_MEDICINE(JsonObject jsonObject) {
    	
    }

}
