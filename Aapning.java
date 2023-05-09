public class Aapning extends HvitRute {

    public Aapning(Labyrint labyrint, int radNr, int kollonneNr) {
        super(labyrint, radNr, kollonneNr);

    }
    @Override
    public void finn(Rute fra, String sti){
        //paa aapning skal den slutte å kalle finn()
        //dersom en av naboene leder til aapning saa er denne ruten en del av vandringen

        System.out.println("Sti :" + "\n" + sti  + "aapning: " +this.radNr +", "+ this.kollonneNr);

    }
}
