package com.no_country.salud_vital.mapper;

public interface Mapper<A,B> {

    B mapTo(A a);

    A mapFrom(B b);
}