/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automotores;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ReMiGiO
 */
public class proceso  implements Serializable{
    
     private ArrayList<Object> a = new ArrayList<Object>();
    
    public proceso(){}
    
    public proceso(ArrayList<Object> a){
        this.a = a;
    }
    
    public void agregarRegistro(Automotores p){
        this.a.add(p);
    }

    public void modificarRegistro(int i, Automotores p){
        this.a.set(i, p);
    }
    
    public void eliminarRegistro(int i){
        this.a.remove(i);
    }

    public Automotores obtenerRegistro(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int cantidadRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int buscaPlaca(String leerPlaca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

