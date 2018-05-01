package com.github.funthomas424242.rades.example.domain;

import javax.validation.constraints.NotNull;

@DomainObject
public class Name {

    @NotNull
    protected String wert;


    public static  Name of(final String name){
        return new NameBuilder().withWert(name).build();
    }


    @Override
    public String toString(){
        return wert;
    }



}
