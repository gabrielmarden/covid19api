package br.com.nedramdev.covid19api.controller;

import br.com.nedramdev.covid19api.model.Users;
import br.com.nedramdev.covid19api.repository.UserRepository;
import br.com.nedramdev.covid19api.util.Const;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Secured(Const.ROLE_ADMIN)
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Users user){
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Secured({Const.ROLE_USER, Const.ROLE_ADMIN})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<Users>> list(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return new ResponseEntity<Page<Users>>(userRepo.findAll(pageable), HttpStatus.OK);
    }

}
