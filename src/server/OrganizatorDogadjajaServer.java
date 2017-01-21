/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dogadjaj.Dogadjaj;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import osoba.Posjetilac;

/**
 *
 * @author raka
 */
public class OrganizatorDogadjajaServer {

    private static final int PORT = 9000;
    private static ListaDogadjaja listaDogadjaja;
    private static ArrayList<Dogadjaj> sviDogadjaji;
    private static ArrayList<Posjetilac> sviPosjetioci;
    private static ArrayList<Posjetilac> sviOrganizatori;
    private static ArrayList<Posjetilac> sviUcesnici;
    private static ArrayList<Posjetilac> sviPredavaci;

    public static ArrayList<Dogadjaj> getSviDogadjaji() {
        return sviDogadjaji;
    }

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("Server pokrenut...");
            //listaDogadjaja = new ListaDogadjaja();
            // listaDogadjaja = deSerijalizacija();
            ListaDogadjaja.kreirajPosjetioce();
            sviPosjetioci = ListaDogadjaja.deSerijalizacija("posjetioci");
            sviDogadjaji = ListaDogadjaja.deSerijalizacija("dogadjaji"); //deserijalizovani dogadjaji
            sviOrganizatori = ListaDogadjaja.deSerijalizacija("organizatori");
            sviPredavaci = ListaDogadjaja.deSerijalizacija("predavaci");
            sviUcesnici = ListaDogadjaja.deSerijalizacija("ucesnici");
            
            System.out.println("Poslije deserijalizacije svih dogadjaja");
            while (true) {
                Socket soket = ss.accept();
                OrganizatorDogadjajaServerNit odsn = new OrganizatorDogadjajaServerNit(soket);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}
