package org.devoxx4kids.minecraft.tnt;

import javax.ejb.EJB;
import javax.inject.Named;
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
@Named("tntResource")
@Path("tnt")
public class TNTResource {

    @EJB
    TNTDatabase state;

    @POST
    @Consumes("text/plain")
    @Path("/count")
    public void setTNTCount(int number) {
//        int howMany = Integer.parseInt(number);

        state.setHowMany(number);
        System.out.println("Setting TNTs: " + number);
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
    public void setSpreadX(int number) {
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
    public void setSpreadY(int number) {
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
    public void setSpreadZ(int number) {
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
    public void processForm(@FormParam("count")String tntCount, 
            @FormParam("spreadX")String spreadX,
            @FormParam("spreadY")String spreadY,
            @FormParam("spreadZ")String spreadZ) {
        setTNTCount(Integer.parseInt(tntCount));
        setSpreadX(Integer.parseInt(spreadX));
        setSpreadY(Integer.parseInt(spreadY));
        setSpreadZ(Integer.parseInt(spreadZ));
    }
}
