public class SortRute extends Rute{
    
    public SortRute(Labyrint labyrint, int radNr, int kollonneNr){
        super(labyrint, radNr, kollonneNr);
    }

    //HUSK! REDEFINER TOO STRING METODEN
    @Override
    public String toString(){
        return "#";
    }
    @Override
    public void finn(Rute fra, String sti){
        //paa sort rute skjer ingenting
    }
}
