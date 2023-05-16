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

/**
 *
 * @author marcr
 */
@Entity()
@Table(name = "Llibre")
public class Llibre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id = 1;

    @Column(name = "isbn", nullable = false)
    private int isbn;

    @Column(name = "titol", nullable = false)
    private String titol;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "editorial", nullable = false)
    private String editorial;

    @Column(name = "data_prestec", nullable = false)
    private int id_prestec;

    public Llibre() {
    }

    public Llibre(int isbn, String titol, String autor, String editorial, int id_prestec) {
        this.isbn = isbn;
        this.titol = titol;
        this.autor = autor;
        this.editorial = editorial;
        this.id_prestec = id_prestec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getId_prestec() {
        return id_prestec;
    }

    public void setId_prestec(int id_prestec) {
        this.id_prestec = id_prestec;
    }

    @Override
    public String toString() {
        return "Llibre{" + "isbn=" + isbn + ", titol=" + titol + ", autor=" + autor + ", editorial=" + editorial + ", id_prestec=" + id_prestec + '}';
    }

}
