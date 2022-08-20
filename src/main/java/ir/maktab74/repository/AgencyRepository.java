package ir.maktab74.repository;


import ir.maktab74.base.repository.BaseRepository;
import ir.maktab74.model.Agency;

public interface AgencyRepository extends BaseRepository<Agency, Long> {

    Agency findByUsernameAndPassword(String username, String password);
    Agency findByAgencyCode(String agencyCode);
}
