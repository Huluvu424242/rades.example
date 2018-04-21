package com.github.funthomas424242.rades.example.domain;


import com.github.funthomas424242.rades.annotations.accessors.RadesAddAccessor;
import com.github.funthomas424242.rades.annotations.builder.RadesAddBuilder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
@RadesAddAccessor
@RadesAddBuilder
public @interface DomainObject {
}
