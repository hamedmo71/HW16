package ir.maktab74.util;

public class Menu {

    public void showWelcomeMessage() {
        System.out.println("Welcome to ticket booking system.");
    }

    public void showFirstPageMenu() {
        System.out.println("Enter as:");
        System.out.println("1. Agency");
        System.out.println("2. User");
        System.out.println("3. Exit");
    }

    public void separator() {
        System.out.println("=======================================");
    }

    public void showEnterValidNumMessage() {
        System.out.println("please enter valid number.");
    }

    public void showAgencyMenu() {
        System.out.println("1. Enter a new flight information.");
        System.out.println("2. Edit flight information.");
        System.out.println("3. Back to previous menu.");
    }

    public void enterUsernameMessage() {
        System.out.print("Enter username: ");
    }
    public void enterPasswordMessage() {
        System.out.print("Enter password: ");
    }

    public void wrongUsernameOrPasswordMessage() {
        System.out.println("wrong username or password!");
    }

    public void enterAirplaneModelMessage() {
        System.out.print("Enter airplane model: ");
    }

    public void defineTypeOfSeats() {
        System.out.print("Define type of seats. For business class seats enter 1 and for economy class enter 2: ");
    }

    public void enterNumberOfSeats() {
        System.out.print("Enter number of seats: ");
    }

    public void enterTicketPrice() {
        System.out.print("Enter ticket price: ");
    }

    public void setFlightDateMessage() {
        System.out.println("Enter Flight Date");
    }

    public void enterDepartureAirport() {
        System.out.print("From: ");
    }
    public void enterDestinationAirport() {
        System.out.print("To: ");
    }

    public void editFlightMenu() {
        System.out.println("1. Edit airplane model");
        System.out.println("2. Edit departure date");
        System.out.println("3. Edit departure airport");
        System.out.println("4. Edit destination airport");
        System.out.println("5. Set edits");
        System.out.println("6. Back to previous menu");
    }

    public void showUserFirstPageMenu() {
        System.out.println("1. sign up");
        System.out.println("2. login");
        System.out.println("3. Back to previous menu");
    }

    public void showUserOptionMenu() {
        System.out.println("1. Search in Flights");
        System.out.println("2. Show my profile");
        System.out.println("3. Back to previous menu");
    }

    public void showFlightSortingMenu() {
        System.out.println("1. Sort by price in ascending order");
        System.out.println("2. Sort by price in descending order");
        System.out.println("3. Sort by agency name in ascending order");
        System.out.println("4. Sort by agency name in descending order");
        System.out.println("5. Back to previous menu");
    }
}
