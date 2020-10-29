
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDjue;
import Modelo.Juego;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JuegoDAO implements CRUDjue{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Juego p=new Juego();
    
    @Override
    public List listar() {
        ArrayList<Juego>list=new ArrayList<>();
        String sql="select * from juegos";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Juego per=new Juego();
                per.setId(rs.getInt("jueg_id"));
                per.setNombre(rs.getString("jueg_nombre"));
                per.setAnho(rs.getString("jueg_anho"));
                per.setProtagonista(rs.getString("jueg_protagonista"));
                per.setDirector(rs.getString("jueg_director"));
                per.setProductor(rs.getString("jueg_productor"));
                per.setTecnologia(rs.getString("jueg_tecnologia"));
                per.setCantidad(rs.getString("jueg_cantidad"));
                per.setPreciVenta(rs.getString("jueg_precio_venta"));
                per.setPrecioAlquiler(rs.getString("jueg_precio_alquiler"));
                
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    
    public Juego list(int id) {
        String sql="select * from juegos where jueg_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("jueg_id"));
                p.setNombre(rs.getString("jueg_nombre"));
                p.setAnho(rs.getString("jueg_anho"));
                p.setProtagonista(rs.getString("jueg_protagonista"));
                p.setDirector(rs.getString("jueg_director"));
                p.setProductor(rs.getString("jueg_productor"));
                p.setTecnologia(rs.getString("jueg_tecnologia"));
                p.setCantidad(rs.getString("jueg_cantidad"));              
                p.setPreciVenta(rs.getString("jueg_precio_venta"));
                p.setPrecioAlquiler(rs.getString("jueg_precio_alquiler"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    
    public boolean add(Juego per) {
       String sql="insert into juegos(jueg_nombre,jueg_anho,jueg_protagonista,"
               + "jueg_director,jueg_productor,jueg_tecnologia,jueg_cantidad,"
               + "jueg_precio_venta,jueg_precio_alquiler)"
               + "values('"+per.getNombre()+"','"+per.getAnho()+"','"+per.getProtagonista()+"',"
               + "'"+per.getDirector()+"','"+per.getProductor()+"','"+per.getTecnologia()+"',"
               + "'"+per.getCantidad()+"','"+per.getPreciVenta()+"','"+per.getPrecioAlquiler()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
          
        }
       return false;
    }

    
    @Override
    public boolean edit(Juego per) {
        String sql="update juegos set jueg_nombre='"+per.getNombre()+"',jueg_anho='"+per.getAnho()+"',"
                + "jueg_protagonista='"+per.getProtagonista()+"',jueg_director='"+per.getDirector()+"',"
                + "jueg_productor='"+per.getProductor()+"',jueg_tecnologia='"+per.getTecnologia()+"',"
                + "jueg_cantidad='"+per.getCantidad()+"',jueg_precio_venta='"+per.getPreciVenta()+"', "
                + "jueg_precio_alquiler='"+per.getPrecioAlquiler()+"' where jueg_id="+per.getId();
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
        String sql="delete from juegos where jueg_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
