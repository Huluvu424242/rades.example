package com.github.funthomas424242.rades.example.domain.zeit;

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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbwesenheitsKalenderTest {

    private AbwesenheitsKalender kalender;

    @BeforeEach
    public void setUp() {
        kalender = new AbwesenheitsKalenderBuilder()
        .withTeams(new HashSet<Team>())
        .build();
    }


    @Test
    @DisplayName("Jahresurlaub einer Person als Abwesenheit")
    public void jahresUrlaubEinerPerson() {

        final Datum birthdayKathrin = new DatumBuilder().withJahr(1969).withMonat(4).withTag(13).build();
        assertNotNull(birthdayKathrin);
        final Person kathrin = new PersonBuilder()
                .withBirthday(birthdayKathrin)
                .withVorname(new NameBuilder().withWert("Kathrin").build())
                .withNachname(new NameBuilder().withWert("Musterfrau").build())
                .build();
        assertNotNull(kathrin);
        final Abwesenheit jahresurlaubKathrin = new AbwesenheitBuilder()
                .withGrund(Abwesenheit.Grund.URLAUB)
                .withZeitraum( new ZeitraumBuilder()
                        .withVon(new DatumBuilder().withJahr(2018).withMonat(7).withTag(1).build())
                        .withBis(new DatumBuilder().withJahr(2018).withMonat(7).withTag(31).build())
                        .build())
                .build();
        assertNotNull(jahresurlaubKathrin);
        final PersonAccessor kathrinAccessor=new PersonAccessor(kathrin);
        final Person kathrinMusterfrau = new PersonBuilder(kathrin)
                .withAbwesenheiten(new ArrayList<Abwesenheit>())
                .build();
        kathrinAccessor.getAbwesenheiten().add(jahresurlaubKathrin);
        assertEquals(1,kathrinAccessor.getAbwesenheiten().size());

        final Team team4 = new TeamBuilder().withTeamName(new NameBuilder().withWert("Team 4").build()).withMitglieder(new HashSet<Person>()).build();
        final TeamAccessor team4Accessor = new TeamAccessor(team4);
        team4Accessor.getMitglieder().add(kathrinMusterfrau);

        final AbwesenheitsKalenderAccessor abwesenheitsKalenderAccessor = new AbwesenheitsKalenderAccessor(kalender);
        abwesenheitsKalenderAccessor.getTeams().add(team4);
        assertEquals(1,abwesenheitsKalenderAccessor.getTeams().size());

        kalender.printAbwesenheiten();

    }

}