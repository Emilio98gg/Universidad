/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automotores;
/**
 *
 * @author ReMiGiO
 */
public class Automotores {
  //public class Producto implements Serializable{
    int anno;
    String placa;
    String marca;   
    String modelo;  
    String combustible;
    String trasmision; 
    String kiliometraje;
    
    public Automotores (int anno, String placa, String marca, String modelo, String combustible, String trasmision, String kilometraje){
        
        this.anno = anno;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.trasmision = trasmision;
        this.kiliometraje = kilometraje;
    }
    
    
    public int getAnno(){
    return anno;
}
public void setAnno(int anno) {
        this.anno = anno;
}



public String getPlaca(){
    return placa;
}
public void setPlaca(String placa) {
        this.placa = placa;
}



public String getMarca(){
    return marca;
}
public void setMarca(String marca) {
        this.marca = marca;
}


public String getModelo(){
    return modelo;
}
public void setModelo(String modelo) {
        this.modelo = modelo;
}



public String getCombustible(){
    return combustible;
}
public void setCombustible(String combustible) {
        this.combustible = combustible;
}


public String getTrasmision(){
    return trasmision;
}
public void setTrasmision(String trasmision) {
        this.trasmision = trasmision;
}


public String getKiliometraje(){
    return kiliometraje;
}
public void setKiliometraje(String kiliometraje) {
        this.kiliometraje = kiliometraje;
}
    
}
