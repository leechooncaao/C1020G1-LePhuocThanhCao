package commons.validation;

import commons.exceptions.BirthDayException;
import commons.exceptions.EmailException;
import commons.exceptions.IdCardException;
import commons.exceptions.NameException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class CustomerValidator {
    public static void validateName(String name) throws NameException {
        name = name.trim();

        String regexName = "^([A-Z][a-z]+\\s*){2,}$";
        var pattern = Pattern.compile(regexName);
        var matcher = pattern.matcher(name);

        if (!matcher.find())
            throw new NameException("The first character in every letter must be uppercase !");

    }

    public static void validateEmail(String email) throws EmailException {
        email = email.trim();

        var emailRegex = "^[a-z][a-z0-9]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        var pattern = Pattern.compile(emailRegex);
        var matcher = pattern.matcher(email);

        if (!matcher.find())
            throw new EmailException("The email must be in format abcde@abc.xyz");
    }

    public static void validateIdCard(String id) throws IdCardException {
        var idRegex = "^\\d{3}\\s\\d{3}\\s\\d{3}$";

        var pattern = Pattern.compile(idRegex);
        var matcher = pattern.matcher(id.trim());

        if (!matcher.find())
            throw new IdCardException("The ID card must be in format 'XXX XXX XXX'");
    }

    public static void validateBirthDay(String birthDay) throws BirthDayException {
        validateBirthDayByFormat(birthDay);

        validateBirthDayByYear(birthDay);

        validateBirthDayByAge(birthDay);
    }

    private static void validateBirthDayByYear(String birthDay) throws BirthDayException {
        var year = Integer.parseInt(birthDay.substring(6));

        if (year <= 1900)
            throw new BirthDayException("Year must be equal than 1900");
    }

    private static void validateBirthDayByFormat(String birthDay) throws BirthDayException {
        var birthDayRegex = "^\\d{2}[/]\\d{2}[/]\\d{4}$";

        var pattern = Pattern.compile(birthDayRegex);
        var matcher = pattern.matcher(birthDay);

        if (!matcher.find())
            throw new BirthDayException("The birthday must be in format 'dd/mm/yyyy'");
    }

    private static void validateBirthDayByAge(String birthDay) throws BirthDayException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dayOfBirth = LocalDate.parse(birthDay, dateTimeFormatter);
        LocalDate toDay = LocalDate.now();

        if (dayOfBirth.isAfter(toDay))
            throw new BirthDayException("Future day not allowed !");
        else {
            int age = (int) ChronoUnit.YEARS.between(dayOfBirth, toDay);

            if (age < 18)
                throw new BirthDayException("Age must be equal or greater than 18");
        }
    }

}
