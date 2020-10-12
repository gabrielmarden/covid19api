package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public Users(String name, String email){
        super();
        this.name = name;
        this.email = email;
    }

    public Users(Users user){
        super();
        this.name = user.getName();
        this.email = user.getEmail();
        this.id = user.getId();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public Users(String name, String email, String password, List<Role> roles){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
