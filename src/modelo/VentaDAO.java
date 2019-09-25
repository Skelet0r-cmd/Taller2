/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ccastill
 */
public class VentaDAO {
    
    Conexion con;

    public VentaDAO() {
        this.con = new Conexion();
    }

    public ArrayList<Venta> getVentas() {

        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM venta ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                String sucursal = resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                String fecha = resultados.getString("fecha");
                int id_Vendedor = resultados.getInt("id_Vendedor");
                ventas.add(new Venta(sucursal, monto, fecha, id_Vendedor));
            }
            // accesoBD.close();
            return ventas;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }

    public Venta getVenta(int id) {
        Venta p = new Venta();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM persona WHERE id=" + id + ";";

            Statement st = accesoBD.createStatement(); //Objeto que viaja hasta la base de datos y lleva la consulta
            ResultSet resultados = st.executeQuery(sql); //Resultados enviados de vuelta

            //tambien se puede hacer con if y con resultados.first();
            while (resultados.next()) { //es una iterador propio de resultset que entrega un boleano y cambia a la siguiente tupla para obtener datos de todas las tuplas.
                String sucursal = resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                String fecha = resultados.getString("fecha");
                int id_Vendedor = resultados.getInt("id_Vendedor");
                p = new Venta(sucursal, monto, fecha, id_Vendedor);
            }
            if (p.getId_Vendedor()== 0) {
                System.out.println("No se ha encontrado información sobre el id: " + id);
            }
            return p;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertarVenta(Venta p) {
        Connection accesoBD = con.getConexion();

        try {
            //INSERT INTO  persona (nombre,apellido,edad) VALUES ('Pedro','Puentes',18)
            String sql = "INSERT INTO venta (sucursal,monto,fecha,id_vendedor) "
                    + "VALUES('" + p.getSucursal()+ "'," + p.getMonto()+ ",'" + p.getFecha()+ "',"+p.getId_Vendedor()+")";

            Statement st = accesoBD.createStatement();
            st.execute(sql);//execute update es para modificar la BD.
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar");
            return false;
        }
    }
}
