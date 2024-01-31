package com.challengepay.challengepay.infra.config.db.schema;

import java.util.UUID;

import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.entity.user.model.UserType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class UserSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique=true)
    private String document;

    @Column(nullable = false, unique=true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserSchema(String name, String document, String email, String password, UserType userType) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public UserSchema(User user) {
        this.name = user.getName();
        this.document = user.getDocument();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.userType = user.getUserType();
    }

    public User toUser() {
        User user = new User (
                this.getName(),
                this.getDocument(),
                this.getEmail(),
                this.getPassword(),
                this.getUserType()
        );
        user.setId(this.getId());
        return user;
      }

}
