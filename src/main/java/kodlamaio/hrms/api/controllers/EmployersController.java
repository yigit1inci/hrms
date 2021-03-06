package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")

public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerService.add(employer);
    }

	@PostMapping("/update")
	public Result update(@RequestBody Employer employer){
		return this.employerService.update(employer);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Employer employer){
		return this.employerService.delete(employer);
	}

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

}
