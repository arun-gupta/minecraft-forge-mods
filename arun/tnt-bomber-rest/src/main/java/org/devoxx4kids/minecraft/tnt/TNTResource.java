package org.devoxx4kids.minecraft.tnt;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author arungupta
 */
@Named("tntResource")
@SessionScoped
@Path("tnt")
public class TNTResource implements Serializable, PhaseListener {

    Map<String, TNTDatabase> stateMap = new HashMap<>();
    
    @EJB
    TNTDatabase state;

    @POST
    @Consumes("text/plain")
    @Path("player")
    public void setPlayerName(@NotNull String name) {
        state.setPlayerName(name);
    }

    @GET
    @Produces("text/plain")
    @Path("player")
    public String getPlayerName() {
        return state.getPlayerName();
    }

    @GET
    @Produces("text/plain")
    @Path("details")
    public String getPlayerDetails(@QueryParam("playerName")String playerName) {
        return stateMap.get(playerName).toString();
    }

    @POST
    @Consumes("text/plain")
    @Path("count")
    public void setTNTCount(@Min(1) @Max(100) int number) {
        state.setHowMany(number);
        System.out.println("Setting TNTs: " + number);
    }

    @GET
    @Produces("text/plain")
    @Path("count")
    public int getTNTCount() {
        System.out.println("Getting TNTs: " + state.getHowMany());

        return state.getHowMany();
    }

    @POST
    @Consumes("text/plain")
    @Path("spreadx")
    public void setSpreadX(@Min(1) @Max(10) int number) {
        state.setSpreadX(number);
    }

    @GET
    @Produces("text/plain")
    @Path("spreadx")
    public int getSpreadX() {
        return state.getSpreadX();
    }

    @POST
    @Consumes("text/plain")
    @Path("spready")
    public void setSpreadY(@Min(1) @Max(10) int number) {
        state.setSpreadY(number);
    }

    @GET
    @Produces("text/plain")
    @Path("spready")
    public int getSpreadY() {
        return state.getSpreadY();
    }

    @POST
    @Consumes("text/plain")
    @Path("spreadz")
    public void setSpreadZ(@Min(1) @Max(10) int number) {
        state.setSpreadZ(number);
    }

    @GET
    @Produces("text/plain")
    @Path("spreadz")
    public int getSpreadZ() {
        return state.getSpreadZ();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void processForm(@FormParam("playerName")String playerName,
            @FormParam("count")String tntCount, 
            @FormParam("spreadX")String spreadX,
            @FormParam("spreadY")String spreadY,
            @FormParam("spreadZ")String spreadZ) {
        setPlayerName(playerName);
        setTNTCount(Integer.parseInt(tntCount));
        setSpreadX(Integer.parseInt(spreadX));
        setSpreadY(Integer.parseInt(spreadY));
        setSpreadZ(Integer.parseInt(spreadZ));
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        if (null != getPlayerName()) {
            stateMap.put(getPlayerName(), state);
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        if (null != getPlayerName()) {
            state = stateMap.get(getPlayerName());
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
