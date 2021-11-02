package com.company.parsingxml.builder;

import com.company.parsingxml.entity.Tariffs;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTariffsBuilder {
    protected Set<Tariffs> tariffs;

    public AbstractTariffsBuilder(){
        tariffs=new HashSet<Tariffs>();
    }

    public AbstractTariffsBuilder(Set<Tariffs> tariffs){
        this.tariffs=tariffs;
    }

    public Set<Tariffs> getTariffs() {
        return tariffs;
    }

    public abstract void buildTariffs(String path);
}
