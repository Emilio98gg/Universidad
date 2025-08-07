/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import automotores.Automotores;
import automotores.limpiartxt;
import automotores.proceso;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ReMiGiO
 * 
 */
 
public class menu1 extends javax.swing.JFrame {

    /**
     * Creates new form menu1
     *
     */
        limpiartxt lt = new limpiartxt();
    
    private String ruta_txt = "mi.txt"; 
    
    Automotores p;
    proceso rp;
    
    int clic_tabla;
    public menu1() {
        initComponents();
        
        rp = new proceso();
        
        try{
            cargar_txt();
            registro();
        }catch(Exception ex){
            mensaje("No existe el archivo txt");
        }
    }
    
         public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
     
     public void cargar_txt(){
       // File ruta = new File(ruta_txt);
        try{
            FileInputStream fis = new FileInputStream(ruta_txt);
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null){
                rp = (proceso)in.readObject();
                in.close();
                
            }
            
           
        }catch(Exception ex){
            mensaje("Error al cargar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
     
     public void grabar_txt(){
       // FileWriter fw;
       // PrintWriter pw;
        FileOutputStream fos;
        ObjectOutputStream Out;
        
        try{
           // fw = new FileWriter(ruta_txt);
            //pw = new PrintWriter(fw);
            fos = new FileOutputStream(ruta_txt);
            Out = new ObjectOutputStream(fos);
            if(Out != null){
                Out.writeObject(rp);
                Out.close();
            }
           
        }catch(Exception ex){
            mensaje("Error al grabar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
     
      public void grabar(){
       // FileWriter fw;
       // PrintWriter pw;
        FileOutputStream fos;
        ObjectOutputStream Out;
        
        try{
           // fw = new FileWriter(ruta_txt);
            //pw = new PrintWriter(fw);
            fos = new FileOutputStream(ruta_txt);
            Out = new ObjectOutputStream(fos);
            if(Out != null){
                Out.writeObject(rp);
                Out.close();
            }
           
        }catch(Exception ex){
            mensaje("Error al grabar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
      
         
    public void ingresarRegistro(File ruta){
        try{
           if(leerPlaca() == null)mensaje("Ingresar Año");
            else if(leerAnno() == null)mensaje("Ingresar numero de placa");
            else if(leerMarca() == null) mensaje("Ingresar Marca");
            else if(leerModelo() == null)mensaje("Ingresar Modelo");
            else if(leerCombustible() == null)mensaje("Ingresar tipo de Combustible");
            else if(leerTrasmision() == null)mensaje("Ingresar tipo de  Trasmision");
            else if(leerKilometraje() == null)mensaje("Ingresar Kilometraje");
            else{
                p = new persona(leerAnno(), leerPlaca(), leerMarca(), leerModelo(), leerCombustible(), leerTrasmision(),  leerKilometraje());
                if(rp.Placa(p.getPlaca())!= -1)mensaje("Este Placa ya existe");
                else rp.agregarRegistro(p);
                
                grabar_txt();
                registro();
                lt.limpiartxt(jPanel1); 
            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }
     
      public void modificarRegistro(File ruta){
        try{
            if(leerPlaca() == null)mensaje("Ingresar Año");
              else if(leerAnno() == null)mensaje("Ingresar numero de placa");
              else if(leerMarca() == null) mensaje("Ingresar Marca");
              else if(leerModelo() == null)mensaje("Ingresar Modelo");
              else if(leerCombustible() == null)mensaje("Ingresar tipo de Combustible");
              else if(leerTrasmision() == null)mensaje("Ingresar tipo de  Trasmision");
              else if(leerKilometraje() == null)mensaje("Ingresar Kilometraje");
              else{
                String Placa = rp.buscaPlacaleerPlaca());
                if(placa.getText().equalsIgnoreCase("")) 
                p = new Automotores(leerPlaca(), leerAnno(), leerMarca(), leerModelo(), leerCombustible(), leerTrasmision(), leerKilometraje());                   
               else p = new Automotores (leerPlaca(), leerAnno(), leerModelo(), leerCombustible(), leerTrasmision(), leerKilometraje());
                
                if(Placa == -1)rp.agregarRegistro(p);
                else rp.modificarRegistro(Placa, p);
                
                grabar_txt();
                listarRegistro();
                lt.limpiartxt(jPanel1);
            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }
      
      public void eliminarRegistro(){
        try{
            if(leerPlaca() == nullmensaje("Ingrese Numero de placa ");
            
            else{
                int Placa = rp.buscaPlaca(leerPlaca());
                if(Placa == -1) mensaje("Placa no existe");
                
                else{
                    int s = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere eliminar este  Auto ","Si/No",0);
                    if(s == 0){
                        rp.eliminarRegistro(Placa);
                        
                        grabar_txt();
                        listarRegistro();
                        lt.limpiartxt(jPanel1);
                    }
                }
                
                
            }
        }catch(Exception ex){
            mensaje(ex.getMessage());
        }
    }
      
       public void listarRegistro(){
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("Placa");
        dt.addColumn("Anno");
        dt.addColumn("Marca");
        dt.addColumn("Modelo");
        dt.addColumn("Combustible");
        dt.addColumn("Trasmision");
        dt.addColumn("Kilometraje");
        
        Object fila[] = new Object[dt.getColumnCount()];
        for(int i = 0; rp.cantidadRegistro() >= i; i++){
            p = rp.obtenerRegistro(i);
            fila[0] = p.getPlaca();
            fila[1] = p.getAnno();
            fila[2] = p.getMarca();
            fila[3] = p.getModelo();
            fila[4] = p.getCombustible();
            fila[5] = p.getTrasmision();
            fila[6] = p.getkilometraje();
           
            dt.addRow(fila);
            
        }
        tablaauto.setModel(dt);
        tablaauto.setRowHeight(60);
    }
       
       public String leerPlaca(){
        try{
            String Placa = placa.getText().trim().replace(" ", "_");
            return Placa;
        }catch(Exception ex){
            return null;
        }
    }
    
    public String leerAnno(){
        try{
            String Anno = anno.getText().trim().replace(" ", "_");
            return Anno;
        }catch(Exception ex){
            return null;
        }
    }
    
     
    public String leerMarca(){
        try{
            String Marca = marca.getText().trim().replace(" ", "_");
            return Marca;
        }catch(Exception ex){
            return null;
        }
    }
    
    public String leerModelo(){
        try{
            String Modelo = modelo.getText().trim().replace(" ", "_");
            return Modelo;
        }catch(Exception ex){
            return null;
        }
    }
    
    public String leerCombustible(){
        try{
            String Combustible = combustible.getText().trim().replace(" ", "_");
            return Combustible;
        }catch(Exception ex){
            return null;
        }
    }

     public String leerKilometraje(){
        try{
            String Kilometraje = kilometraje.getText().trim().replace(" ", "_");
            return Kilometraje;
        }catch(Exception ex){
            return null;
        }
    }

     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        placa = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        modelo = new javax.swing.JLabel();
        anno = new javax.swing.JLabel();
        combustible = new javax.swing.JLabel();
        trasmision = new javax.swing.JLabel();
        kilometraje = new javax.swing.JLabel();
        jtplaca = new javax.swing.JTextField();
        jtmodelo = new javax.swing.JTextField();
        jtcombustible = new javax.swing.JTextField();
        jtmarca = new javax.swing.JTextField();
        jtanno = new javax.swing.JTextField();
        jttrasmision = new javax.swing.JTextField();
        jtkilometraje = new javax.swing.JTextField();
        ingresar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaauto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ravie", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Automoviles");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        placa.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        placa.setForeground(new java.awt.Color(102, 102, 102));
        placa.setText("Placa Del Auto:");
        getContentPane().add(placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        marca.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        marca.setForeground(new java.awt.Color(102, 102, 102));
        marca.setText("Marca Del Auto:");
        getContentPane().add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        modelo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        modelo.setForeground(new java.awt.Color(102, 102, 102));
        modelo.setText(" Modelo Del Auto:");
        getContentPane().add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        anno.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        anno.setForeground(new java.awt.Color(102, 102, 102));
        anno.setText("Año De Fabricacíon:");
        getContentPane().add(anno, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        combustible.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        combustible.setForeground(new java.awt.Color(102, 102, 102));
        combustible.setText("Tipo De Combustible:");
        getContentPane().add(combustible, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        trasmision.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        trasmision.setForeground(new java.awt.Color(102, 102, 102));
        trasmision.setText("Tipo De Trasmisíon:");
        getContentPane().add(trasmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        kilometraje.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        kilometraje.setForeground(new java.awt.Color(102, 102, 102));
        kilometraje.setText("Kilometraje Del Auto:");
        getContentPane().add(kilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));
        getContentPane().add(jtplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 130, -1));
        getContentPane().add(jtmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 130, -1));
        getContentPane().add(jtcombustible, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 110, -1));
        getContentPane().add(jtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 140, -1));
        getContentPane().add(jtanno, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 120, -1));
        getContentPane().add(jttrasmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 120, -1));
        getContentPane().add(jtkilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 140, -1));

        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        actualizar.setText("Actulizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        tablaauto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Placa Del Auto", "Modelo Del Auto", "Tipo De cobustible", "Marca Del Auto", "Año De Fabricacíon:", "Tipo De Trasmisíon", "Kilometraje Del Auto"
            }
        ));
        jScrollPane1.setViewportView(tablaauto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 670, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
         this.registro();
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        // TODO add your handling code here:
        File ruta = new File(ingresar.getText());
        this.registro();
     
    }//GEN-LAST:event_ingresarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
         File ruta = new File(ingresar.getText());
         this.registro();
    }//GEN-LAST:event_actualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JLabel anno;
    private javax.swing.JLabel combustible;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtanno;
    private javax.swing.JTextField jtcombustible;
    private javax.swing.JTextField jtkilometraje;
    private javax.swing.JTextField jtmarca;
    private javax.swing.JTextField jtmodelo;
    private javax.swing.JTextField jtplaca;
    private javax.swing.JTextField jttrasmision;
    private javax.swing.JLabel kilometraje;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modelo;
    private javax.swing.JLabel placa;
    private javax.swing.JButton salir;
    private javax.swing.JTable tablaauto;
    private javax.swing.JLabel trasmision;
    // End of variables declaration//GEN-END:variables

    private void registro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String nullmensaje(String ingrese_Numero_de_placa_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
