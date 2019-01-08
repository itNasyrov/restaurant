/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package restaurant.swagger.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-02T23:40:43.246+05:00")

@Api(value = "create", description = "the create API")
public interface CreateApi {

    @ApiOperation(value = "createTable", notes = "", response = String.class, tags={ "app-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @ApiResponse(code = 404, message = "Not Found", response = Void.class) })
    
    @RequestMapping(value = "/create",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    default ResponseEntity<String> createTableUsingGET() {
        // do some magic!
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}