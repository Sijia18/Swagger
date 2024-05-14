package com.develhope.proveSpringBoot;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Tag(name = "Reverse Name", description = "how reverse a name")
public class Controller {

    @Autowired
    Service service;

    @Operation(summary = "Get a name", description = "Returns a name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "301", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "The name is not found")
    })
    @GetMapping("/name")
    public String getName(@RequestParam @Parameter(name = "name", description = "Return the Name passed" ) String name) {
        return name;
    }

    @Operation(summary = "Reverse a name", description = "Returns a reverse name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully reversed"),
            @ApiResponse(responseCode = "406", description = "The name is not reversed")
    })
    @PostMapping("/reverseName")
    public String reverseName(@RequestBody String name) {
        return service.reverseString(name);
    }
}