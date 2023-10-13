//package com.example.demo.validators;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class MinProductRangeValidator implements ConstraintValidator<ValidMinProductInRange, Integer> {
//
//    private int minProduct;
//    @Override
//    public void initialize(ValidMinProductInRange constraintAnnotation) {
//        this.minProduct = constraintAnnotation.minProduct();
//    }
//
//    @Override
//    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
//        if (value == null) {
//            return true;
//        }
//        return value >= minProduct;
//    }
//}
