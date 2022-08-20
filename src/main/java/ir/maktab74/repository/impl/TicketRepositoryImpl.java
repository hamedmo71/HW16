package ir.maktab74.repository.impl;

import ir.maktab74.base.repository.impl.BaseRepositoryImpl;
import ir.maktab74.model.Ticket;
import ir.maktab74.repository.TicketRepository;


import javax.persistence.EntityManager;


public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket, Long>
        implements TicketRepository {

    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
