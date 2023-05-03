/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Date;

/**
 *
 * @author marcr
 */
public class Usuari {

    private int ID;
    private String nom;
    private String direccio;
    private int telefon;
    private Date data_prestec;

    public Usuari() {
    }

    public Usuari(int ID, String nom, String direccio, int telefon, Date data_prestec) {
        this.ID = ID;
        this.nom = nom;
        this.direccio = direccio;
        this.telefon = telefon;
        this.data_prestec = data_prestec;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public Date getData_prestec() {
        return data_prestec;
    }

    public void setData_prestec(Date data_prestec) {
        this.data_prestec = data_prestec;
    }

    @Override
    public String toString() {
        return "Usuari{" + "ID=" + ID + ", nom=" + nom + ", direccio=" + direccio + ", telefon=" + telefon + ", data_prestec=" + data_prestec + '}';
    }

}
