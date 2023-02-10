/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author juang
 */
public class ListaClientes {
    private ArrayList<Persona> lista;

    public ListaClientes(ArrayList<Persona> lista) {
        this.lista = lista;
    }
    
    public ListaClientes() {
        this.lista = new ArrayList();
    }

    public ArrayList<Persona> getLista() {
        return lista;
    }
    
    public ArrayList<Persona> getLista(String filtro) { 
        if (filtro.equals("")) return lista;
        ArrayList<Persona> result = new ArrayList();
        for (Persona persona : lista) {
            String cargo = persona.getCargo();
            if(cargo.toLowerCase().equals(filtro.toLowerCase())) {
                result.add(persona);
            }
        }
        return result;
    }

    public void setLista(ArrayList<Persona> lista) {
        this.lista = lista;
    }
    
}
