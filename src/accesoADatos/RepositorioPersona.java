package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Oficina;
import clases.Persona;

public class RepositorioPersona {
	RepositorioDireccion repoDireccion = new RepositorioDireccion();
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public ArrayList<Persona> getPersona(String dni){
		
		ArrayList<Persona> arrayPersona = new ArrayList<Persona>();
		Persona persona = null;
		
		
		try {
			ConexionBD con = new ConexionBD();
			Connection conexion = con.getConnection();
			
			ps=conexion.prepareStatement("SELECT * from persona_java where dni= '"+dni+"'");
			rs=ps.executeQuery();

			while(rs.next()) {
				persona= new Persona(rs.getString("dni"), rs.getString("nombre"), rs.getString("ap1"),rs.getString("ap2"),rs.getDate("fecha_nac"), repoDireccion.getDireccion(rs.getInt("direccion")));
				arrayPersona.add(persona);
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return arrayPersona;
	}
}
