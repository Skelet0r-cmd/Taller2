/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Vendedor;
import modelo.VendedorDAO;

/**
 *
 * @author Marcelo Esperguel
 */
public class Home extends JFrame {

    private JButton registrarVentaButton;
    private JButton verReporteButton;
    private JComboBox vendedorCb;

    public Home() {
        super("Inicio");
        initComponents();
        //Codigo aquíverReporteButton
        //Acción botón registrar venta.
        registrarVentaButton.addActionListener((evt) -> {
            registrarVentaButton(evt);
        });
        //Acción botón ver reporte.
        verReporteButton.addActionListener((evt) -> {
            verReporteButton(evt);
        });
        setLocationRelativeTo(this);
    }

    private void registrarVentaButton(ActionEvent e/*, JComboBox vendedorCb*/) {
       RegistrarVenta rv = new RegistrarVenta(vendedorCb);
       /* VendedorDAO vendedorDao = new VendedorDAO();
        *ArrayList<Vendedor> vendedores = new ArrayList<>();
        *vendedores = vendedorDao.getVendedores();
        *for (int i = 0; i < vendedores.size(); i++) {
        *    Vendedor vendedor = vendedores.get(i);
        *    vendedorCb.addItem(vendedor);
        }*/
        rv.setVisible(true);
        rv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }
     
    private void verReporteButton(ActionEvent e) {
        Reporte r = new Reporte();
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    private void initComponents() {

        registrarVentaButton = new javax.swing.JButton();
        verReporteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registrarVentaButton.setText("Registrar Venta");

        verReporteButton.setText("Ver Reporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(registrarVentaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(verReporteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(registrarVentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(verReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }
}
