package ir.maktab74.repository;


import ir.maktab74.base.repository.BaseRepository;
import ir.maktab74.model.Travel;

import java.util.Date;
import java.util.List;

public interface TravelRepository extends BaseRepository<Travel,Long> {


    List<Travel> findAllTravelsOfAgency(Long agencyId);

    List<Travel> findAllTravelsOfSpecifiedDate(String source, String destination, Date travelDate);

    Boolean existsByTravelId(String travelId);
}
