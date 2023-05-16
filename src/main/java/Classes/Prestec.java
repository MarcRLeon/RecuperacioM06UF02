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
@Table(name = "Prestec")
public class Prestec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestec", nullable = false)
    private int id_prestec;

    @Column(name = "data_prestec", nullable = false)
    private Date data_prestec;

    @Column(name = "data_devolucio", nullable = false)
    private Date data_devolucio;

    @Column(name = "ID_USUARI", nullable = false)
    private int ID_USUARI;

    public Prestec() {
    }

    public Prestec(int id_prestec, Date data_prestec, Date data_devolucio, int ID_USUARI) {
        this.id_prestec = id_prestec;
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

    public int getId_prestec() {
        return id_prestec;
    }

    public void setId_prestec(int id_prestec) {
        this.id_prestec = id_prestec;
    }

    @Override
    public String toString() {
        return "Prestec{" + "id_prestec=" + id_prestec + ", data_prestec=" + data_prestec + ", data_devolucio=" + data_devolucio + ", ID_USUARI=" + ID_USUARI + '}';
    }
}
