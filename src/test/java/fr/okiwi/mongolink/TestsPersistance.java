package fr.okiwi.mongolink;

import org.junit.Before;
import org.junit.Test;
import org.mongolink.MongoSession;
import org.mongolink.MongoSessionManager;
import org.mongolink.Settings;
import org.mongolink.domain.mapper.ContextBuilder;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestsPersistance {


    @Before
    public void avant() {
        ContextBuilder builder = new ContextBuilder("fr.okiwi.mongolink.mapping");
        final Settings settings = Settings.defaultInstance()
                .withDbName("okiwi");
       MongoSessionManager manager = MongoSessionManager.create(builder, settings);
        session = manager.createSession();
        session.start();
    }

    @Test
    public void peutPersister() {
        final CodingDojo codingDojo = new CodingDojo("ceci est un nom");
        session.save(codingDojo);
        session.clear();

        final CodingDojo dojo = session.get(codingDojo.getIdentifiant(), CodingDojo.class);

        assertThat(dojo, notNullValue());
        assertThat(dojo.getNom(), is("ceci est un nom"));
    }


    @Test
    public void peutPersisterLesParticipants() {
        final CodingDojo codingDojo = new CodingDojo("ceci est un nom");
        codingDojo.ajouterUnParticipant("ta gueule");
        session.save(codingDojo);
        session.clear();

        final CodingDojo dojo = session.get(codingDojo.getIdentifiant(), CodingDojo.class);

        assertThat(dojo.getParticipants(), notNullValue());
        assertThat(dojo.getParticipants().size(), is(1));
        assertThat(dojo.getParticipants().get(0), is("ta gueule"));
    }

    @Test
    public void peutPersisterLesSujets() {
        final CodingDojo codingDojo = new CodingDojo("ceci est un nom");
        codingDojo.ajouteSujet("mais vos gueules on a dit");
        session.save(codingDojo);
        session.clear();

        final CodingDojo dojo = session.get(codingDojo.getIdentifiant(), CodingDojo.class);


        assertThat(dojo.getSujets().size(), is(1));
        assertThat(dojo.getSujets().get(0), is(new Sujet("mais vos gueules on a dit")));
    }

    MongoSession session;
}
