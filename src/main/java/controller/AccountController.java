package controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/account")
@RequestScoped
public class AccountController {

    @Inject
    private AccountService accountservice;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Account getAccount(@PathParam("id") int id){
        return accountservice.getAccountById(id);

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Account createAccount(Account account){
        return accountservice.createAccount(account);
    }
}
