package ir.maktab74.service;

import ir.maktab74.base.service.BaseService;
import ir.maktab74.model.Travel;

import java.util.Date;
import java.util.List;

public interface TravelService extends BaseService<Travel,Long> {

    List<Travel> findAllTravelsOfAgency(Long agencyId);

    List<Travel> findAllTravelsOfSpecifiedDate(String source, String destination, Date travelDate);
}
