package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager( JobTitleDao jobTitleDao){
        this.jobTitleDao=jobTitleDao;
    }

   /* @Override
    public List<JobTitle> getAll() {
        return this.jobTitleDao.findAll();
    } */

    @Override
    public Result add(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("İş pozisyonu eklendi.");
    }

    @Override
    public Result update(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("İş pozisyonu güncellendi.");
    }

    @Override
    public Result delete(JobTitle jobTitle) {
        this.jobTitleDao.delete(jobTitle);
        return new SuccessResult("İş pozisyonu silindi.");
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
    }

    @Override
    public DataResult<JobTitle> getByJobTitle(String title) {
        return new SuccessDataResult<JobTitle>(this.jobTitleDao.findByTitle(title));
    }

}
