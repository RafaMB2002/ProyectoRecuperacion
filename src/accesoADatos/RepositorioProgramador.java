package accesoADatos;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Date;

import javax.swing.JOptionPane;

import clases.Direccion;
import clases.Empleado;
import clases.Oficina;
import clases.Persona;
import clases.Programador;

public class RepositorioProgramador {
	/*
	 * Devuelve un ArrayList de un programador en especifico
	 */
	public static Programador getProgramador(String dni){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Programador programador = null;
		
		
		try {
			
			ps=ConexionBD.cn.prepareStatement("select p.*, e.*, pro.* from persona_java p join empleado_java2 e on p.dni = e.dni join programador_java pro on e.dni = pro.dni where p.dni = '"+dni+"'");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String [] tecno = rs.getString("tecnologias").split("#");
				ArrayList<String> tecnologia = new ArrayList<String>();
				
				for (int i = 0; i < tecno.length; i++)
		            tecnologia.add(tecno[i]);
				
				programador= new Programador(rs.getString("dni"), rs.getString("nombre"), rs.getString("ap1"), rs.getString("ap2"), rs.getString("fecha_nac"), rs.getString("tipo_persona"), RepositorioDireccion.getDireccion(rs.getInt("direccion")),
						rs.getString("fecha_alta"), rs.getString("tipo_empleado"), RepositorioOficina.getOficina(rs.getInt("oficina")), tecnologia);
				
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return programador;
	}
	/*
	 * Devuelve un ArrayList de todos los programadores
	 */
	public static ArrayList<Programador> getProgramadores(){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ArrayList<Programador> arrayProgramador = new ArrayList<Programador>();
		Programador programador = null;
		
		
		try {
			
			ps=ConexionBD.cn.prepareStatement("select p.*, e.*, pro.* from persona_java p join empleado_java2 e on p.dni = e.dni join programador_java pro on e.dni = pro.dni");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String [] tecno = rs.getString("tecnologias").split("#");
				ArrayList<String> tecnologia = new ArrayList<String>();
				
				for (int i = 0; i < tecno.length; i++)
		            tecnologia.add(tecno[i]);
				
				programador= new Programador(rs.getString("dni"), rs.getString("nombre"), rs.getString("ap1"), rs.getString("ap2"), rs.getString("fecha_nac"), rs.getString("tipo_persona"), RepositorioDireccion.getDireccion(rs.getInt("direccion")),
						rs.getString("fecha_alta"), rs.getString("tipo_empleado"), RepositorioOficina.getOficina(rs.getInt("oficina")), tecnologia);
				arrayProgramador.add(programador);
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return arrayProgramador;
	}
	
	/*
	 * Crea un nuevo programador
	 */
	public static void newProgramador(Programador programador){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("INSERT INTO persona_java VALUES(?,?,?,?,TO_DATE('"+programador.getFecha_nac()+"','DD-MM-YYYY'),?,?)");
			ps.setString(1, programador.getDni());
			ps.setString(2, programador.getNombre());
			ps.setString(3, programador.getAp1());
			ps.setString(4, programador.getAp2());
			ps.setInt(5, programador.getDireccion().getCodigo_direccion());
			ps.setString(6, programador.getTipo_persona());
			
			int resultado = ps.executeUpdate();
			
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "persona creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}
			ConexionBD.cn.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("INSERT INTO empleado_java2 VALUES(?,TO_DATE('"+programador.getFecha_alta()+"','DD-MM-YYYY'),?,?)");
			ps.setString(1, programador.getDni());
			ps.setInt(2, programador.getOficina().getCodigo());
			ps.setString(3, programador.getTipo_empleado());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "empleado creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}
			ConexionBD.cn.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
		ArrayList<String> tecnos = programador.getTecnologia();
		String tecnologias = "";
		for (String tecno : tecnos) {
			tecnologias+= tecno+"#";
		}
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("INSERT INTO programador_java VALUES(?,?)");
			ps.setString(1, programador.getDni());
			ps.setString(2, tecnologias);
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "programador creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}
			
			ConexionBD.cn.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
	}

	
	public static void updateProgramador(Programador programador){
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			
			ps = ConexionBD.cn.prepareStatement("UPDATE persona_java set nombre=?, ap1=?, ap2=?, fecha_nac = TO_DATE('"+programador.getFecha_nac()+"','DD-MM-YYYY'), direccion=?, tipo_persona=? where dni=?");
			
			ps.setString(1, programador.getNombre());
			ps.setString(2, programador.getAp1());
			ps.setString(3, programador.getAp2());
			ps.setInt(4, programador.getDireccion().getCodigo_direccion());
			ps.setString(5, programador.getTipo_persona());
			ps.setString(6, programador.getDni());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Persona actualizada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
			}
			
	}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, "Error :"+ex);
	}
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("UPDATE empleado_java2 set fecha_alta = TO_DATE('"+programador.getFecha_alta()+"','DD-MM-YYYY'), oficina=?, tipo_empleado=? where dni=?");
			
			ps.setInt(1, programador.getOficina().getCodigo());
			ps.setString(2, programador.getTipo_empleado());
			ps.setString(3, programador.getDni());
			
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
			}
			
	}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, "Error :"+ex);
	}
		ArrayList<String> tecnos = programador.getTecnologia();
		String tecnologias = "";
		for (String tecno : tecnos) {
			tecnologias+= tecno+"#";
		}
		try {
			
			ps = ConexionBD.cn.prepareStatement("UPDATE programador_java set tecnologias=? where dni=?");
			
			ps.setString(1, tecnologias);
			ps.setString(2, programador.getDni());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Programador actualizado correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
			}
		
		
		ConexionBD.cn.close();
	}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, "Error :"+ex);
	}
		
	}
	
	public static void deleteProgramador(String dni){
		PreparedStatement ps=null;
		ResultSet rs=null;
			try {
				
				ps = ConexionBD.cn.prepareStatement("DELETE FROM programador_java where dni=?");
				ps.setString(1, dni);
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Programador eliminado correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "No se pudo eliminar");
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Error :"+ex);
			}
try {
				
				ps = ConexionBD.cn.prepareStatement("DELETE FROM empleado_java2 where dni=?");
				ps.setString(1, dni);
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "empleado eliminado correctamente");
				}else{
					JOptionPane.showMessageDialog(null, "No se pudo eliminar");
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Error :"+ex);
			}
try {
	
	ps = ConexionBD.cn.prepareStatement("DELETE FROM persona_java where dni=?");
	ps.setString(1, dni);
	
	int resultado = ps.executeUpdate();
	
	if(resultado>0) {
		JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
	}else{
		JOptionPane.showMessageDialog(null, "No se pudo eliminar");
	}
}catch(Exception ex){
	JOptionPane.showMessageDialog(null, "Error :"+ex);
}
		}
	
}
