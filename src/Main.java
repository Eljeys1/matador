
import java.util.ArrayList;

public class Main {
    public static ArrayList<Player> players = new ArrayList<>();
    public static void main(String[] args) {

        //Læse data
        FileIO io = new FileIO();
        ArrayList<String> data = io.readPlayerData("src/data.txt");

        if (data.size()>0) {
            for (String line : data) {
                String[] row = line.split(","); // line splittes to strings ==>  "Egon", "200"
                String name = row[0];      // ==> "Egon"
                int balance = Integer.parseInt(row[1].trim()); // Konverterer string til int "200" ==> 200
                Player c = new Player(name, balance); //bruger de indlæste værdier til at konstruere et playerobjekt (instansiering)
                players.add(c); // placerer objektet i listen med player
            }
        }

        //Test koden
        testCode();

        //Gemme ændringer  (data persistence)
        io.savePlayerData(players);
    }

    private static void testCode() {
        /* Denne kode foretager nogle ændringer i player objekterne for at teste at data bliver gemt korrekt
        Første spiller får 1000kr
        Sidste spiller får 2000 kr
         */

        displayPlayers();
        //Lidt manipulation med nogle af de objekter vi lige har lavet

        System.out.println("Første spiller får 1000kr");
        players.get(0).deposit(1000);

        System.out.println("\n Sidste spiller får 2000 kr");
        Player lastPlayer = players.get(players.size()-1);
        lastPlayer.deposit(2000);

        System.out.println("\n Ny tilstand efter manipulation: ");
        displayPlayers();
    }

    private static void displayPlayers() {
        for (Player c:players) {
            System.out.println(c);
        }
    }
}