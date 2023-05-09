import java.util.Scanner;

public class Oblig7 { //kaller klassen Oblig7 istedenfor Oblig6 da jeg regner med dette er en skrivefeil i oppgaveteksten


    public static void main (String[] args){
        //Husk aa sjekke at det finnes args
        if (args.length!=1){
            System.out.println("du kan kun oppgi ett filnavn som argument");
            System.exit(0);
        }
        //Labyrint labyrint = new Labyrint("labyrinter/1.in");
        Labyrint labyrint = new Labyrint(args[0]);
        System.out.println("Du kan naar som helst stoppe programmet ved aa skrive 'stopp', eller ingenting og trykk Enter");
        System.out.println("Oppgi startrute kordinater paa formen: rad,kolonne");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        while (input!="stopp" || input!=""){
            
            String[] koordinater = input.split(",");
            if (koordinater.length<2){
                System.out.println("du oppga ugyldige koordinater. Avslutter programmet");
            }
            labyrint.finnUtveiFra(Integer.parseInt(koordinater[0]), Integer.parseInt(koordinater[1]));
            input= scanner.nextLine();
        }
        scanner.close();
 
    }
}
