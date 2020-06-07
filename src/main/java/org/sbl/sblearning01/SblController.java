package org.sbl.sblearning01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SblController {

    @GetMapping(value = "/")
    public String returnNothing()
    {
        return "Hello Spring Boot Application";
    }
}
