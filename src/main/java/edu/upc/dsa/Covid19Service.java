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
import java.util.List;

@Api(value = "/covid19", description = "Endpoint")
@Path("/covid19service")
public class Covid19Service {
    private Covid19Manager cv;

    public Covid19Service() {
        this.cv = Covid19ManagerImpl.getInstance();

        if(cv.sizeBrote()==0){
        }
    }
    @GET
    @ApiOperation(value = "Dame todos los brotes")
    @ApiResponse(value = {
            @ApiResponse(code = 201, message = "Succesful", response = Brote.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @Path("/listabrotes")

}
