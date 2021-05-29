package kodlamaio.hrms.core.mernis;

import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService {

    @Override
    public boolean isRealPerson(String nationalityIdentity, String firstName, String lastName, int yearOfBirth) {
        MernisManager mernisManager = new MernisManager();

        boolean result = mernisManager.ifValidPerson(firstName,lastName,nationalityIdentity,yearOfBirth);

        if(!result) {
            System.out.println("Geçersiz kullanıcı.");
            return false;
        }

        return true;
    }

    public boolean ifValidPerson(String firstName, String lastName, String nationalityIdentity, int yearOfBirth) {

        System.out.println( nationalityIdentity + " " + yearOfBirth + " " +firstName + " " + lastName +
                " geçerli kullanıcı.");
        return true;

    }
}
