package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import clases.Direccion;


public class RepositorioDireccion {
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public ArrayList<Direccion> getDireccion(int codigo){
		
		ArrayList<Direccion> arrayDireccion = new ArrayList<Direccion>();
		Direccion direccion = null;
		
		
		try {
			ConexionBD con = new ConexionBD();
			Connection conexion = con.getConnection();
			
			ps=conexion.prepareStatement("SELECT * from direccion_java where cod_direccion= '"+codigo+"'");
			rs=ps.executeQuery();

			while(rs.next()) {
				direccion= new Direccion(rs.getInt("cod_direccion"),rs.getString("nombre_via"),rs.getInt("num_via"),rs.getInt("cod_postal"));
				arrayDireccion.add(direccion);
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return arrayDireccion;
	}
	
	public ArrayList<Direccion> getDirecciones(){
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Direccion> vectorDirecciones = new ArrayList<Direccion>();
		Direccion direccion = null;
		
		
		try {
			ConexionBD con = new ConexionBD();
			Connection conexion = con.getConnection();
			
			ps=conexion.prepareStatement("SELECT * from direccion_java");
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
	
	public void newDireccion(int codigo_direccion, String nombre_via, int num_via, int cod_postal){
			
			try {
				
				ConexionBD con = new ConexionBD();
				Connection conexion = con.getConnection();
				
				ps = conexion.prepareStatement("INSERT INTO direccion_java VALUES(?,?,?,?)");
				ps.setInt(1, codigo_direccion);
				ps.setString(2, nombre_via);
				ps.setInt(3, num_via);
				ps.setInt(4, cod_postal);
				
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Direccion creada correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
				}
				
				conexion.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error :"+ex);
			}
			
		}
	
	public void updateDireccion(int codigo_direccion, String nombre_via, int num_via, int cod_postal){
			
			try {
				ConexionBD con = new ConexionBD();
				Connection conexion = con.getConnection();
				
					ps = conexion.prepareStatement("UPDATE direccion_java set nombre_via=?, num_via=?, cod_postal=? where cod_direccion=?");
					
					ps.setString(1, nombre_via);
					ps.setInt(2, num_via);
					ps.setInt(3, cod_postal);
					ps.setInt(4, codigo_direccion);
					
					int resultado = ps.executeUpdate();
					
					if(resultado>0) {
						JOptionPane.showMessageDialog(null, "Direccion actualizada correctamente");
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
					}
				
				
				conexion.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error :"+ex);
			}
			
			
		}
	public void deleteDireccion(int codigo_direccion){
		
		try {
			ConexionBD con = new ConexionBD();
			Connection conexion = con.getConnection();
			
			ps = conexion.prepareStatement("DELETE FROM direccion_java where cod_direccion=?");
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
