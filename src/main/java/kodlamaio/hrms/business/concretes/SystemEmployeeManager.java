package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

    private SystemEmployeeDao systemEmployeeDao;
    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
        this.systemEmployeeDao = systemEmployeeDao;
    }

    @Override
    public Result add(SystemEmployee systemEmployee) {
        this.systemEmployeeDao.save(systemEmployee);
        return new SuccessResult("Sistem çalışanı eklendi.");
    }


    @Override
    public DataResult<List<SystemEmployee>> getAll() {
        return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll());
    }
}
