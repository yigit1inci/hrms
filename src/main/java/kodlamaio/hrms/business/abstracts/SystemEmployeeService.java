package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

import java.util.List;

public interface SystemEmployeeService {

    Result add(SystemEmployee systemEmployee);

    DataResult<List<SystemEmployee>> getAll();
}
