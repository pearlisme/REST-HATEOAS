package com.pearl.spring.resource;


import com.pearl.spring.model.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserResource {


    @GetMapping("/all")
    public List<User> getAll() {

        User user1 = new User("Pearl", 50000L);
        User user2 = new User("Shara", 90000L);
        User user3 = new User("Meow", 20000L);
        User user4 = new User("Liel", 30000L);

        return Arrays.asList(user1, user2, user3, user4);
    }


    @GetMapping(value = "/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
    public List<User> getHateoasƒAll() {

        User user1 = new User("Pearl", 50000L);

        Link link1 = ControllerLinkBuilder.linkTo(UserResource.class)
                .slash(user1.getName())
                .withSelfRel();
        user1.add(link1);
        User user2 = new User("Shara", 90000L);

        Link link2 = ControllerLinkBuilder.linkTo(UserResource.class)
                .slash(user2.getName())
                .withSelfRel();

        Link link3 = ControllerLinkBuilder.linkTo(UserResource.class)
                .slash(user2.getSalary())
                .withRel("salary");

        user2.add(link2,link3);

        User user3 = new User("Meow", 20000L);
        User user4 = new User("Liel", 30000L);

        return Arrays.asList(user1, user2, user3, user4);
    }
}
