package User.System.system.models;

import User.System.system.constants.TextConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;

public class UserPasswordTests {

    private User user;
    private ValidatorFactory factory;
    private Validator validator;
    private final String SHORT_PASSWORD = "ABC";
    private final String LONG_PASSWORD = "A".repeat(51);
    private final String ERROR_MESSAGE = "Violation message doesn't match constant message";

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void passwordIsTooShort() {
        user.setPassword(SHORT_PASSWORD);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        violations.forEach(
                violation -> {
                    if (violation.getPropertyPath().toString().equals("password")) {
                        Assert.assertEquals(
                                ERROR_MESSAGE,
                                0,
                                violation.getMessage().compareTo(TextConstants.PASSWORD_TOO_SHORT));
                    }
                });
    }

    @Test
    public void passwordIsTooLong() {
        User user = new User();
        user.setPassword(LONG_PASSWORD);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        violations.forEach(
                violation -> {
                    if (violation.getPropertyPath().toString().equals("password")) {
                        Assert.assertEquals(
                                ERROR_MESSAGE,
                                0,
                                violation.getMessage().compareTo(TextConstants.PASSWORD_TOO_LONG));
                    }
                });
    }
}
