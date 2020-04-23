package edu.upc.dsa;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.Brote;
import edu.upc.dsa.Casos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/covid19", description = "Endpoint")
@Path("/covid19service")
public class Covid19Service {
    private Covid19Manager cv;
    Brote brote;
    List<Casos> casos;
    public Covid19Service() {
        this.cv = Covid19ManagerImpl.getInstance();
        if (cv.sizeBrote() == 0) {
            cv = Covid19ManagerImpl.getInstance();
            casos = new LinkedList<>();
            brote = new Brote ("1", casos);
            brote = new Brote ("2", casos);
            brote = new Brote ("3", casos);
            casos.add(new Casos("01", "Carlos", "Vazquez", "07/06/1997",
                    "17/04/2020", "alto", "Hombre", "vcarlos139@gmail",
                    "646941737", "Sant Joan Despí", "Sospechoso"));
            casos.add(new Casos("02", "Claudia", "Rovira", "30/06/2000",
                    "20/04/2020", "medio", "Mujer", "crovirajimenez@gmail",
                    "652628176", "Sant Joan Despí", "No caso"));
            cv.añadirBrote("1", casos);
            cv.añadirBrote("2", casos);

        }
    }

    //Obtener la lista de los brotes
    @GET
    @ApiOperation(value = "Dame todos los brotes", notes = "Lista con todos los brotes")
    @ApiResponse(value = {
            @ApiResponse(code = 201, message = "Succesful", response = Brote.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @Path("/listabrotes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrotes(){
        List<Brote> brote = this.cv.listabrtote();
        GenericEntity<List<Brote>> entity = new GenericEntity<List<Brote>>(brote){};
        return Response.status(201).entity(entity).build();
    }

    //Lista de los brotes clasificado
    @GET
    @ApiOperation(value = "Dame todos los brotes clasificados ", notes = "Lista con todos los brotes clasificados")
    @ApiResponse(value = {
            @ApiResponse(code = 201, message = "Succesful", response = Brote.class, responseContainer = "List"),
    })
    @Path("/Clasificado/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClasificados(@PathParam("id")String id){
        List<Casos> casos = new LinkedList<>();
        if (id.isEmpty())
           return Response.status(500).entity(null).build();
        Brote br =cv.brote(id);
        if(br==null)
            return Response.status(500).entity(null).build();
        casos = cv.getlistaCasosBrote(id);
        GenericEntity<List<Casos>> entity = new GenericEntity<List<Casos>>(casos){};
        return Response.status(201).entity(entity).build();
    }

    //Añadir brote
    @POST
    @ApiOperation(value = "Añadir Brote", notes = "Añade brote a su respectiva lista")
    @ApiResponse(value = {
            @ApiResponse(code = 201, message = "Succesful", response = Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/AñadirBrote/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevobrote (@PathParam("id") String id){
        if (id.isEmpty())
            return Response.status(500).entity(new Brote()).build();
        this.cv.añadirBrote(id, new LinkedList<Casos>());
        return Response.status(201).entity(cv.brote(id)).build();
    }

    //Añadir un caso a un brote
    @PUT
    @ApiOperation(value = "Añadir caso", notes = "Añade casso a un brote")
    @ApiResponse(value = {
            @ApiResponse(code = 201, message = "Succesful", response = Brote.class),
            @ApiResponse(code = 500, message = "Validation Error"),
            @ApiResponse(code = 404, message =  "User/GameObject Not found error")
    })
    @Path("/AñadirCasoBrote/{bid}/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCasoBrote(@PathParam("id") String bid, @PathParam("id") String cid){
        if (bid.isEmpty() || cid.isEmpty())
            return Response.status(400).entity(new Brote()).build();
        else{
        }

    }






}

