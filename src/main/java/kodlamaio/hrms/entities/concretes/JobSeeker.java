package kodlamaio.hrms.entities.concretes;



import kodlamaio.hrms.entities.abstracts.User;
import lombok.*;

import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "job_seekers")

@PrimaryKeyJoinColumn(name = "user_id")

public class JobSeeker extends User {





    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "nationality_id")
    private String nationalityId;


    @Column(name = "year_of_birth")
    private int yearOfBirth;
}
