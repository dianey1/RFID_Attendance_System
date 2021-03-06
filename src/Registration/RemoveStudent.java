/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;
import Registration.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilma
 */
public class RemoveStudent extends javax.swing.JPanel {

    DataBase delStud = DataBase.getInstance();
    /**
     * Creates new form RemoveStudent
     */
    public RemoveStudent() {
        initComponents();
        delStud.connect();
        jComboBox1.addItem("Select a Matricule Number");
        delStud.query("select Matricule_Number from `registered personel`");
        ResultSet mat_number = delStud.getResultSet();
    
        try {
            while(mat_number.next()){
                jComboBox1.addItem(mat_number.getString("Matricule_Number"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RemoveStudent.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        jLabel1.setText("Delete Student From System");

        jLabel2.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel2.setText("Matriculation Number");

        jComboBox1.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel3.setText("Tag ID");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel4.setText("Name");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel5.setText("Faculty");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel6.setText("Department");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel7.setText("Email Address");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel8.setText("Phone Number");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jLabel9.setText("Residence");

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jComboBox1, 0, 353, Short.MAX_VALUE)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBox1.getSelectedItem().toString().equals("Select a Matricule Number")){
            JOptionPane.showMessageDialog(this, "Please Select a Matricule Number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
        int i = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this Student From the System? \n Note that all Attendance Records of this Student will be deleted!", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (i == 0){
            delAdmin();
            JOptionPane.showMessageDialog(this, "Deleted Successfully", "Success", JOptionPane.PLAIN_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
        delStud.query("select Tag_ID, Name, Domicile, Email_Adress,Telephone_Number, Departments_Name, Departments_Faculties_Name from `registered personel` where Matricule_Number ='" +jComboBox1.getSelectedItem().toString() +"'");
        ResultSet info = delStud.getResultSet();
        try {
            while (info.next()){
                jTextField1.setText(info.getString("Tag_ID"));
                jTextField2.setText(info.getString("Name"));
                jTextField3.setText(info.getString("Departments_Faculties_Name"));
                jTextField5.setText(info.getString("Email_Adress"));
                jTextField4.setText(info.getString("Departments_Name"));
                jTextField6.setText(info.getString("Telephone_Number"));
                jTextField7.setText(info.getString("Domicile"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RemoveStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (jComboBox1.getSelectedItem().toString().equals("Select a Matricule Number")){
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
            jTextField4.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jComboBox1.setSelectedIndex(0);
                   jTextField1.setText("");
                   jTextField2.setText("");
                   jTextField3.setText("");
                   jTextField4.setText("");
                   jTextField5.setText("");
                   jTextField6.setText("");
                   jTextField7.setText("");
                   rfid_attendance_system.MainInterface.changeCard("menuCard");
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void delAdmin(){
        delStud.connect();
        delStud.execute("delete from `attendance record` where `Registered Personel_Tag_ID` ='" +jTextField1.getText()+"'");
        delStud.execute("delete from `registered personel` where Matricule_Number ='" +jComboBox1.getSelectedItem().toString()+"'");
        
        jComboBox1.setSelectedIndex(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
       
            jComboBox1.setSelectedIndex(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
