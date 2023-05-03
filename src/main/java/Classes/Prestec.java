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
public class Prestec {

    private Date data_prestec;
    private Date data_devolucio;
    private int ID_USUARI;

    public Prestec() {
    }

    public Prestec(Date data_prestec, Date data_devolucio, int ID_USUARI) {
        this.data_prestec = data_prestec;
        this.data_devolucio = data_devolucio;
        this.ID_USUARI = ID_USUARI;
    }

    public Date getData_prestec() {
        return data_prestec;
    }

    public void setData_prestec(Date data_prestec) {
        this.data_prestec = data_prestec;
    }

    public Date getData_devolucio() {
        return data_devolucio;
    }

    public void setData_devolucio(Date data_devolucio) {
        this.data_devolucio = data_devolucio;
    }

    public int getID_USUARI() {
        return ID_USUARI;
    }

    public void setID_USUARI(int ID_USUARI) {
        this.ID_USUARI = ID_USUARI;
    }

    @Override
    public String toString() {
        return "Prestec{" + "data_prestec=" + data_prestec + ", data_devolucio=" + data_devolucio + ", ID_USUARI=" + ID_USUARI + '}';
    }

}
