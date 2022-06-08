package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Direccion;
import clases.Oficina;

public class RepositorioOficina {
	
	/*
	 * Devuelve un ArrayList de una oficina en especifico
	 */
	public static Oficina getOficina(int codigo){
		PreparedStatement ps=null;
		ResultSet rs=null;
			Oficina oficina = null;
			
			
			try {
				
				ps=ConexionBD.cn.prepareStatement("SELECT * from oficina_java2 where codigo= '"+codigo+"'");
				rs=ps.executeQuery();
	
				while(rs.next()) {
					oficina= new Oficina(rs.getInt("codigo"), rs.getString("nombre"), RepositorioDireccion.getDireccion(rs.getInt("direccion")));
				}
				
				rs.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: "+ex);
			}
			return oficina;
		}
	/*
	 * Devuelve un ArrayList de todas las oficinas
	 */
	public static ArrayList<Oficina> getOficinas(){
		PreparedStatement ps=null;
		ResultSet rs=null;
			ArrayList<Oficina> vectorOficinas = new ArrayList<Oficina>();
			Oficina oficina = null;
			
			
			try {
				
				ps=ConexionBD.cn.prepareStatement("SELECT * from oficina_java2");
				rs=ps.executeQuery();
				
				while(rs.next()) {
					oficina= new Oficina(rs.getInt("codigo"), rs.getString("nombre"), RepositorioDireccion.getDireccion(rs.getInt("direccion")));
					vectorOficinas.add(oficina);
				}
				
				rs.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: "+ex);
			}
			return vectorOficinas;
		}
	/*
	 * Crea una nueva oficina
	 */
	public static void newOficina(Oficina oficina){
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			
			ps = ConexionBD.cn.prepareStatement("INSERT INTO oficina_java2 VALUES(?,?,?)");
			ps.setInt(1, oficina.getCodigo());
			ps.setString(2, oficina.getNombre());
			ps.setInt(3, oficina.getDireccion().getCodigo_direccion());
			
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Oficina creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}
			
			ConexionBD.cn.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
	}
	/*
	 * Actualiza una oficina
	 */
	public static void updateOficina(Oficina oficina){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			
				ps = ConexionBD.cn.prepareStatement("UPDATE oficina_java2 set nombre=?, direccion=? where codigo=?");
				
				ps.setString(1, oficina.getNombre());
				ps.setInt(2, oficina.getDireccion().getCodigo_direccion());
				ps.setInt(3, oficina.getCodigo());
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Oficina actualizada correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
				}
			
			
			ConexionBD.cn.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
		
	}
	/*
	 * Elimina una oficina
	 */
public static void deleteOficina(int codigo){
	PreparedStatement ps=null;
	ResultSet rs=null;
		try {
			
			ps = ConexionBD.cn.prepareStatement("DELETE FROM oficina_java2 where codigo=?");
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
