package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.DomainObject;

import javax.validation.constraints.NotNull;
import java.time.Period;

@DomainObject
public final class Zeitraum {

    @NotNull
    protected Datum von;

    @NotNull
    protected Datum bis;

    protected Zeitraum(){}

    public Period toPeriod(){
        return von.toLocalDate().until(bis.toLocalDate());
    }

    @Override
    public String toString(){
        return "[" + von + " - "+bis +"]";
    }
}
