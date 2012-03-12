package fr.okiwi.mongolink.mapping;

import fr.okiwi.mongolink.Sujet;
import org.mongolink.domain.mapper.ComponentMap;

public class SujetMapping extends ComponentMap<Sujet>{
    
    public SujetMapping() {
        super(Sujet.class);
    }

    @Override
    protected void map() {
        property(element().getNom());
    }
}
