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

    @Column(name = "id_usuari", nullable = false)
    private int id_usuari;

    public Prestec() {
    }

    public Prestec(int id_prestec, Date data_prestec, Date data_devolucio, int ID_USUARI) {
        this.id_prestec = id_prestec;
        this.data_prestec = data_prestec;
        this.data_devolucio = data_devolucio;
        this.id_usuari = ID_USUARI;
    }

    public int getId_prestec() {
        return id_prestec;
    }

    public void setId_prestec(int id_prestec) {
        this.id_prestec = id_prestec;
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

    public int getId_usuari() {
        return id_usuari;
    }

    public void setId_usuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }



    @Override
    public String toString() {
        return "Prestec{" + "id_prestec=" + id_prestec + ", data_prestec=" + data_prestec + ", data_devolucio=" + data_devolucio + ", ID_USUARI=" + id_usuari + '}';
    }
}
