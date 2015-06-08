
package internetbankieren;

// TODO: Wijzig naar Klant klasse zoals in het klassediagram

public class Klant {
    private String name;
    private String city;
    private String wachtwoord;

    public Klant(String name, String city, String wachtwoord) {
        this.name = name;
        this.city = city;
        this.wachtwoord = wachtwoord;
    }

    public String getName() {
        return name;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getCity() {
        return city;
    }
    
    
}
