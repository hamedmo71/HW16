package ir.maktab74.repository.impl;


import ir.maktab74.base.repository.impl.BaseRepositoryImpl;
import ir.maktab74.model.Travel;
import ir.maktab74.repository.TravelRepository;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class TravelRepositoryImpl extends BaseRepositoryImpl<Travel, Long>
        implements TravelRepository {
    public TravelRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Travel> getEntityClass() {
        return Travel.class;
    }

    @Override
    public List<Travel> findAllTravelsOfAgency(Long agencyId) {
        List<Travel> travelList = entityManager.
                createQuery("select t from Travel t where t.agency.id=:agencyId", entityClass)
                .setParameter("agencyId", agencyId).getResultList();
        return travelList;
    }

    @Override
    public List<Travel> findAllTravelsOfSpecifiedDate(String source, String destination, Date travelDate) {
        return entityManager.createQuery
                ("select t from Travel t where source=:source and " +
                        "destination=:destination and " +
                        "travelDate>:travelDate order by travelDate",getEntityClass())
                .setParameter("source",source)
                .setParameter("destination",destination)
                .setParameter("travelDate",travelDate).getResultList();

    }

    @Override
    public Boolean existsByTravelId(String travelId) {
        return entityManager.createQuery
                        ("select (count(t.id) > 0) from Travel t where travelId=:travelId", Boolean.class)
                .setParameter("travelId", travelId).getSingleResult();
    }
}
