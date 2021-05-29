package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.mernis.MernisService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    //private Employer employer;
    //private JobSeeker jobSeeker;
    private EmployerService employerService;
    private JobSeekerService jobSeekerService;
    private VerificationService verificationService;
    private MernisService mernisService;

    @Autowired
    public AuthManager( EmployerService employerService,
                       JobSeekerService jobSeekerService, VerificationService verificationService,
                       MernisService mernisService) {
        //this.employer = employer;
        //this.jobSeeker = jobSeeker;
        this.employerService = employerService;
        this.jobSeekerService = jobSeekerService;
        this.verificationService = verificationService;
        this.mernisService = mernisService;
    }

    //employer
    @Override
    public Result registerEmployer(Employer employer) {
        if (!checkIfNullValueInEmployer(employer)) {

            return new ErrorResult("Tüm alanları doldurmalısınız.");

        }

        if (!checkEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {
            return new ErrorResult("Hatalı mail adresi. Mail adresinizi kontrol edin.");
        }

        if (!checkEmailExist(employer.getEmail())) {
            return new ErrorResult("Mail adresinizi kontrol edin.");

        }

        verificationService.sendEmail(employer.getEmail());
        employerService.add(employer);
        return new SuccessResult("İş veren kaydı tamamlandı.");

    }

    private boolean checkIfNullValueInEmployer(Employer employer) {

        if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null &&
                employer.getPhoneNumber() != null && employer.getPassword() != null) {
            return true;
        }
        return false;
    }

    private boolean checkEqualEmailAndDomain(String email, String website) {

        String[] emailArr = email.split("@", 2);
        String domain = website.substring(4, website.length());

        if (emailArr[1].equals(domain)) {
            return true;
        }
        return false;

    }

    private boolean checkEmailExist(String email) {

        if (this.employerService.getEmployerByEmail(email).getData() == null) {
            return true;
        }

        return false;

    }


    //job seeker
    @Override
    public Result registerJobSeeker(JobSeeker jobSeeker) {

        if(checkIfRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getNationalityId(),
                jobSeeker.getYearOfBirth()) == false) {
            return new ErrorResult("Doğrulama hatası.");
        }

        if(!checkNullValueInJobSeeker(jobSeeker)) {
            return new ErrorResult("Tüm alanları doldurun.");
        }

        if(!checkExistNationalityId(jobSeeker.getNationalityId())) {

            return new ErrorResult("Yanlış TC kimlik numarası girdiniz.");
        }

        if(!checkEmailExistInJobSeeker(jobSeeker.getEmail())) {

            return new ErrorResult("Yanlış mail adresi girdiniz.");

        }

        verificationService.sendEmail(jobSeeker.getEmail());
        jobSeekerService.add(jobSeeker);
        return new SuccessResult("İş arayan eklendi.");

    }
    private boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, int yearOfBirth) {

        if (mernisService.isRealPerson(nationalityId, firstName, lastName, yearOfBirth)) {
            return true;
        }
        return false;
    }

    private boolean checkNullValueInJobSeeker(JobSeeker jobSeeker) {

        if (jobSeeker.getFirstName() != null && jobSeeker.getLastName() != null &&
                jobSeeker.getNationalityId() != null) {
            return true;
        }
        return false;
    }

    private boolean checkExistNationalityId(String nationalityId) {
        if (jobSeekerService.getJobSeekerByNationalityId(nationalityId).getData() == null) {
            return true;
        }
        return false;
    }

    private boolean checkEmailExistInJobSeeker(String email) {

        if (this.jobSeekerService.getJobSeekerByEmail(email).getData() == null) {
            return true;
        }
        return false;
    }
}

