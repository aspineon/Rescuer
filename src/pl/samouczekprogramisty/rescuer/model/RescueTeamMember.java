package pl.samouczekprogramisty.rescuer.model;
import java.time.LocalDateTime;
import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;



/**
 * Created by Maciek on 23.03.2016.
 */
public class RescueTeamMember {
    private Position position;
    private LocalDateTime lastUpdated;
    final private String name;
    final private String surname;
    private String phoneNumber;
    private List<Activity> activityLog = new ArrayList<Activity>();


    public RescueTeamMember(Position position, LocalDateTime lastUpdated, String name, String surname, String phoneNumber) {
        this.position = position;
        this.lastUpdated = lastUpdated;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        //this.activityLog = activityLog;
    }

    public  RescueTeamMember(String name){
        this.name = name;
    }

    public RescueTeamMember() {

    }

    public Position getPosition() {
        return position;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Activity> getActivityLog() {
        return activityLog;
    }

    public void setPosition(Position position) {

            this.position = position;

    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setActivityLog(List<Activity> activityLog) {
        this.activityLog = activityLog;
    }

    public void addActivity(Activity activity) {
        this.activityLog.add(activity);
    }

    // wyrzucuc do osobnej klasy
    public static RescueTeamMember instantiate(InputStream in) {
        if (in == System.in) {
            Scanner console = new Scanner(in);

            System.out.println("Podaj imie ratownika1: ");
            String name = console.nextLine();

            System.out.println("Podaj nazwisko ratownika: ");
            String surname = console.nextLine();

            System.out.println("Podaj nr telefonu ratownika : ");
            String phoneNumber = console.nextLine();

            System.out.println("Podaj pozycje lat ratownika");
            double lat = getPos(console);

            System.out.println("Podaj pozycje lon ratownika");
            double lon = getPos(console);

            Position position = new Position(lat, lon);

            LocalDateTime date = LocalDateTime.now();

            return new RescueTeamMember(position, date,  name, surname, phoneNumber);
        }
        else {
            System.out.println("blad");
            return new RescueTeamMember("blad");
        }
    }


    private static double getPos(Scanner console) {
        try {
            return console.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Musisz podac liczbe");
        }
        return 0;
    }
}
