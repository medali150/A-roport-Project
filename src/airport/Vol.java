package airport;

public class Vol {
    private String numeroVol;
    private String villeDepart;
    private String villeArrivee;

    public Vol(String numeroVol, String villeDepart, String villeArrivee) {
        this.numeroVol = numeroVol;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    @Override
    public String toString() {
        return "Vol " + numeroVol + " : " + villeDepart + " ➡ " + villeArrivee;
    }
}
