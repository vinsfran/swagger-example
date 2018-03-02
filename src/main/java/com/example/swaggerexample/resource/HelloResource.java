package com.example.swaggerexample.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
@Api(value = "Hello World Resource REST EndPoint", description = "Shows the Hello World info")
public class HelloResource {

    @ApiOperation(value = "Returns Hello world")
    @ApiResponses(
            value = {
                @ApiResponse(code = 100, message = "100 is the message")
                ,
                @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )
    @GetMapping
    public String hello() {
        return "Hello world";
    }

    @ApiOperation(value = "Returns Hello world Post")
    @PostMapping()
    public String helloPost(@RequestBody final String hello) {
        return hello;
    }

    @ApiOperation(value = "Returns Hello world Put")
    @PutMapping()
    public String helloPut(@RequestBody final String hello) {
        return hello;
    }
}
