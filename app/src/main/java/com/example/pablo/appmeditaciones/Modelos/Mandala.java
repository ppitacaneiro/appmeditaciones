package com.example.pablo.appmeditaciones.Modelos;

import java.io.Serializable;

public class Mandala implements Serializable {

    private int id;
    private String nombre;
    private String grafico;
    private String mantraOriginal;
    private String mantraTraducido;
    private String urlMusicaMeditacion;
    private String urlVideoMeditacion;

    public Mandala() {
    }

    public Mandala(int id, String nombre, String grafico, String mantraOriginal, String mantraTraducido, String urlMusicaMeditacion, String urlVideoMeditacion) {
        this.id = id;
        this.nombre = nombre;
        this.grafico = grafico;
        this.mantraOriginal = mantraOriginal;
        this.mantraTraducido = mantraTraducido;
        this.urlMusicaMeditacion = urlMusicaMeditacion;
        this.urlVideoMeditacion = urlVideoMeditacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrafico() {
        return grafico;
    }

    public void setGrafico(String grafico) {
        this.grafico = grafico;
    }

    public String getMantraOriginal() {
        return mantraOriginal;
    }

    public void setMantraOriginal(String mantraOriginal) {
        this.mantraOriginal = mantraOriginal;
    }

    public String getMantraTraducido() {
        return mantraTraducido;
    }

    public void setMantraTraducido(String mantraTraducido) {
        this.mantraTraducido = mantraTraducido;
    }

    public String getUrlMusicaMeditacion() {
        return urlMusicaMeditacion;
    }

    public void setUrlMusicaMeditacion(String urlMusicaMeditacion) {
        this.urlMusicaMeditacion = urlMusicaMeditacion;
    }

    public String getUrlVideoMeditacion() {
        return urlVideoMeditacion;
    }

    public void setUrlVideoMeditacion(String urlVideoMeditacion) {
        this.urlVideoMeditacion = urlVideoMeditacion;
    }

    @Override
    public String toString() {
        return "Mandala{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", grafico='" + grafico + '\'' +
                ", mantraOriginal='" + mantraOriginal + '\'' +
                ", mantraTraducido='" + mantraTraducido + '\'' +
                ", urlMusicaMeditacion='" + urlMusicaMeditacion + '\'' +
                ", urlVideoMeditacion='" + urlVideoMeditacion + '\'' +
                '}';
    }
}
