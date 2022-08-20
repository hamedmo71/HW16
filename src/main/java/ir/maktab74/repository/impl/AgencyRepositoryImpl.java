package ir.maktab74.repository.impl;

import ir.maktab74.base.repository.impl.BaseRepositoryImpl;
import ir.maktab74.model.Agency;
import ir.maktab74.repository.AgencyRepository;

import javax.persistence.EntityManager;


public class AgencyRepositoryImpl extends BaseRepositoryImpl<Agency, Long> implements AgencyRepository {
    public AgencyRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Agency> getEntityClass() {
        return Agency.class;
    }

    @Override
    public Agency findByUsernameAndPassword(String username, String password) {
        Agency agency = entityManager.createQuery
                        ("select a from Agency a where username=:username and password=:password", Agency.class)
                .setParameter("username", username).setParameter("password", password)
                .getSingleResult();
        return agency;
    }

    @Override
    public Agency findByAgencyCode(String agencyCode) {
        Agency agency = entityManager.createQuery
                        ("select a from Agency a where agencyCode=:agencyCode", Agency.class)
                .setParameter("agencyCode", agencyCode)
                .getSingleResult();
        return agency;
    }
}
