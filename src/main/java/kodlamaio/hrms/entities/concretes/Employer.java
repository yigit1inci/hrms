package kodlamaio.hrms.entities.concretes;


import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor


@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "employers")

@PrimaryKeyJoinColumn(name = "user_id")

public class Employer extends User {





    @Column(name = "company_name")
    private String companyName;


    @Column(name = "website")
    private String website;


    @Column(name = "phone_number")
    private String phoneNumber;

}

