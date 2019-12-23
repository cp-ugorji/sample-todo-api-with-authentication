/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.controllers;

import com.technologyz.stealth.models.LoginRequest;
import com.technologyz.stealth.models.LoginResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chukwudi Ugorji
 */
@RestController
@RequestMapping("/api/auth")//RequestMapping tells springboot that the parameter "/api/auth" 
//should start the url of all endpoints in this controller i.e http://domain:port/api/auth"
@CrossOrigin(origins = "http://localhost:4200")
@Api(value="Basic Authentication", description="Operations relating to basic authentication")
public class BasicAuthenticationController {
    //we want this endpoint to be login for posting and verifying login
    //but because of the RequestMapping annotation on the controller,
    //this endpoint will look like http://domain:port/api/auth/login"
    @PostMapping("/login")
    //swagger documentation of what the login endpoint does and educating users of the response expected
    @ApiOperation(value = "Authenticate all users using basic authentication, username and password", response = LoginResponse.class)
    //adding other possible response on success, failure, error e.t.c
//@ApiResponses(value = {
//    @ApiResponse(code = 200, message = "Successfully retrieved list"),
//    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//})
    public LoginResponse login(
            //swagger documentation to describe the request parameter and if it is required/mandatetory
            @ApiParam(value = "Login object for user authentication", required = true)
            @RequestBody LoginRequest login)
    {
        LoginResponse lResp = new LoginResponse(null, "You are authenticaed");
        return lResp;
    }
}
