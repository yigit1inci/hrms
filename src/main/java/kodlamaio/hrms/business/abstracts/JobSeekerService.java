package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    Result add(JobSeeker jobSeeker);
	Result update(JobSeeker jobSeeker);
	Result delete(JobSeeker jobSeeker);

    DataResult<List<JobSeeker>> getAll();

    DataResult<JobSeeker> getJobSeekerByNationalityId(String nationalityId);
    DataResult<JobSeeker> getJobSeekerByEmail(String email);
}
