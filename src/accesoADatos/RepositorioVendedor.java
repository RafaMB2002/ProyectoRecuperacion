package accesoADatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Programador;
import clases.Vendedor;

public class RepositorioVendedor {
	public static Vendedor getVendedor(String dni){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Vendedor vendedor = null;
		
		
		try {
			
			ps=ConexionBD.cn.prepareStatement("select p.*, e.*, ven.* from persona_java p join empleado_java2 e on p.dni = e.dni join vendedor_java ven on e.dni = ven.dni where p.dni = '"+dni+"'");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				vendedor= new Vendedor(rs.getString("dni"), rs.getString("nombre"), rs.getString("ap1"), rs.getString("ap2"), rs.getString("fecha_nac"), rs.getString("tipo_persona"), RepositorioDireccion.getDireccion(rs.getInt("direccion")),
						rs.getString("fecha_alta"), rs.getString("tipo_empleado"), RepositorioOficina.getOficina(rs.getInt("oficina")), rs.getString("zonas"));
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return vendedor;
	}

	public static ArrayList<Vendedor> getVendedores(){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ArrayList<Vendedor> arrayVendedor = new ArrayList<Vendedor>();
		Vendedor vendedor = null;
		
		
		try {
			
			ps=ConexionBD.cn.prepareStatement("select p.*, e.*, ven.* from persona_java p join empleado_java2 e on p.dni = e.dni join vendedor_java ven on e.dni = ven.dni");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				vendedor= new Vendedor(rs.getString("dni"), rs.getString("nombre"), rs.getString("ap1"), rs.getString("ap2"), rs.getString("fecha_nac"), rs.getString("tipo_persona"), RepositorioDireccion.getDireccion(rs.getInt("direccion")),
						rs.getString("fecha_alta"), rs.getString("tipo_empleado"), RepositorioOficina.getOficina(rs.getInt("oficina")), rs.getString("zonas"));
				arrayVendedor.add(vendedor);
			}
			
			rs.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: "+ex);
		}
		return arrayVendedor;
	}
	
	public static void newVendedor(Vendedor vendedor){
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("INSERT INTO persona_java VALUES(?,?,?,?,TO_DATE('"+vendedor.getFecha_nac()+"','DD-MM-YYYY'),?,?)");
			ps.setString(1, vendedor.getDni());
			ps.setString(2, vendedor.getNombre());
			ps.setString(3, vendedor.getAp1());
			ps.setString(4, vendedor.getAp2());
			ps.setInt(5, vendedor.getDireccion().getCodigo_direccion());
			ps.setString(6, vendedor.getTipo_persona());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "persona creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}

		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("INSERT INTO empleado_java2 VALUES(?,TO_DATE('"+vendedor.getFecha_alta()+"','DD-MM-YYYY'),?,?)");
			ps.setString(1, vendedor.getDni());
			ps.setInt(2, vendedor.getOficina().getCodigo());
			ps.setString(3, vendedor.getTipo_empleado());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Empleado creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("INSERT INTO vendedor_java VALUES(?,?)");
			ps.setString(1, vendedor.getDni());
			ps.setString(2, vendedor.getZona());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Vendedor creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo crear, falta algun dato");
			}
			
			ConexionBD.cn.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
	}
	
	public static void updateVendedor(Vendedor vendedor){
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			
			ps = ConexionBD.cn.prepareStatement("UPDATE persona_java set nombre=?, ap1=?, ap2=?, fecha_nac = TO_DATE('"+vendedor.getFecha_nac()+"','DD-MM-YYYY'), direccion=?, tipo_persona=? where dni=?");
			
			ps.setString(1, vendedor.getNombre());
			ps.setString(2, vendedor.getAp1());
			ps.setString(3, vendedor.getAp2());
			ps.setInt(4, vendedor.getDireccion().getCodigo_direccion());
			ps.setString(5, vendedor.getTipo_persona());
			ps.setString(6, vendedor.getDni());
			
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
			
			ps = ConexionBD.cn.prepareStatement("UPDATE empleado_java2 set fecha_alta = TO_DATE('"+vendedor.getFecha_alta()+"','DD-MM-YYYY'), oficina=?, tipo_empleado=? where dni=?");
			
			ps.setInt(1, vendedor.getOficina().getCodigo());
			ps.setString(2, vendedor.getTipo_empleado());
			ps.setString(3, vendedor.getDni());
			
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
			}
			
	}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, "Error :"+ex);
	}
		
		try {
			
			ps = ConexionBD.cn.prepareStatement("UPDATE vendedor_java set zonas=? where dni=?");
			
			ps.setString(1, vendedor.getZona());
			ps.setString(2, vendedor.getDni());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Vendedor actualizado correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo actualizar, falta algun dato");
			}
		
		
		ConexionBD.cn.close();
	}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, "Error :"+ex);
	}
		
	}
	
	public static void deleteVendedor(String dni){
		PreparedStatement ps=null;
		ResultSet rs=null;
			try {
				
				ps = ConexionBD.cn.prepareStatement("DELETE FROM vendedor_java where dni=?");
				ps.setString(1, dni);
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Vendedor eliminado correctamente");
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
