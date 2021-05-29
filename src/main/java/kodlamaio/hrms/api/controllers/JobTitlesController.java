package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {

    private JobTitleService jobTitleService;


    @Autowired
    public JobTitlesController(JobTitleService jobTitleService)
    {
        this.jobTitleService=jobTitleService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.add(jobTitle);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.update(jobTitle);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.delete(jobTitle);
    }


    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }
}
