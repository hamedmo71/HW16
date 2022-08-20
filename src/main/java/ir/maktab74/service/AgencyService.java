package ir.maktab74.service;


import ir.maktab74.base.service.BaseService;
import ir.maktab74.model.Agency;

public interface AgencyService extends BaseService<Agency,Long> {

    Agency login(String username, String password);
    Agency findByAgencyCode(String agencyCode);
}
