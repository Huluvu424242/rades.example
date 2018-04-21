package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.DomainObject;
import com.github.funthomas424242.rades.example.domain.firma.Team;
import com.github.funthomas424242.rades.example.domain.firma.TeamAccessor;
import com.github.funthomas424242.rades.example.domain.personal.PersonAccessor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@DomainObject
public class AbwesenheitsKalender {

    @NotNull
    protected Set<Team> teams;


    public void printAbwesenheiten() {
        final StringBuffer buf = new StringBuffer();
        teams.forEach(team -> {
            final TeamAccessor curTeam = new TeamAccessor(team);
            buf.append(curTeam.getTeamName() + "\n");
            curTeam.getMitglieder().forEach(person -> {
                final PersonAccessor curPerson = new PersonAccessor(person);
                buf.append(curPerson.getNachname() + ", " + curPerson.getVorname());
                // TODO Abwesenheiten
            });
        });
        System.out.println(buf.toString());
    }
}
