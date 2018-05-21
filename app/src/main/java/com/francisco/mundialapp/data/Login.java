package com.francisco.mundialapp.data;

/**
 * Created by jhovy on 12/05/2018.
 */

public class Login {

    String cedula, clave;

    public Login( ) {

    }

    public Login(String cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
