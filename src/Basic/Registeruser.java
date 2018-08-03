
package Basic;
import connection.db_connection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author shasmoe
 */
public class Registeruser extends javax.swing.JFrame {

    //call the class for connection to our database
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    Boolean tableselected=false;
    
    public Registeruser() {
        initComponents();
        makeid();
        refreshtable();
        btndelete.setEnabled(false);
    }

  //method for generation of unique ID
     private void makeid(){
        Integer id=1;
         try{
            //fetch a connection
            connection = db_connection.getInstance().getConnection();
            if (connection != null) {
                String sq="SELECT id from makeid order by id DESC";
                pst=connection.prepareStatement(sq);
                rs=pst.executeQuery();
                 if(rs.next()){
                    id=rs.getInt("id");
                    String k =String.format("%05d", ++id);
                     userid.setText(k+"/Basic");

                 } else{
                     String k =String.format("%05d", id);
                     userid.setText(k+"/Basic");
                 } 
            }
             
        }catch(IOException | SQLException | PropertyVetoException e){
           JOptionPane.showMessageDialog(null,e);
        }
        finally {
            if (rs!= null) try { rs.close(); } catch (SQLException e) {}
            if (pst != null) try { pst.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
        }
        
        
    }
     
     //code for update table
     private void refreshtable(){
        try{
            //fetch a connection
            connection = db_connection.getInstance().getConnection();
            if(connection!=null){
                String sql="select userid as 'User Identification',firstname as 'First Name',secondname as 'Second Name',"
                        + "lastname as 'Last Name'  from userinfo";
                pst=connection.prepareStatement(sql);
                rs=pst.executeQuery();
                userinfotable.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }
        catch(IOException | SQLException | PropertyVetoException e){
        JOptionPane.showMessageDialog(null,e);
        }
        finally {
            if (rs!= null) try { rs.close(); } catch (SQLException e) {}
            if (pst != null) try { pst.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
        }
 }
     
     private void clear(){
        txtfirstname.setText(null);
        txtmiddlename.setText(null);
        txtlastname.setText(null);
        btndelete.setEnabled(false);
        btnRegister.setText("Register");
        makeid();
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userid = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JTextField();
        txtlastname = new javax.swing.JTextField();
        txtmiddlename = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnexit1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userinfotable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        userid.setBackground(new java.awt.Color(255, 255, 255));
        userid.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        userid.setForeground(new java.awt.Color(204, 0, 0));
        userid.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AutoID (Generated)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));
        userid.setOpaque(true);

        txtfirstname.setBorder(javax.swing.BorderFactory.createTitledBorder("Firstname"));
        txtfirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirstnameActionPerformed(evt);
            }
        });

        txtlastname.setBorder(javax.swing.BorderFactory.createTitledBorder("lastname"));

        txtmiddlename.setBorder(javax.swing.BorderFactory.createTitledBorder("middlename"));

        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnexit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnexit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnexit1.setText("Reset");
        btnexit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfirstname)
                    .addComponent(txtmiddlename)
                    .addComponent(txtlastname)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnexit1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userid, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfirstname, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtmiddlename, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtlastname, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexit1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Information(s)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        userinfotable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "UserID", "First Name", "Middle Name","Last Name"
            }
        ));
        userinfotable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userinfotableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userinfotable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfirstnameActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        
        
        String firstname = txtfirstname.getText().trim().toUpperCase();
        String middlename = txtmiddlename.getText().trim();
        String lastname = txtlastname.getText();
        String usernumber=userid.getText();
        UIManager ui=new UIManager();
        ui.put("JOpitionPane.background",Color.YELLOW);
        //Validation
        if (firstname.equals("")&& middlename.equals("")&& lastname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please!. Fill all the Required Filled!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
        }else if (firstname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please!. Enter First Name!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
        }else if (middlename.equals("")) {
            JOptionPane.showMessageDialog(null, "Please!. Enter Second Name!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
        }else if (lastname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please!. Enter Last Name!!!","Warning!!!",JOptionPane.WARNING_MESSAGE);
        }else {
            try {
                // fetch a connection
                connection = db_connection.getInstance().getConnection();
                if (connection != null) {
                  if(tableselected==false){
                        int a=JOptionPane.showConfirmDialog(null,"Are You Sure to Register User...?","Confirm Message",JOptionPane.YES_NO_OPTION);
                        if(a==0){ 
                           String sql="Insert into userinfo (userid,firstname,secondname,lastname)values(?,?,?,?)";          
                           pst=connection.prepareStatement(sql);
                           pst.setString(1, usernumber);
                           pst.setString(2, firstname);
                           pst.setString(3, middlename);
                           pst.setString(4, lastname);
                           pst.execute();

                           //insert id
                           String sqlw="Insert into makeid (uid) value(?) ";
                           pst=connection.prepareStatement(sqlw);
                           pst.setString(1, usernumber);
                           pst.execute();
                           //Another/Second table that the data needs to be inserted
                           String sql2 ="Insert into users (username,password,level,status) values(?,?,?,?)";
                           pst = connection.prepareStatement(sql2);
                           pst.setString(1, usernumber);
                           pst.setString(2, lastname);
                           pst.setString(3, "0");
                           pst.setString(4, "ACTIVE");
                           pst.execute();
                           JOptionPane.showMessageDialog(null,"User Registered Successfull","SUCCESS MESSAGE",JOptionPane.INFORMATION_MESSAGE); 
                           clear();
                           refreshtable();
                         }
                  }else if(tableselected==true){//UPDATE
                        int a=JOptionPane.showConfirmDialog(null,"Are You Sure you want to UPDATE User's Information","Confirm Message",JOptionPane.YES_NO_OPTION);
                        if(a==0){
                            String value1=userid.getText();
                            String value2=txtfirstname.getText();
                            String value3=txtmiddlename.getText();
                            String value4=txtlastname.getText();
                            
                            // fetch a connection
                            connection = db_connection.getInstance().getConnection();
                            String sql="update userinfo set"
                            + " firstname='"+value2+"',secondname='"+value3+"',lastname='"+value4+"' where userid='"+value1+"'";
                            pst=connection.prepareStatement(sql);
                            pst.executeUpdate();
                           JOptionPane.showMessageDialog(null, "User's Information(s) Updated successfully!!!");
                           clear();
                           refreshtable();
                           btnRegister.setText("Register");
                           tableselected=false;
                           btndelete.setEnabled(false);
                           //deletebtn.setEnabled(false);
                        }//else quit
                  }
                }
        }catch(IOException | SQLException | PropertyVetoException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            if (rs!= null) try { rs.close(); } catch (SQLException e) {}
            if (pst != null) try { pst.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
         }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed

        int result = JOptionPane.showConfirmDialog(null,"Are you sure to Exit..?", "EXIT", JOptionPane.OK_CANCEL_OPTION);;
        //System.EXIT_ON_CLOSE();
        if (result == JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void userinfotableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userinfotableMouseClicked
        try{// fetch a connection
            connection = db_connection.getInstance().getConnection();
            if(connection!=null){
                int row = userinfotable.getSelectedRow();
                String Table_click=(userinfotable.getModel().getValueAt(row, 0).toString());
                String sql="select * from userinfo where userid='"+Table_click+"'";
                pst=connection.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){                
                    String a=rs.getString("userid");
                    userid.setText(a);
                    String b=rs.getString("firstname");
                    txtfirstname.setText(b);
                    String c=rs.getString("secondname");
                    txtmiddlename.setText(c);
                    String d=rs.getString("lastname");
                    txtlastname.setText(d);
                    /////
                    btndelete.setEnabled(true);
                    btnRegister.setText("Update");
                    tableselected=true;
                }
           }
        }catch(IOException | SQLException | PropertyVetoException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        finally {
            if (rs!= null) try { rs.close(); } catch (SQLException e) {}
            if (pst != null) try { pst.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
        }
    }//GEN-LAST:event_userinfotableMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int p=JOptionPane.showConfirmDialog(null, "Sure to delete Selected User Info? ", "Delete",JOptionPane.YES_NO_OPTION);
       
        if(p==0){
        try{
            // fetch a connection
            connection = db_connection.getInstance().getConnection();
            int row = userinfotable.getSelectedRow();
            String Table_click=(userinfotable.getModel().getValueAt(row, 0).toString());
            String sql2="delete from userinfo where userid='"+Table_click+"'";
            pst=connection.prepareStatement(sql2);
            pst.execute();                   
            JOptionPane.showMessageDialog(null,"User Info deleted successfully!!!");
            btndelete.setEnabled(false);
            btnRegister.setText("Register");
            tableselected=false;
            clear();
            refreshtable(); 
        }
        catch(IOException | SQLException | PropertyVetoException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Data not Deleted");
            //JOptionPane.showMessageDialog(null,e);
        }

        finally {
            if (rs!= null) try { rs.close(); } catch (SQLException e) {}
            if (pst != null) try { pst.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
        }
      }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnexit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexit1ActionPerformed
        clear();
    }//GEN-LAST:event_btnexit1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registeruser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registeruser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registeruser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registeruser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registeruser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnexit1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtmiddlename;
    private javax.swing.JLabel userid;
    private javax.swing.JTable userinfotable;
    // End of variables declaration//GEN-END:variables
}
