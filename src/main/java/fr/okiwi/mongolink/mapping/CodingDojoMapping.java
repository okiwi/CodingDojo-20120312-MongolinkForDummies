package fr.okiwi.mongolink.mapping;

import fr.okiwi.mongolink.CodingDojo;
import org.mongolink.domain.mapper.EntityMap;

public class CodingDojoMapping extends EntityMap<CodingDojo>{

    public CodingDojoMapping() {
        super(CodingDojo.class);
    }

    @Override
    protected void map() {
        id(element().getIdentifiant()).auto();
        property(element().getNom());
        collection(element().getSujets());
        collection(element().getParticipants());
    }
}
