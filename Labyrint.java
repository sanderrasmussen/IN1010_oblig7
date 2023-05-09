import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labyrint{
    Rute[][] rutenett;
    String[][] rutenettFraFil ;
    int antRader;
    int antKolonner;

    public Labyrint(String filnavn){
        try {
            File fil = new File(filnavn);  
            Scanner scanner = new Scanner(fil);
            int linjeNr = 0;
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                if (linjeNr==0){ //leser metadata 
                    String[] dataArray= data.split(" ");
                    antKolonner = Integer.parseInt(dataArray[1]);
                    System.out.println(antKolonner);
                    antRader= Integer.parseInt(dataArray[0]); 
                    System.out.println(antRader);
                    this.rutenett = new Rute[antRader][antKolonner];
                    this.rutenettFraFil= new String[antRader][antKolonner];
                }
                
                else {
                    String[] dataArray= data.split("");
                    rutenettFraFil[linjeNr-1]= dataArray; //foerste linjen er for metadata, dermed linje nr 1-1 = linjenr0 i labyrint dataene
                    
                }
                linjeNr+=1;
                
            
            }
            //naar alle linjene er lest inn lager vi ruter
            for (int i = 0; i< antRader;i++){
                for (int j=0; j< antKolonner;j++){// maa her passe på at aapninger er instanser avAApning
                    if (rutenettFraFil[i][j].equals("#")){
                        rutenett[i][j]= new SortRute(this, i, j);
              
                    }
                    else if (rutenettFraFil[i][j].equals(".") && i!=0 && j!=0 && i!=antRader && j!=antKolonner){ //dersom det finnes en hvit rute paa rad 0 eller siste rad er denne ruten en aapning, Dersom en hvit rute finnes på j=0 eller siste j posisjon er den ogsaa en aapning
                        rutenett[i][j]= new HvitRute(this, i, j);
   
                    }
                    else if (rutenettFraFil[i][j].equals(".") && (i==0 || j==0 || i==antRader || j==antKolonner)){
                        rutenett[i][j]= new Aapning(this, i, j);
                    }
                }       
            }
            //til slutt kobler vi sammen alle rutene
            kobleAlleRuter();
            //printUtAlleNaboer();    
            //System.out.println(rutenett[0][0].soer); //bruker denne for aa teste at rutene faar riktige naboer
        }
        catch (FileNotFoundException e){
            System.out.println("fant ikke filen");
            System.exit(0); //terminerer program dersom filen ikke kunne leses
        }
        System.out.println(this);
    }

    public Rute hentRute(int rad, int kolonne){ //dersom indeksen er utenfor verdiomraadet returneres null
        for (int i = 0; i<antRader;i++){
            for (int j=0; j<antKolonner;j++){
                if (rutenett[i][j].hentRadNr()== rad && rutenett[i][j].hentKollonneNr()==kolonne){
                    return rutenett[i][j];
                }
            }
        }
        return null;
    }
 
    public void kobleAlleRuter(){
        for (int i = 0; i< antRader;i++){
            for (int j= 0; j< antKolonner;j++){
                rutenett[i][j].settNaboer(hentRute(i-1, j), hentRute(i+1, j), hentRute(i, j-1), hentRute(i, j+1)); //dersom noen av disse har ugyldig indeks blir naboen evaluert til null og har dermed ikke nabo paa den posisjonen
            }
        }
    }

    public void printUtAlleNaboer(){//for testing
        for (int i = 0; i< antRader;i++){
            for (int j=0;j<antKolonner;j++){
                System.out.println("nord" + i+","+j+ hentRute(i, j).nord);
                System.out.println("soer" +i+","+j+ hentRute(i, j).soer);
                System.out.println("vest" +i+","+j+ hentRute(i, j).vest);
                System.out.println("oest" +i+","+j+ hentRute(i, j).oest);
            }
        }
    }
        
   
   
    //SKRIV DENNE METODEN NAAR RUTE KLASSENE ER LAGET
    @Override
    public String toString(){
       
        String tekstFormat = "";
        for (int i = 0 ; i<antRader; i++){
            for (int j = 0 ; j < antKolonner; j++){
                   tekstFormat += rutenett[i][j].toString();
            }
            tekstFormat += "\n";
        }
        return tekstFormat;
    }


    public void finnUtveiFra(int rad, int kol){
        hentRute(rad, kol).finn(null, rad+","+kol+"\n");
    }

}
