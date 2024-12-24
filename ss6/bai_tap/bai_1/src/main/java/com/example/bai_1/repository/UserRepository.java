package com.example.bai_1.repository;

import com.example.bai_1.model.User;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Constraint(validatedBy = ValidEmailValidator.class)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidEmail {
        String message() default "Email already used";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    @Component
    public class ValidEmailValidator implements ConstraintValidator<UserRepository.ValidEmail, String> {
        @Autowired
        private final UserRepository userRepository;
        public ValidEmailValidator(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
        @Override
        public boolean isValid(String email, ConstraintValidatorContext context) {
            if (userRepository.findByEmail(email).isPresent()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("This email is already registered.")
                        .addConstraintViolation();
                return false;
            }
            return true;
        }
    }
    Optional<User> findByEmail(String email);
}
