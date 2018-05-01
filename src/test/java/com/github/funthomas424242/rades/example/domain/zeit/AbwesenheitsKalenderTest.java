package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.Name;
import com.github.funthomas424242.rades.example.domain.NameBuilder;
import com.github.funthomas424242.rades.example.domain.firma.Team;
import com.github.funthomas424242.rades.example.domain.firma.TeamAccessor;
import com.github.funthomas424242.rades.example.domain.firma.TeamBuilder;
import com.github.funthomas424242.rades.example.domain.personal.Person;
import com.github.funthomas424242.rades.example.domain.personal.PersonAccessor;
import com.github.funthomas424242.rades.example.domain.personal.PersonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbwesenheitsKalenderTest {

    private AbwesenheitsKalender kalender;

    @BeforeEach
    public void setUp() {
        kalender = new AbwesenheitsKalenderBuilder().build();
    }


    @Test
    @DisplayName("Jahresurlaub einer Person als Abwesenheit")
    public void jahresUrlaubEinerPerson() {

        final PersonAccessor kathrin = new PersonBuilder()
                .withBirthday(Datum.of(13,4,1969))
                .withVorname(new NameBuilder().withWert("Kathrin").build())
                .withNachname(new NameBuilder().withWert("Musterfrau").build())
                .build(PersonAccessor.class);
        assertNotNull(kathrin);
        final Abwesenheit jahresurlaubKathrin = new AbwesenheitBuilder()
                .withGrund(Abwesenheit.Grund.URLAUB)
                .withZeitraum(new ZeitraumBuilder()
                        .withVon(Datum.of(1,7,2018))
                        .withBis(Datum.of(31,7,2018))
                        .build())
                .build();
        assertNotNull(jahresurlaubKathrin);
        kathrin.addAbwesenheit(jahresurlaubKathrin);
        assertEquals(1, kathrin.getAbwesenheiten().count());

        final Team team4 = new TeamBuilder().withTeamName(new NameBuilder().withWert("Team Schule").build()).build();
        final TeamAccessor team4Accessor = new TeamAccessor(team4);
        team4Accessor.addMitglied(kathrin.toPerson());

        final AbwesenheitsKalenderAccessor abwesenheitsKalenderAccessor = new AbwesenheitsKalenderAccessor(kalender);
        abwesenheitsKalenderAccessor.addTeam(team4);
        assertEquals(1, abwesenheitsKalenderAccessor.getTeams().count());

        kalender.printAbwesenheiten();

    }

    @Test
    @DisplayName("Jahresurlaub mehrere Personen mit Abwesenheiten.")
    public void jahresUrlaubMehrerePersonen() {
        final Team teamFreizeit = new TeamBuilder().withTeamName(Name.of("Team Freizeit")).build();
        final PersonAccessor johanna = new PersonBuilder()
                .withNachname(Name.of("Freundin"))
                .withVorname(Name.of("Johanna"))
                .withBirthday(Datum.of(13,2,1998))
                .build(PersonAccessor.class);
        final Abwesenheit urlaub = Abwesenheit.of(
                Abwesenheit.Grund.URLAUB,
                Zeitraum.of(Datum.of(01, 07, 2018), Datum.of(03, 07, 2018)));
        johanna.addAbwesenheit(urlaub);
        teamFreizeit.addMitglied(johanna.toPerson());
        final PersonAccessor liona = new PersonBuilder()
                .withNachname(Name.of("Lieblingsfrau"))
                .withVorname(Name.of("Liona"))
                .withBirthday(Datum.of(03,01,1987))
                .build(PersonAccessor.class);
        final Abwesenheit krankheit = Abwesenheit.of(
                Abwesenheit.Grund.KRANKHEIT
                , Zeitraum.of(Datum.of(01, 01, 2018), Datum.of(01, 02, 2018)));
        liona.addAbwesenheit(krankheit);
        liona.addAbwesenheit(urlaub);
        teamFreizeit.addMitglied(liona.toPerson());

        kalender.addTeam(teamFreizeit);
        kalender.printAbwesenheiten();

    }

}