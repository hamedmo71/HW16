package ir.maktab74.util;


import ir.maktab74.repository.AgencyRepository;
import ir.maktab74.repository.TicketRepository;
import ir.maktab74.repository.TravelRepository;
import ir.maktab74.repository.UserRepository;
import ir.maktab74.repository.impl.AgencyRepositoryImpl;
import ir.maktab74.repository.impl.TicketRepositoryImpl;
import ir.maktab74.repository.impl.TravelRepositoryImpl;
import ir.maktab74.repository.impl.UserRepositoryImpl;
import ir.maktab74.service.AgencyService;
import ir.maktab74.service.TicketService;
import ir.maktab74.service.TravelService;
import ir.maktab74.service.UserService;
import ir.maktab74.service.impl.AgencyServiceImpl;
import ir.maktab74.service.impl.TicketServiceImpl;
import ir.maktab74.service.impl.TravelServiceImpl;
import ir.maktab74.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ApplicationContext {

    public static EntityManager em=HibernateUtil.getEntityManagerFactory().createEntityManager();

    private static AgencyRepository agencyRepository;
    private static TravelRepository travelRepository;
    private static TicketRepository ticketRepository;
    private static UserRepository userRepository;


    private static AgencyService agencyService;
    private static TravelService travelService;
    private static TicketService ticketService;
    private static UserService userService;

    public static Menu getMenu=new Menu();

    private static Scanner stringScanner;

    private static Scanner numberScanner;



    public static AgencyRepository getAgencyRepository(){
        if (agencyRepository==null){
            agencyRepository= new AgencyRepositoryImpl(em);
        }
        return agencyRepository;
    }

    public static TravelRepository getTravelRepository(){
        if (travelRepository==null){
            travelRepository=new TravelRepositoryImpl(em) {
            };
        }
        return travelRepository;
    }


    public static TicketRepository getTicketRepository(){
        if (ticketRepository==null){
            ticketRepository=new TicketRepositoryImpl(em);
        }
        return ticketRepository;
    }


    public static UserRepository getUserRepository(){
        if (userRepository==null){
            userRepository=new UserRepositoryImpl(em);
        }
        return userRepository;
    }

    public static AgencyService getAgencyService(){
        if (agencyService==null){
            agencyService=new AgencyServiceImpl(getAgencyRepository());
        }
        return agencyService;
    }


    public static TravelService getTravelService(){
        if (travelService==null){
            travelService=new TravelServiceImpl(getTravelRepository());
        }
        return travelService;
    }


    public static TicketService getTicketService(){
        if (ticketService==null){
            ticketService=new TicketServiceImpl(getTicketRepository());
        }
        return ticketService;
    }

    public static UserService getUserService(){
        if (userService==null){
            userService=new UserServiceImpl(getUserRepository());
        }
        return userService;
    }

    public static Scanner getStringScanner(){
        if (stringScanner==null){
            stringScanner=new Scanner(System.in);
        }
        return stringScanner;
    }

    public static Scanner getNumberScanner(){
        if (numberScanner==null){
            numberScanner=new Scanner(System.in);
        }
        return numberScanner;
    }

    public static String getEncryptPassword(String password)  {
        EncryptPassword encryptPassword = new EncryptPassword(password);
        try {
            return encryptPassword.encPassword();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            return password;
        }
    }
}
