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
import clases.Oficina;
import clases.Programador;

public class RepositorioProgramador {
	
	public static ArrayList<Programador> getProgramador(int dni){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ArrayList<Programador> arrayProgramador = new ArrayList<Programador>();
		Programador programador = null;
		
		
		try {
			
			ps=ConexionBD.cn.prepareStatement("SELECT * from oficina_java2 where codigo= '"+dni+"'");
			rs=ps.executeQuery();

			while(rs.next()) {
				//programador= new Programador();
				arrayProgramador.add(programador);
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return arrayProgramador;
	}
	
	private static void crearProgramador(String dni, String tecnologia) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		//Insert de programador
				try {
							
							ps = ConexionBD.cn.prepareStatement("INSERT INTO programador_java VALUES(?,?)");
							ps.setString(1, dni);
							ps.setString(2, tecnologia);
							
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
	
	public static void crearPersona(String dni, String nombre, String ap1, String ap2, String fecha_nac, int direccion,
			String tipoPersona) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		//Insert de Persona
		try {
					
					ps = ConexionBD.cn.prepareStatement("INSERT INTO persona_java VALUES(?,?,?,?,?,?,?)");
					ps.setString(1, dni);
					ps.setString(2, nombre);
					ps.setString(3, ap1);
					ps.setString(4, ap2);
					ps.setDate(5, Date.valueOf(fecha_nac));
					ps.setInt(6, direccion);
					ps.setString(7, tipoPersona);
					
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
	}
	
	private static void crearEmpleado(String dni, String fecha_alta, int oficina, String tipoEmpleado) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		//Insert de empleado
				try {
					
					ps = ConexionBD.cn.prepareStatement("INSERT INTO empleado_java2 VALUES(?,?,?,?)");
					ps.setString(1, dni);
					ps.setDate(2, Date.valueOf(fecha_alta));
					ps.setInt(3, oficina);
					ps.setString(4, tipoEmpleado);
					
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
	}
	
	public static void newProgramador(String dni, String nombre, String ap1, String ap2, String fecha_nac, int direccion,
			String tipoPersona, String fecha_alta, int oficina, String tipoEmpleado, String tecnologia){
		//String [] tecno = tecnologia.split("#");
		
		crearPersona(dni, nombre, ap1, ap2, fecha_nac, direccion, tipoPersona);
		crearEmpleado(dni, fecha_alta, oficina, tipoEmpleado);
		crearProgramador(dni, tecnologia);
		
	}
}
