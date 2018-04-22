package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.DomainObject;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@DomainObject
public class Datum {

    @NotNull
    protected int jahr;

    @NotNull
    protected int monat;

    @NotNull
    protected int tag;

    public LocalDate toLocalDate() {
        return LocalDate.of(jahr, monat, tag);
    }

    public static Datum fromLocalDate(final LocalDate date) {
        return new DatumBuilder()
                .withJahr(date.getYear())
                .withMonat(date.getMonthValue())
                .withTag(date.getDayOfMonth())
                .build();
    }

    @Override
    public String toString(){
        return tag + "."+monat+"."+jahr;
    }

}
