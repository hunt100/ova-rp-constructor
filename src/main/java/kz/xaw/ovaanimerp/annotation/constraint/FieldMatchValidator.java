package kz.xaw.ovaanimerp.annotation.constraint;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(FieldMatch constraint) {
        firstFieldName = constraint.first();
        secondFieldName = constraint.second();
    }

    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            Object first = BeanUtils.getProperty(obj, firstFieldName);
            Object second = BeanUtils.getProperty(obj, secondFieldName);

            return Objects.equals(first, second);
        } catch (final Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
