package com.nowherelearn.postservice.api;

import java.security.Principal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity(prePostEnabled = true)
public class PostController {
    @GetMapping("/posts")
    @PreAuthorize("hasAuthority('SCOPE_message.read') ")
    public String getPosts() {
        return "List of posts";
    }

    @GetMapping("/test")
    public String test(Principal principal) {
        return principal.getName();
    }
}
