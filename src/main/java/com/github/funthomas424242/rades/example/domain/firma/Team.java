package com.github.funthomas424242.rades.example.domain.firma;

import com.github.funthomas424242.rades.example.domain.DomainObject;
import com.github.funthomas424242.rades.example.domain.Name;
import com.github.funthomas424242.rades.example.domain.personal.Person;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@DomainObject
public final class Team {

    @NotNull
    protected Name teamName;

    // TODO die Buildermethode withMitglieder sollte nicht genutzt werden.
    // @RadesNoBuilder - die komplette Liste soll nicht tauschbar sein
    // @RadesNoAccessor - die Liste darf nur herausgegeben werden, wenn sie immutable ist
    protected Set<Person> mitglieder = new HashSet<>();

    protected Team(){}

    public void addMitglied(final Person person){
        mitglieder.add(person);
    }

    public Stream<Person> getMitglieder(){
        return mitglieder.stream();
    }

    public void entferneMitglied(final Person person){
        mitglieder.remove(person);
    }

}
