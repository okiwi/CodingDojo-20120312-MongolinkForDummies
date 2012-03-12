package fr.okiwi.mongolink.test;

import fr.okiwi.mongolink.CodingDojo;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//TODO : se renseigner sur les imports statiques

public class TestCodingDojo {
    @Test
    public void peutAjouterDesParticipants() {
        CodingDojo codingDojo = new CodingDojo("MongoLink for dummies");

        codingDojo.ajouterUnParticipant("Charles");

        assertThat(codingDojo.getParticipants().size(), is(1));
    }
}
