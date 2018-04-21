package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.DomainObject;

import javax.validation.constraints.NotNull;
import java.time.Period;

@DomainObject
public class Abwesenheit {

    public enum Grund {
        URLAUB,
        KRANKHEIT,
        ROLLOFF,
        ROLLON,
        UNSPEZIFISCH
    }

    @NotNull
    protected Period periode;

    @NotNull
    protected Grund grund;
}
