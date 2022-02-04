package zw.co.lws.livestockwebservice.domain;

import lombok.*;
import zw.co.lws.livestockwebservice.domain.enums.Role;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String username;
    private String password;
}
