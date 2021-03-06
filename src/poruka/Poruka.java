/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poruka;

import java.io.Serializable;

/**
 *
 * @author raka
 */
public class Poruka implements Serializable{
    
    public static enum IDPoruke{
        SVI_DOGADJAJI,
        SVI_ORGANIZATORI,
        SVI_UCESNICI,
        SVI_PREDAVACI,
        BRISANJE_DOGADJAJA,
        BRISANJE_ORGANIZATORA,
        BRISANJE_UCESNIKA,
        BRISANJE_PREDAVACA,
        NOVI_DOGADJAJ,
        NOVI_UCESNIK,
        NOVI_ORGANIZATOR,
        NOVI_PREDAVAC,
        PREUZIMANJE_LISTE_DOGADJAJA,
        PREUZIMANJE_LISTE_UCESNIKA,
        PREUZIMANJE_LISTE_ORGANIZATORA,
        OK,
        GRESKA,
        POKRENI_MARKENTISKU_KAMPANJU,
        MARKENTISKA_KAMPANJA,
        ZATVARANJE_KONEKCIJE,
        OBAVJESTENJE,
        ZATVORI_OBAVJESTENJE
    }
    
    private IDPoruke idPoruke;
    private Object dodatak;

    public Poruka(IDPoruke idPoruke, Object dodatak) {
        this.idPoruke = idPoruke;
        this.dodatak = dodatak;
    }
    public Poruka(IDPoruke idPoruke) {
        this.idPoruke = idPoruke;
    }

    public IDPoruke getIdPoruke() {
        return idPoruke;
    }

    public void setIdPoruke(IDPoruke idPoruke) {
        this.idPoruke = idPoruke;
    }

    public Object getDodatak() {
        return dodatak;
    }

    public void setDodatak(Object dodatak) {
        this.dodatak = dodatak;
    }
    
    
}
