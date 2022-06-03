package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
				programador= new Programador();
				arrayProgramador.add(programador);
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return arrayProgramador;
	}
}
