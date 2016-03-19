package se.caveman.http;

import se.caveman.model.jpa.JpaUser;
import se.caveman.model.xml.XmlUser;
import se.caveman.service.DatabaseHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/***************
 * GET /user all users
 * GET /user/NR one user
 * POST /user create user
 * PUT /user update
 * DELETE /user delete user
 ***************/

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public final class HTTPService {

    private final DatabaseHandler database = new DatabaseHandler();

    @Context
    private UriInfo uriInfo;

    @POST
    @Path("/user")
    public Response postUser(XmlUser user) {
        if (user == null) {
            throw new RuntimeException("retrieved user was null");
        }

        JpaUser jpaUser = new JpaUser(user.getUsername(), user.getPassword());
        JpaUser saved = database.save(jpaUser);

        if (saved == null) {
            throw new WebApplicationException("saved user is null");
        }

        URI createdLocation = uriInfo.getAbsolutePathBuilder().path(XmlUser.class, "getUser").build(saved.getId());

        return Response.created(createdLocation).build();
    }

    @GET
    @Path("/user/{id}")
    public Response getUser(@PathParam("id") Long id) {
        JpaUser retrieved = database.findUser(id);
        XmlUser xmlConvert = new XmlUser(retrieved.getId(), retrieved.getUsername(), retrieved.getPassword());

        return Response.ok(xmlConvert).build();
    }

    @GET
    @Path("/exampleuser")
    public Response exampleUser() {
        XmlUser user = new XmlUser(1L, "fredrik", "hollinger");
        return Response.ok(user).build();
    }
}
