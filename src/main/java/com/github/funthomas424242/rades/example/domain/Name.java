package com.github.funthomas424242.rades.example.domain;

import javax.validation.constraints.NotNull;

@DomainObject
public class Name {

    @NotNull
    protected String wert;

    @Override
    public String toString(){
        return wert;
    }

}
