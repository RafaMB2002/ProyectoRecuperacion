package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import clases.Direccion;


public class RepositorioDireccion {
	
	/*Devuelve un ArrayList de una direccion en especifico
	 * 
	 */
	public static Direccion getDireccion(int codigo){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Direccion direccion = null;
		
		try {
			
			
			ps=ConexionBD.cn.prepareStatement("SELECT * from direccion_java where cod_direccion= '"+codigo+"'");
			rs=ps.executeQuery();

			while(rs.next()) {
				direccion= new Direccion(rs.getInt("cod_direccion"),rs.getString("nombre_via"),rs.getInt("num_via"),rs.getInt("cod_postal"));
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return direccion;
	}
	/*
	 * Devuelve un ArrayList de todas las direcciones
	 */
	public static Vector<Direccion> getDirecciones(){
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vector<Direccion> vectorDirecciones = new Vector<Direccion>();
		Direccion direccion = null;
		
		
		try {
			
			ps=ConexionBD.cn.prepareStatement("SELECT * from direccion_java");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				direccion= new Direccion(rs.getInt("cod_direccion"),rs.getString("nombre_via"),rs.getInt("num_via"),rs.getInt("cod_postal"));
				vectorDirecciones.add(direccion);
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return vectorDirecciones;
	}
	/*
	 * Crea una nueva direccion
	 */
	public static void newDireccion(Direccion direccion){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
			try {
				
				
				
				ps = ConexionBD.cn.prepareStatement("INSERT INTO direccion_java VALUES(?,?,?,?)");
				ps.setInt(1, direccion.getCodigo_direccion());
				ps.setString(2, direccion.getNombre_via());
				ps.setInt(3, direccion.getNum_via());
				ps.setInt(4, direccion.getCod_postal());
				
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Direccion creada correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
				}
				
				ConexionBD.cn.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error :"+ex);
			}
			
		}
	/*
	 * Actualiza una direccion
	 */
	public static void updateDireccion(Direccion direccion){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
			try {
				
				
					ps = ConexionBD.cn.prepareStatement("UPDATE direccion_java set nombre_via=?, num_via=?, cod_postal=? where cod_direccion=?");
					
					ps.setString(1, direccion.getNombre_via());
					ps.setInt(2, direccion.getNum_via());
					ps.setInt(3, direccion.getCod_postal());
					ps.setInt(4, direccion.getCodigo_direccion());
					
					int resultado = ps.executeUpdate();
					
					if(resultado>0) {
						JOptionPane.showMessageDialog(null, "Direccion actualizada correctamente");
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
					}
				
				
				ConexionBD.cn.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error :"+ex);
			}
			
			
		}
	/*
	 * Elimina una direccion
	 */
	public static void deleteDireccion(int codigo_direccion){
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			
			
			ps = ConexionBD.cn.prepareStatement("DELETE FROM direccion_java where cod_direccion=?");
			ps.setInt(1, codigo_direccion);
			
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
