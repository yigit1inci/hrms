package kodlamaio.hrms.entities.concretes;



import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "system_employees")

@PrimaryKeyJoinColumn(name = "user_id")

public class SystemEmployee extends User {


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "nationality_id")
    private String nationalityId;


    @Column(name = "year_of_birth")
    private LocalDate yearOfBirth;
}

