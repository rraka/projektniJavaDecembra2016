package klijent;

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import dogadjaj.Dogadjaj;
import dogadjaj.Koncert;
import dogadjaj.Promocija;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import osoba.Organizator;
import osoba.Osoba;
import poruka.Poruka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raka
 */
public class PocetnaGUI extends javax.swing.JFrame {

    private KreirajDogadjajGUI kreirajDogadjaj;//glavniProzor
    private RadSaOsobamaGUI unosOsobe;
    private DefaultTableModel modelTabelaDogadjaja;
    private ArrayList<Dogadjaj> sviDogadjaji;
    private final int PORT = 9000;
    private Socket soket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    //private static ArrayList<Dogadjaj> sviDogadjaji;

    public ObjectOutputStream getOos() {
        return oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public PocetnaGUI() {
        try {
            initComponents();
            setVisible(true);

            InetAddress adresa = InetAddress.getByName("127.0.0.1");
            soket = new Socket(adresa, PORT);
            oos = new ObjectOutputStream(soket.getOutputStream());
            ois = new ObjectInputStream(soket.getInputStream());
            
            new ObavjestenjeKlijentNit();
            
            popuniSveDogadjaje();
            modelTabelaDogadjaja = (DefaultTableModel) tabelaDogadaji.getModel();
            popuniTabeluDogadjaja(sviDogadjaji, tabelaDogadaji); //popunjavanje tabele dogadjaja

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDogadaji = new javax.swing.JTable();
        NaslovGlavnaFormaLabela = new javax.swing.JLabel();
        NaslovTabeleGlavnaFormaLabela = new javax.swing.JLabel();
        KreirajDogadjajDugme = new javax.swing.JButton();
        ObrisiDogadjajDugme = new javax.swing.JButton();
        pokreniKampanjuButton = new javax.swing.JButton();
        unosOsobeDugme = new javax.swing.JButton();
        preuzmiOrganizatoreButton = new javax.swing.JButton();
        preuzmiUcesnikeButton = new javax.swing.JButton();
        preuzmiDogadjajeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Organizator događaja");
        setPreferredSize(new java.awt.Dimension(960, 420));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabelaDogadaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Naziv", "Datum", "Pocetak", "Kraj", "Organizator", "Vrsta"
            }
        ));
        tabelaDogadaji.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaDogadaji.getTableHeader().setReorderingAllowed(false);
        tabelaDogadaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDogadajiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDogadaji);
        tabelaDogadaji.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabelaDogadaji.getColumnModel().getColumnCount() > 0) {
            tabelaDogadaji.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaDogadaji.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabelaDogadaji.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaDogadaji.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelaDogadaji.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabelaDogadaji.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        NaslovGlavnaFormaLabela.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NaslovGlavnaFormaLabela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NaslovGlavnaFormaLabela.setText("ORGANIZATOR DOGAĐAJA");

        NaslovTabeleGlavnaFormaLabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NaslovTabeleGlavnaFormaLabela.setText("Događaji:");

        KreirajDogadjajDugme.setText("Kreiraj događaj");
        KreirajDogadjajDugme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KreirajDogadjajDugmeActionPerformed(evt);
            }
        });

        ObrisiDogadjajDugme.setText("Obriši događaj");
        ObrisiDogadjajDugme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObrisiDogadjajDugmeActionPerformed(evt);
            }
        });

        pokreniKampanjuButton.setText("Pokreni  kampanju");
        pokreniKampanjuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokreniKampanjuButtonMouseClicked(evt);
            }
        });

        unosOsobeDugme.setText("Rad sa osobama");
        unosOsobeDugme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unosOsobeDugmeActionPerformed(evt);
            }
        });

        preuzmiOrganizatoreButton.setText("Preuzmi organizatore");
        preuzmiOrganizatoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preuzmiOrganizatoreButtonActionPerformed(evt);
            }
        });

        preuzmiUcesnikeButton.setText("Preuzmi ucesnike");
        preuzmiUcesnikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preuzmiUcesnikeButtonActionPerformed(evt);
            }
        });

        preuzmiDogadjajeButton.setText("Preuzmi dogadjaje");
        preuzmiDogadjajeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preuzmiDogadjajeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NaslovGlavnaFormaLabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NaslovTabeleGlavnaFormaLabela)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KreirajDogadjajDugme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ObrisiDogadjajDugme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pokreniKampanjuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(unosOsobeDugme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preuzmiOrganizatoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(preuzmiUcesnikeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preuzmiDogadjajeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(NaslovGlavnaFormaLabela, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(NaslovTabeleGlavnaFormaLabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KreirajDogadjajDugme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ObrisiDogadjajDugme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pokreniKampanjuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unosOsobeDugme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preuzmiOrganizatoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preuzmiUcesnikeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preuzmiDogadjajeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        NaslovGlavnaFormaLabela.getAccessibleContext().setAccessibleName("NaslovGlavnaFormaLabela");
        KreirajDogadjajDugme.getAccessibleContext().setAccessibleName("KreirajDogadjajDugme");
        ObrisiDogadjajDugme.getAccessibleContext().setAccessibleName("ObrisiDogadjajDugme");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KreirajDogadjajDugmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KreirajDogadjajDugmeActionPerformed
        kreirajDogadjaj = new KreirajDogadjajGUI(this);
        kreirajDogadjaj.setVisible(true);
        this.setVisible(false);
        // dispose();
    }//GEN-LAST:event_KreirajDogadjajDugmeActionPerformed

    private void unosOsobeDugmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unosOsobeDugmeActionPerformed
        unosOsobe = new RadSaOsobamaGUI(this);
        unosOsobe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_unosOsobeDugmeActionPerformed

    private void tabelaDogadajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDogadajiMouseClicked
        int indeks = tabelaDogadaji.getSelectedRow();
        String nazivDogadjaja = (String) modelTabelaDogadjaja.getValueAt(indeks, 0);
    }//GEN-LAST:event_tabelaDogadajiMouseClicked

    private void ObrisiDogadjajDugmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObrisiDogadjajDugmeActionPerformed
        try {
            int indeks = tabelaDogadaji.getSelectedRow();
            String nazivDogadjaja = (String) tabelaDogadaji.getModel().getValueAt(indeks, 0);
            oos.writeObject(new Poruka(Poruka.IDPoruke.BRISANJE_DOGADJAJA, nazivDogadjaja));//s
            Poruka poruka = (Poruka) ois.readObject(); // OVDJE Z A R I B A
            if (poruka.getIdPoruke().equals(Poruka.IDPoruke.OK)) {                                //p
                sviDogadjaji = (ArrayList<Dogadjaj>) poruka.getDodatak();                         //p
                popuniTabeluDogadjaja(sviDogadjaji, tabelaDogadaji);
                JOptionPane.showMessageDialog(null, " Dogadjaj ***" + nazivDogadjaja + "*** uspjesno izbrisan!");
            } else {
                JOptionPane.showMessageDialog(null, " GRESKA!!! \nDogadjaj ***" + nazivDogadjaja + "*** nije izbrisan!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ObrisiDogadjajDugmeActionPerformed

    private void preuzmiUcesnikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preuzmiUcesnikeButtonActionPerformed

        try {
            oos.writeObject(new Poruka(Poruka.IDPoruke.PREUZIMANJE_LISTE_UCESNIKA, null));
            File ucesniciFajl = new File("src/klijent/fajlovi/listaUcesnikaaaaaaaaa.csv");
            primiFajl(ucesniciFajl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_preuzmiUcesnikeButtonActionPerformed

    private void preuzmiOrganizatoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preuzmiOrganizatoreButtonActionPerformed
        try {
            oos.writeObject(new Poruka(Poruka.IDPoruke.PREUZIMANJE_LISTE_ORGANIZATORA, null));
            File organizatoriFajl = new File("src/klijent/fajlovi/listaOrganizatoraaaaaaaaaa.csv");
            primiFajl(organizatoriFajl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_preuzmiOrganizatoreButtonActionPerformed

    private void preuzmiDogadjajeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preuzmiDogadjajeButtonActionPerformed
        try {
            oos.writeObject(new Poruka(Poruka.IDPoruke.PREUZIMANJE_LISTE_DOGADJAJA, null));
            File dogadjajiFajl = new File("src/klijent/fajlovi/listaDogadjajaaaaaaaaaaaaa.csv");
            primiFajl(dogadjajiFajl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_preuzmiDogadjajeButtonActionPerformed

    private void pokreniKampanjuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokreniKampanjuButtonMouseClicked
        int selektovaniIndeks = tabelaDogadaji.getSelectedRow();
        if (selektovaniIndeks >= 0) {
            try {
                Dogadjaj dogadjaj = sviDogadjaji.get(selektovaniIndeks);
                if (dogadjaj instanceof Koncert || dogadjaj instanceof Promocija) {
                    oos.writeObject(new Poruka(Poruka.IDPoruke.POKRENI_MARKENTISKU_KAMPANJU, dogadjaj));
                }
            } catch (IOException ex) {
                Logger.getLogger(PocetnaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_pokreniKampanjuButtonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            oos.writeObject(new Poruka(Poruka.IDPoruke.ZATVARANJE_KONEKCIJE));
        } catch (IOException ex) {
            Logger.getLogger(PocetnaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        PocetnaGUI pocetna = new PocetnaGUI();
    }

    private void popuniSveDogadjaje() {
        try {
            oos.writeObject(new Poruka(Poruka.IDPoruke.SVI_DOGADJAJI, null));
            Poruka poruka = (Poruka) ois.readObject();
            sviDogadjaji = (ArrayList<Dogadjaj>) poruka.getDodatak();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void popuniTabeluDogadjaja(ArrayList<Dogadjaj> dogadjaji, JTable tabelaDogadjaji) {
        DefaultTableCellRenderer centriranje = new DefaultTableCellRenderer();
        centriranje.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tabelaDogadjaji.getColumnModel().getColumn(1).setCellRenderer(centriranje); //centriranje datuma i vremena
        tabelaDogadjaji.getColumnModel().getColumn(2).setCellRenderer(centriranje);
        //brisanje tabele
        int rowCount = modelTabelaDogadjaja.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelTabelaDogadjaja.removeRow(i);
        }

        for (Dogadjaj dogadjaj : dogadjaji) {
            String nazivDogadjaja = dogadjaj.getNazivDogadjaja();
            Calendar datumDogadjaja = dogadjaj.getDatumPocetkaDogadjaja();
            Calendar vrijemePocetak = dogadjaj.getVrijemePocetkaDogadjaja();
            Calendar vrijemeKraj = dogadjaj.getVrijemeKrajaDogadjaja();

            SimpleDateFormat formatDatum = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat formatVremena = new SimpleDateFormat("HH:mm");

            String formatiranDatum = formatDatum.format(datumDogadjaja.getTime());
            String formatiranPocetak = formatVremena.format(vrijemePocetak.getTime());
            String formatiranKraj = formatVremena.format(vrijemeKraj.getTime());
            Organizator organizator = dogadjaj.getOrganizatorDogadjaja();
            String vrsta = dogadjaj.getVrstaDogadjaja();
            modelTabelaDogadjaja.addRow(new Object[]{nazivDogadjaja, formatiranDatum, formatiranPocetak, formatiranKraj,
                organizator, vrsta});
        }
    }

    public void primiFajl(File putanjaFajla) {
        try {
            long duzinaLong = (long) ois.readObject();
            int duzina = (int) duzinaLong;
            int kontrolnaDuzina = 0, flag = 0;
            byte[] buffer = new byte[2 * 1024 * 1024];
            OutputStream fajl = new FileOutputStream(putanjaFajla);
            while ((kontrolnaDuzina = ois.read(buffer)) > 0) {
                fajl.write(buffer, 0, kontrolnaDuzina);
                flag += kontrolnaDuzina;
                if (duzina <= flag) {
                    break;
                }
            }
            System.out.println("Preuzimanje zavrseno...");
            fajl.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KreirajDogadjajDugme;
    private javax.swing.JLabel NaslovGlavnaFormaLabela;
    private javax.swing.JLabel NaslovTabeleGlavnaFormaLabela;
    private javax.swing.JButton ObrisiDogadjajDugme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pokreniKampanjuButton;
    private javax.swing.JButton preuzmiDogadjajeButton;
    private javax.swing.JButton preuzmiOrganizatoreButton;
    private javax.swing.JButton preuzmiUcesnikeButton;
    private javax.swing.JTable tabelaDogadaji;
    private javax.swing.JButton unosOsobeDugme;
    // End of variables declaration//GEN-END:variables

}
