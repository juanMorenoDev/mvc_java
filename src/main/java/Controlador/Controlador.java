/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ListaClientes;
import Modelo.Persona;
import Vista.Formulario;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juang
 */
public class Controlador implements ActionListener {

    ListaClientes lista;
    Formulario form;

    public Controlador() {
        this.lista = new ListaClientes();
        this.form = new Formulario();
    }

    public void iniciar() {
        form.getBtnAgregar().addActionListener(this);
        form.getBtnBuscar().addActionListener(this);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(form.getBtnAgregar())) {
            Persona persona = new Persona(
                    form.getTxtNombre().getText(),
                    form.getTxtCargo().getText()
            );
            lista.getLista().add(persona);
            JOptionPane.showMessageDialog(form, "Persona creada: \n" + persona.toString());
            iniciarControles(form.getPanelRegistro().getComponents());
        }
        if (e.getSource().equals(form.getBtnBuscar())) {
            iniciarTabla(form.getTblClientes());
            String filtro = form.getTxtBuscarCargo().getText();
            DefaultTableModel tabla = (DefaultTableModel) form.getTblClientes().getModel();
            for (Persona persona : lista.getLista(filtro)) {
                tabla.addRow(
                        new Object[]{persona.getNombre(), persona.getCargo()}
                );
            }
            
        }
    }

    public void iniciarTabla(JTable tabla) {
        DefaultTableModel clientes = (DefaultTableModel) tabla.getModel();
        for (int i = clientes.getRowCount() - 1; i >= 0; i--) {
            clientes.removeRow(i);
        }
    }

    public void iniciarControles(Component[] controles) {
        for (Object control : controles) {
            if (control instanceof JTextField) {
                ((JTextField) control).setText("");
            }
        }
    }
}
