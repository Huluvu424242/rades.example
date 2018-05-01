package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.DomainObject;

import javax.validation.constraints.NotNull;

@DomainObject
public class Abwesenheit {

    public enum Grund {
        URLAUB,
        KRANKHEIT,
        ONBOARDING,
        ROLLOFF,
        SONSTIGES
    }

    @NotNull
    protected Zeitraum zeitraum;

    @NotNull
    protected Grund grund;


    public static Abwesenheit of(final Grund grund, final Zeitraum zeitraum) {
        return new AbwesenheitBuilder().withGrund(grund).withZeitraum(zeitraum).build();
    }

    @Override
    public String toString() {
        return grund.name().substring(0, 1) + zeitraum;
    }
}
