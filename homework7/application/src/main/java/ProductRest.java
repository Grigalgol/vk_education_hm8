import com.electronwill.nightconfig.core.conversion.Path;
import com.google.inject.Inject;
import entity.Product;
import org.codehaus.jackson.map.ObjectMapper;
import service.DataManager;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductRest {
    @Inject
    private ObjectMapper objectMapper;
    @Inject
    private DataManager dataManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response
                .ok(dataManager.getAllProducts())
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .build();
    }

    @POST
    public Response post(@QueryParam("product_name") String productName) {
        boolean isDelete = dataManager.deleteProductByName(productName);
        if (isDelete) return Response.ok().build();
        return Response.status(404).build();
    }

//    @POST
//    @Produces(MediaType.TEXT_PLAIN)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String save(Product product) {
//        return dataManager.saveProduct(product.getName(), product.getName(), product.getCount());
//    }
}
