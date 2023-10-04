package com.kl.advocatesystem;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestesRapidos {
    public static void main(String[] args) {

        Instant now = Instant.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("now: " + now);
        System.out.println("localDate: " + localDate);
        System.out.println("localDateTime: " + localDateTime);

    }
}
