package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systememployees")
public class SystemEmployeesController {

    private SystemEmployeeService systemEmployeeService;

    @Autowired
    public SystemEmployeesController(SystemEmployeeService systemEmployeeService) {
        super();
        this.systemEmployeeService = systemEmployeeService;
    }

	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployee systemEmployee){
		return this.systemEmployeeService.add(systemEmployee);
	}


    @GetMapping("/getall")
    public DataResult<List<SystemEmployee>> getAll(){
        return this.systemEmployeeService.getAll();
    }
}
