package ir.maktab74.service.impl;


import ir.maktab74.base.service.impl.BaseServiceImpl;
import ir.maktab74.model.Agency;
import ir.maktab74.repository.AgencyRepository;
import ir.maktab74.service.AgencyService;
import org.hibernate.NonUniqueResultException;

import javax.persistence.NoResultException;


public class AgencyServiceImpl extends BaseServiceImpl<Agency, Long, AgencyRepository>
        implements AgencyService {
    public AgencyServiceImpl(AgencyRepository repository) {
        super(repository);
    }

    @Override
    public Agency login(String username, String password) {

        try {
            return repository.findByUsernameAndPassword(username, password);
        } catch (NoResultException | NonUniqueResultException ex) {

            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Agency findByAgencyCode(String agencyCode) {
        return repository.findByAgencyCode(agencyCode);
    }
}
