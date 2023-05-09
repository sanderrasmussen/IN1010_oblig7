public class HvitRute extends Rute {
    

    public HvitRute(Labyrint labyrint, int radNr, int kollonneNr) {
        super(labyrint, radNr, kollonneNr);
    }

    //HUSK! REDEFINER TOO STRING METODEN
    @Override
    public String toString(){
        return ".";
    }
    @Override
    public void finn(Rute fra, String sti){

        for (Rute nabo : naboer){ // dersom nabo ikke er "fra" ruten så kaller vi finn()
            if (nabo!=null && !nabo.equals(fra)){
                nabo.finn(this, sti + this.radNr +", " +this.kollonneNr +"\n");
                //dersom en av naboene leder til aapning saa er denne ruten en del av vandringen
                //System.out.println(this.radNr +","+ this.kollonneNr);
            }
        }
    }
}
