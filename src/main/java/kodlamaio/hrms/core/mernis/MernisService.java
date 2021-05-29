package kodlamaio.hrms.core.mernis;

public interface MernisService {

    boolean isRealPerson(String nationalityIdentity, String firstName, String lastName, int yearOfBirth);
}
