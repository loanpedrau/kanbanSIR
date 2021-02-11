package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.KanbanBoard;

public class KanbanDao extends AbstractJpaDao<Long, KanbanBoard> {

    public KanbanDao() {
	super(KanbanBoard.class);
    }
    
}
