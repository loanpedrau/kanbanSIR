package fr.istic.taa.jaxrs;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import fr.istic.taa.jaxrs.dao.generic.FicheDao;
import fr.istic.taa.jaxrs.dao.generic.KanbanDao;
import fr.istic.taa.jaxrs.dao.generic.SectionDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Admin;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.KanbanBoard;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * RESTfull microservice, based on JAX-RS and JBoss Undertow
 *
 */
public class RestServer {

    private static final Logger logger = Logger.getLogger(RestServer.class.getName());

    public static void main( String[] args ) {

        UndertowJaxrsServer ut = new UndertowJaxrsServer();

        TestApplication ta = new TestApplication();

        ut.deploy(ta);

        ut.start(
                Undertow.builder()
                        .addHttpListener(8080, "localhost")

        );

        logger.info("JAX-RS based micro-service running!");
        
        logger.info("Initialisation BDD");
        
        FicheDao ficheDao = new FicheDao();
	KanbanDao kanbanDao = new KanbanDao();
	KanbanBoard kb = new KanbanBoard();
	kb.setName("first kanban");
	kanbanDao.save(kb);
	
	Section section1 = new Section();
	section1.setName("section1");
	section1.setKanbanBoard(kb);
	SectionDao sectionDao = new SectionDao();
	sectionDao.save(section1);
	
	Section section1Bis = new Section();
	section1Bis.setName("section1");
	section1Bis.setKanbanBoard(kb);
	sectionDao.save(section1Bis);

	Section section2 = new Section();
	section2.setName("section2");
	section2.setKanbanBoard(kb);
	sectionDao.save(section2);
	
	Utilisateur user1 = new Utilisateur();
	user1.setEmail("email@gmail.com");
	user1.setName("user1");
	
	List<KanbanBoard> kanbans = new ArrayList<>();
	kanbans.add(kb);
	user1.setKanbanBoards(kanbans);
	UtilisateurDao userDao = new UtilisateurDao();
	userDao.save(user1);
	
	List<Fiche> fiches = new ArrayList<>();
	for(int i =0; i<5; i++) {
	    Fiche f = new Fiche();
	    f.setLibelle("ficheNumero"+i);
	    f.setLieu("lieu"+i);
	    f.setNote("note ....");
	    f.setPosition(i);
	    f.setSection(section1);
	    f.setUtilisateur(user1);
	    ficheDao.save(f);
	}
	
	Admin admin = new Admin();
	admin.setEmail("admin@gmail.com");
	admin.setLevel(5);
	admin.setName("admin");
	admin.setKanbanBoards(kanbans);
	userDao.save(admin);
	
    }
}
