package com.github.funthomas424242.rades.example.domain.personal;


import com.github.funthomas424242.rades.annotations.accessors.RadesNoAccessor;
import com.github.funthomas424242.rades.annotations.builder.RadesNoBuilder;
import com.github.funthomas424242.rades.example.domain.DomainObject;
import com.github.funthomas424242.rades.example.domain.Name;
import com.github.funthomas424242.rades.example.domain.zeit.Abwesenheit;
import com.github.funthomas424242.rades.example.domain.zeit.Datum;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@DomainObject
public final class Person {

    @NotNull
    protected Datum birthday;

    @NotNull
    protected Name nachname;

    @NotNull
    protected Name vorname;

    @RadesNoAccessor
    @RadesNoBuilder
    protected List<Abwesenheit> abwesenheiten = new ArrayList<>();

    protected Person(){}

    public int berechneAlter() {
        return this.berechneAlterZum(
                Datum.fromLocalDate(LocalDate.now()));
    }

    public int berechneAlterZum(final Datum datum) {
        if (datum == null) {
            throw new IllegalArgumentException("Es wird ein Datum zur Berechnung benötigt.");
        }
        final Period period
                = birthday.toLocalDate().until(datum.toLocalDate());
        return period.getYears();
    }

    public Stream<Abwesenheit> getAbwesenheiten() {
        return abwesenheiten.stream();
    }

    public void addAbwesenheit(final Abwesenheit abwesenheit){
        this.abwesenheiten.add(abwesenheit);
    }


    @Override
    public String toString() {
        return nachname + ", " + vorname;
    }

}
