package kodlamaio.hrms.core.verification;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VerificationManager implements VerificationService {


    @Override
    public Result sendEmail(String email) {
        return new SuccessResult("Mailinize doğrulama maili gönderildi." + email +
                "\n Maildeki linke tıklayarak hesabınızı doğrulamalısınız.");
    }
}
