package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Direccion;
import clases.Oficina;

public class RepositorioOficina {
	RepositorioDireccion repoDireccion = new RepositorioDireccion();
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public ArrayList<Oficina> getOficina(int codigo){
			
			ArrayList<Oficina> arrayOficina = new ArrayList<Oficina>();
			Oficina oficina = null;
			
			
			try {
				ConexionBD con = new ConexionBD();
				Connection conexion = con.getConnection();
				
				ps=conexion.prepareStatement("SELECT * from oficina_java2 where codigo= '"+codigo+"'");
				rs=ps.executeQuery();
	
				while(rs.next()) {
					oficina= new Oficina(rs.getInt("codigo"), rs.getString("nombre"), repoDireccion.getDireccion(rs.getInt("direccion")));
					arrayOficina.add(oficina);
				}
				
				rs.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: "+ex);
			}
			return arrayOficina;
		}
	
	public ArrayList<Oficina> getOficinas(){
			
			ArrayList<Oficina> vectorOficinas = new ArrayList<Oficina>();
			Oficina oficina = null;
			
			
			try {
				ConexionBD con = new ConexionBD();
				Connection conexion = con.getConnection();
				
				ps=conexion.prepareStatement("SELECT * from oficina_java2");
				rs=ps.executeQuery();
				
				while(rs.next()) {
					oficina= new Oficina(rs.getInt("codigo"), rs.getString("nombre"), repoDireccion.getDireccion(rs.getInt("direccion")));
					vectorOficinas.add(oficina);
				}
				
				rs.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: "+ex);
			}
			return vectorOficinas;
		}
	
	public void newOficina(int codigo, String nombre, int direccion){
		
		try {
			
			ConexionBD con = new ConexionBD();
			Connection conexion = con.getConnection();
			
			ps = conexion.prepareStatement("INSERT INTO oficina_java2 VALUES(?,?,?)");
			ps.setInt(1, codigo);
			ps.setString(2, nombre);
			ps.setInt(3, direccion);
			
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Oficina creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}
			
			conexion.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
	}
	public void updateOficina(int codigo, String nombre, int direccion){
		
		try {
			ConexionBD con = new ConexionBD();
			Connection conexion = con.getConnection();
			
				ps = conexion.prepareStatement("UPDATE oficina_java2 set nombre=?, direccion=? where codigo=?");
				
				ps.setString(1, nombre);
				ps.setInt(2, direccion);
				ps.setInt(3, codigo);
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Oficina actualizada correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
				}
			
			
			conexion.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
		
	}
public void deleteOficina(int codigo){
		
		try {
			ConexionBD con = new ConexionBD();
			Connection conexion = con.getConnection();
			
			ps = conexion.prepareStatement("DELETE FROM oficina_java2 where codigo=?");
			ps.setInt(1, codigo);
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Direccion eliminada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo eliminar");
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
	}
}
