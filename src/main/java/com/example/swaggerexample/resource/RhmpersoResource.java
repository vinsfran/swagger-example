package com.example.swaggerexample.resource;

import com.example.swaggerexample.mapper.RhmpersoMapper;
import com.example.swaggerexample.model.Rhmperso;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/personas")
public class RhmpersoResource {

    private RhmpersoMapper rhmpersoMapper;

    public RhmpersoResource(RhmpersoMapper rhmpersoMapper) {
        this.rhmpersoMapper = rhmpersoMapper;
    }

    @GetMapping("/all")
    public List<Rhmperso> getAll() {
        return rhmpersoMapper.findAll();
    }

    @GetMapping("/{codPerson}")
    public List<Rhmperso> getByCodPerson(@PathVariable("codPerson") final String codPerson) {
        return rhmpersoMapper.findCodPerson(codPerson);
    }
}
