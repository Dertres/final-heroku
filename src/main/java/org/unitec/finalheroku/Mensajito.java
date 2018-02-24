package org.unitec.finalheroku;

import java.time.LocalDate;

public class Mensajito {
    
    private String id;
    private String titulo;
    private String cuerpo;
    private LocalDate fecha;

    public Mensajito(String id) {
        this.id = id;
    }

    public Mensajito(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Mensajito() {
    }

    public Mensajito(String id, String titulo, String cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        fecha=LocalDate.now();
    }

    
}
