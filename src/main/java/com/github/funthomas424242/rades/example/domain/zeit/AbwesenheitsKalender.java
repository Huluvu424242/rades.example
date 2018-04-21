package com.github.funthomas424242.rades.example.domain.zeit;

import com.github.funthomas424242.rades.example.domain.firma.Team;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class AbwesenheitsKalender {

    @NotNull
    protected Set<Team> teams;


}
