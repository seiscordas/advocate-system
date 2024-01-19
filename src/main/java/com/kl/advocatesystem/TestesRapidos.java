//package com.kl.advocatesystem;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//public class TestesRapidos {
//
//    static SecurityContext context = SecurityContextHolder.getContext();
//    static Authentication authentication = context.getAuthentication();
//
//    static Authentication authenticationOtherWay = SecurityContextHolder.getContext().getAuthentication();
//    //Jwt owner = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//    public static void main(String[] args) {
//
//        System.out.println(authenticationOtherWay);
//
//        String[] arrEstados = {"PR", "SP", "SC"};
//        String[] arrCidCodigos = {"1", "3", "6"};
//
//        String cidCodigos = String.join(",", arrCidCodigos);
//
//        String estados =  unirStringEntreAspasComVirgula(arrEstados);
//
//        System.out.println("cidCodigos: " + cidCodigos);
//        System.out.println("estados: " + estados);
//
//        testeDataLocalDateInstant();
//    }
//
//    private static void testeDataLocalDateInstant() {
//        Instant now = Instant.now();
//        LocalDate localDate = LocalDate.now();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println("now: " + now); //now: 2023-10-12T22:43:21.487464133Z
//        System.out.println("localDate: " + localDate); //localDate: 2023-10-12
//        System.out.println("localDateTime: " + localDateTime); //localDateTime: 2023-10-12T19:43:21.662118849
//    }
//
//    public static void unirCidadeComVirgula(String[] arrCidCodigos){
//        String resultado = String.join(",", arrCidCodigos);
//        System.out.println(resultado);
//    }
//    public static String unirStringEntreAspasComVirgula(String[] arrEstados){
//        StringBuilder resultado = new StringBuilder();
//
//        for (int i = 0; i < arrEstados.length; i++) {
//            resultado.append("'").append(arrEstados[i]).append("'");
//
//            if (i < arrEstados.length - 1) {
//                resultado.append(",");
//            }
//        }
//
//        return resultado.toString();
//    }
//}
