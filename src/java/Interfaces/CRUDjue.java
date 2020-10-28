
package Interfaces;

import Modelo.Juego;
import java.util.List;


public interface CRUDjue {
    public List listar();
    public Juego list(int id);
    public boolean add(Juego per);
    public boolean edit(Juego per);
    public boolean eliminar(int id);
    
    }
