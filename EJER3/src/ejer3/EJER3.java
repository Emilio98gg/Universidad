/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer3;

import java.util.Scanner;

/**
 *
 * @author ReMiGiO
 */
public class EJER3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      Scanner entrada = new Scanner (System.in); 
      int tipo;
      int op1;
      int op2;
      int op3;
      
      System.out.print("Digite 1 si es Fondista, 2 si es Ciclista y 3 si es jugador de ajedrez");
      tipo = entrada.nextInt(0);
      
       System.out.print("el tipo de deporte es "+tipo );
      
      System.out.print("si es Fondista Digite 1 si desea avanzar o digite  2 si desea detenerse");
      op1 = entrada.nextInt(0);
      
      if(op1 == 1){
          System.out.print("avanzando sobre el camino ");}
      else
       System.out.print("Llegando a la meta!");
       
       
       System.out.print("si es Ciclista Digite 1 si desea avanzar o digite  2 si desea detenerse");
      op2 = entrada.nextInt(0);
      
      if(op2== 1){
          System.out.print("avanzando sobre la ruta ");}
      else
       System.out.print("Cruzando la meta!");
          
        System.out.print("Si es Jugador de Ajedrez Digite 1 si desea avanzar o digite  2 si desea detenerse");
      op3 = entrada.nextInt(0);
      
      if( op3 == 1){
          System.out.print("nada que hacer. Yo no corro ");}
      else
       System.out.print("Jacque Mate");
        // TODO code application logic here
    }
    
}
