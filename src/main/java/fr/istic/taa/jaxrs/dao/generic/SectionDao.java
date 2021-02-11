package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.istic.taa.jaxrs.domain.Section;

public class SectionDao extends AbstractJpaDao<Long, Section> {

    public SectionDao() {
	super(Section.class);
    }
    
    public List<Section> getSectionWithName(String name){
	String query = "select s from Section as s where s.name=:name";
	List<Section> sections = entityManager.createQuery(query, Section.class).setParameter("name", name).getResultList();
	return sections;
    }
    
    public List<Long> getIdOfSectionWithNames(String...names){
	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
	Root<Section> from = query.from(Section.class);
	query.select(from.get("id")).where(from.get("name").in(names));
	return entityManager.createQuery(query).getResultList();
    }
    
 
}
