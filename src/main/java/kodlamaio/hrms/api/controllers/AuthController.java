package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private  AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/registeremployer")
    public Result registerEmployer(@RequestBody Employer employer) {

        return authService.registerEmployer(employer);
    }

    @PostMapping("/registerjobseeker")
    public Result registerJobSeeker(@RequestBody JobSeeker jobSeeker) {

        return authService.registerJobSeeker(jobSeeker);

    }


}


