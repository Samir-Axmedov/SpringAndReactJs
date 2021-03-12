package com.aptek.pharm.Unique;
import com.aptek.pharm.Validation.UniqueUsernameValidation;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueUsernameValidation.class})
public @interface UniqueUsername {
    String message() default "{pharm.constraints.displayName.UniqueUsername.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
