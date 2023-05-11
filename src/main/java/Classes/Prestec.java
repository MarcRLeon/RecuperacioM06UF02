/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author marcr
 */
@Entity()
@Table(name = "prestecs")
public class Prestec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "data_prestec",nullable = false)
    private Date data_prestec;

    @Column(name = "data_devolucio", nullable = false)
    private Date data_devolucio;

    @Column(name = "ID_USUARI", nullable = false)
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
