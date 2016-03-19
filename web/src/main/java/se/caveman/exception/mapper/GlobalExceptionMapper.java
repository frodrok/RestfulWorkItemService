package se.caveman.exception.mapper;

import org.omg.SendingContext.RunTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GlobalExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException e) {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(e.getMessage()).build();
    }
}
