
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="select * from clientes";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setId(rs.getInt("clie_id"));
                per.setNombre(rs.getString("clie_nombres"));
                per.setApellidos(rs.getString("clie_apellidos"));
                per.setDireccion(rs.getString("clie_direccion"));
                per.setTelefono(rs.getString("clie_telefono"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql="select * from clientes where clie_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("clie_id"));
                p.setNombre(rs.getString("clie_nombres"));
                p.setApellidos(rs.getString("clie_apellidos"));
                p.setDireccion(rs.getString("clie_direccion"));
                p.setTelefono(rs.getString("clie_telefono"));
                System.out.print("ver");
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="insert into clientes(clie_nombres,clie_apellidos,clie_direccion,clie_telefono)"
               + "values('"+per.getNombre()+"','"+per.getApellidos()+"','"+per.getDireccion()+"','"+per.getTelefono()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
          
        }
       return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql="update clientes set clie_nombres='"+per.getNombre()+"',clie_apellidos='"+per.getApellidos()+"',clie_direccion='"+per.getDireccion()+"',clie_telefono='"+per.getTelefono()+"' where clie_id="+per.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from clientes where clie_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
