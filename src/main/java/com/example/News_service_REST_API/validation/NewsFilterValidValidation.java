package com.example.News_service_REST_API.validation;

import com.example.News_service_REST_API.web.model.filter.NewsFilter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;


public class NewsFilterValidValidation implements ConstraintValidator<NewsFilterValid, NewsFilter> {

    @Override
    public boolean isValid(NewsFilter value, ConstraintValidatorContext constraintValidatorContext) {
        return !ObjectUtils.anyNull(value.getPageNumber(), value.getPageSize());
    }
}
