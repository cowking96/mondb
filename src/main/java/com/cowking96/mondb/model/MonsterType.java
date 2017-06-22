package com.cowking96.mondb.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum MonsterType {
    HUMANOID,
    UNDEAD,
    ABERRATION,
    FIEND,
    ELEMENTAL,
    CELESTIAL,
    BEAST,
    CONSTRUCT,
    DRAGON,
    GIANT,
    MONSTROSITY,
    PLANT,
    FEY,
    OOZE,
    NPC,
    SWARM,
    NONE;
}
