package com.example.swaggerexample.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class RhmpersoProvider {

    private static final String TABLE_NAME = "rhmperso";

    public String find(final String codPerson) {

        String sql1 = "SELECT * FROM " + TABLE_NAME + " WHERE cod_person = " + codPerson;

        StringBuilder querySelect = new StringBuilder("SELECT * FROM " + TABLE_NAME + " ");
//        querySelect.append("WHERE cod_person = ");
        querySelect.append("WHERE cod_person LIKE '%");
        querySelect.append(codPerson);
        querySelect.append("%'");

        return querySelect.toString();

//                new SQL() {
//            {
//                SELECT("*");
//                FROM(TABLE_NAME);
//                if (!StringUtils.isEmpty(codPerson)) {
//                    WHERE("cod_person = #{codPerson}");
//                }
//            }
//        }.toString();
    }

}
