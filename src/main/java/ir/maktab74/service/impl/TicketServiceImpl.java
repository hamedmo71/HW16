package ir.maktab74.service.impl;


import ir.maktab74.base.service.impl.BaseServiceImpl;
import ir.maktab74.model.Ticket;
import ir.maktab74.repository.TicketRepository;
import ir.maktab74.service.TicketService;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository>
        implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }
}
