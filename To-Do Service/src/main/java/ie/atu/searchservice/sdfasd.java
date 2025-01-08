package ie.atu.searchservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class sdfasd {
    @GetMapping("login")
    User getUserby(@PathVariable("id") Long id);



}
