package kodlamaio.hrms.entities.abstracts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="email")
    private String email;


    @Column(name="password")
    private String password;


}
