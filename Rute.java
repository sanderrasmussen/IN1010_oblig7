public abstract class Rute {
    Labyrint labyrint ;
    int radNr;
    int kollonneNr;
    //nabo referanser
    Rute nord;
    Rute soer;
    Rute vest;
    Rute oest;
    Rute[] naboer = new Rute[4];


    public Rute(Labyrint labyrint, int radNr, int kollonneNr){
        this.labyrint = labyrint;
        this.radNr = radNr;
        this.kollonneNr = kollonneNr;
    }

    public void settNaboer(Rute nord, Rute soer, Rute vest, Rute oest){
        this.nord = nord;
        naboer[0] = this.nord;
        this.soer = soer;
        naboer[1] = this.soer;
        this.vest = vest;
        naboer[2]= this.vest;
        this.oest = oest;
        naboer[3] = this.oest;
        
    }
    public int hentRadNr (){
        return radNr;

    }
    public int hentKollonneNr(){
        return kollonneNr;
    }
    public void finn(Rute fra, String sti){

        for (Rute nabo : naboer){ // dersom nabo ikke er "fra" ruten så kaller vi finn()
            if (nabo!=null && !nabo.equals(fra)){
                nabo.finn(this, sti + this.radNr +", " +this.kollonneNr +"\n");
                //dersom en av naboene leder til aapning saa er denne ruten en del av vandringen
                //System.out.println(this.radNr +","+ this.kollonneNr);
            }
        }
        

    }
    public Rute[] hentNaboer(){
        return naboer;
    }
  
}
