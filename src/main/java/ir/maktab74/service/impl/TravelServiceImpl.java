package ir.maktab74.service.impl;

import ir.maktab74.base.service.impl.BaseServiceImpl;
import ir.maktab74.model.Travel;
import ir.maktab74.repository.TravelRepository;
import ir.maktab74.service.TravelService;
import ir.maktab74.util.RandomUtil;

import java.util.Date;
import java.util.List;

public class TravelServiceImpl extends BaseServiceImpl<Travel, Long, TravelRepository>
        implements TravelService {
    public TravelServiceImpl(TravelRepository repository) {
        super(repository);
    }

    @Override
    public Travel save(Travel travel) {
        try {
            beginTransaction();
            if (travel.getId() == null) {
                setTravelId(travel);
                repository.save(travel);
            } else travel = repository.update(travel);
            commitTransaction();
            return travel;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            rollbackTransaction();
            return travel;
        } finally {
            closeEntityManager();
        }
    }

    private void setTravelId(Travel travel) {
        String code = RandomUtil.getRandomNumeric(6);
        while (repository.existsByTravelId(code)) {
            code = RandomUtil.getRandomNumeric(6);

        }
        travel.setTravelId(code);
    }

    @Override
    public List<Travel> findAllTravelsOfAgency(Long agencyId) {
        try {
            return repository.findAllTravelsOfAgency(agencyId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Travel> findAllTravelsOfSpecifiedDate(String source, String destination, Date travelDate) {
        Date currentDate = new Date();
        if (travelDate.after(currentDate)) {
            return repository.findAllTravelsOfSpecifiedDate(source, destination, travelDate);
        } else return repository.findAllTravelsOfSpecifiedDate(source, destination, currentDate);
    }
}
