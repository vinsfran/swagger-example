package com.example.swaggerexample.mapper;

import com.example.swaggerexample.mapper.provider.RhmpersoProvider;
import com.example.swaggerexample.model.Rhmperso;
import java.util.List;
import javax.websocket.server.PathParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface RhmpersoMapper {

    @Results(id = "rhmpersoResult", value = {
        @Result(property = "codPerson", column = "cod_person")
        ,
        @Result(property = "apePerson", column = "ape_person")
        ,
        @Result(property = "nomPerson", column = "nom_person")
        ,
        @Result(property = "fecIngins", column = "fec_ingins")
    })
    @Select("select * from rhmperso")
    List<Rhmperso> findAll();

    @ResultMap("rhmpersoResult")
//    @Select("SELECT * FROM producci.rhmperso WHERE cod_person = #{codPerson}")
    @SelectProvider(type = RhmpersoProvider.class, method = "find")
    List<Rhmperso> findCodPerson(String codPerson);
//    List<Rhmperso> findCodPerson(@PathParam("codPerson") final String codPerson);

}
