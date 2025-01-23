package org.testProject.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.testProject.model.Cucumber;
import org.testProject.service.CucumberService;

import java.util.List;

@Path("/cucumber")
public class CucumberController {

    private CucumberService cucumberService;

    @Inject
    public CucumberController(CucumberService cucumberService) {
        this.cucumberService = cucumberService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cucumber> getCucumbers(@QueryParam("q") int quantity) {
        return cucumberService.getCucumbers(quantity);
    }
}
