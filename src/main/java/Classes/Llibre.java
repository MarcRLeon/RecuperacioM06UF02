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
public class Llibre {

    private String isbn;
    private String titol;
    private String autor;
    private String editorial;
    private Date data_prestec;

    public Llibre() {
    }

    public Llibre(String isbn, String titol, String autor, String editorial, Date data_prestec) {
        this.isbn = isbn;
        this.titol = titol;
        this.autor = autor;
        this.editorial = editorial;
        this.data_prestec = data_prestec;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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

    public Date getData_prestec() {
        return data_prestec;
    }

    public void setData_prestec(Date data_prestec) {
        this.data_prestec = data_prestec;
    }

    @Override
    public String toString() {
        return "Llibre{" + "isbn=" + isbn + ", titol=" + titol + ", autor=" + autor + ", editorial=" + editorial + ", data_prestec=" + data_prestec + '}';
    }

}
