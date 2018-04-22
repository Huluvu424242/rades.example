package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.DomainObject;
import com.github.funthomas424242.rades.example.domain.firma.Team;
import com.github.funthomas424242.rades.example.domain.firma.TeamAccessor;
import com.github.funthomas424242.rades.example.domain.personal.PersonAccessor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@DomainObject
public final class AbwesenheitsKalender {

    @NotNull
    protected Set<Team> teams;

    protected AbwesenheitsKalender(){};

    public void printAbwesenheiten() {
        final StringBuffer buf = new StringBuffer();

        // Teams
        teams.forEach(team -> {
            final TeamAccessor curTeam = new TeamAccessor(team);
            buf.append(curTeam.getTeamName());

            // Mitglieder
            curTeam.getMitglieder().forEach(person -> {
                buf.append("\n "+person +": ");

                // Abwesenheiten
                final PersonAccessor curPerson = new PersonAccessor(person);
                curPerson.getAbwesenheiten().forEach(abwesenheit -> {
                    buf.append(" "+abwesenheit+" ");
                });
            });
        });
        System.out.println("Abwesenheiten:\n"+buf.toString());
    }
}
