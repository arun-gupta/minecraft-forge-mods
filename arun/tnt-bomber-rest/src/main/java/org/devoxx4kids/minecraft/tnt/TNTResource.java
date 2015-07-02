package org.devoxx4kids.minecraft.tnt;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author arungupta
 */
@Path("tnt")
public class TNTResource {

    @EJB
    TNTDatabase state;

    @POST
    @Consumes("text/plain")
    @Path("/count")
    public void setTNTCount(String number) {
        int howMany = Integer.parseInt(number);

        state.setHowMany(howMany);
        System.out.println("Setting TNTs: " + howMany);
    }

    @GET
    @Produces("text/plain")
    @Path("/count")
    public int getTNTCount() {
        System.out.println("Getting TNTs: " + state.getHowMany());

        return state.getHowMany();
    }

    @POST
    @Consumes("text/plain")
    @Path("spreadx")
    public void setSpreadX(String number) {
        state.setSpreadX(Integer.parseInt(number));
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
    public void setSpreadY(String number) {
        state.setSpreadY(Integer.parseInt(number));
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
    public void setSpreadZ(String number) {
        state.setSpreadZ(Integer.parseInt(number));
    }

    @GET
    @Produces("text/plain")
    @Path("spreadz")
    public int getSpreadZ() {
        return state.getSpreadZ();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void processForm(@FormParam("count")String tntCount, 
            @FormParam("spreadX")String spreadX,
            @FormParam("spreadY")String spreadY,
            @FormParam("spreadZ")String spreadZ) {
        setTNTCount(tntCount);
        setSpreadX(spreadX);
        setSpreadY(spreadY);
        setSpreadZ(spreadZ);
    }
}
