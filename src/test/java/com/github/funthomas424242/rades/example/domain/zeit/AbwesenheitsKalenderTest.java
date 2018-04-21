package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.NameBuilder;
import com.github.funthomas424242.rades.example.domain.personal.Person;
import com.github.funthomas424242.rades.example.domain.personal.PersonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbwesenheitsKalenderTest {

    private AbwesenheitsKalender kalender;

    @BeforeEach
    public void setUp() {
        kalender = new AbwesenheitsKalender();
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

    }

}