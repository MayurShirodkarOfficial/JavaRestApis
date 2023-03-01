package controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/account")
@RequestScoped
public class AccountController {

    @Inject
    private AccountService accountService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Account getAccount(@PathParam("id") int id){
        return accountService.getAccountById(id);

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Account createAccount(Account account){
        return accountService.createAccount(account);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return Response.ok(accounts).build();
    }

    @PUT
    @Path("/{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAccount(@PathParam("accountId") int accountId, Account account) {
        Account updatedAccount = accountService.updateAccount(account);
        if (updatedAccount == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedAccount).build();
    }

    @DELETE
    @Path("/{accountId}")
    public Response deleteAccount(@PathParam("accountId") int accountId) {
        boolean deleted = accountService.deleteAccount(accountId);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }


    @Timed
    @GET
    @Path("/test")
    public String test() {
        return "Testing the interceptors ";
    }
}
