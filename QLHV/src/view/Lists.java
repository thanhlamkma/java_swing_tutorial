/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import model.Student;
import service.ClassService;
import service.StudentService;
import java.util.List;
import model.Class;



/**
 *
 * @author LAPTOP
 */
public class Lists extends javax.swing.JFrame {

    private StudentService studentService;
    private ClassService classService;
    DefaultTableModel tableModel;
    /**
     * Creates new form List
     */
    public Lists() {
        initComponents();
        setResizable(false);
        studentService = new StudentService();
        classService = new ClassService();
        
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbList = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbbList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbbList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn danh sách", "Danh sách học viên", "Danh sách lớp học" }));
        cbbList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbListItemStateChanged(evt);
            }
        });

        tbList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbList, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cbbList, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbListItemStateChanged
        // TODO add your handling code here:
        String listType = cbbList.getSelectedItem().toString().trim();
        if(listType.equals("Danh sách học viên")) {
            tableModel.setRowCount(0);
            tableModel.setColumnIdentifiers(new Object[] {
                "Mã học viên", "Tên học viên", "Địa chỉ"
            });
            tbList.setModel(tableModel);
            List<Student> listStudent = studentService.getAllStudents();
            for (Student student : listStudent) {
                tableModel.addRow(new Object[] {
                    student.getStudentId(), student.getStudentName(), student.getAddress()
                });
            }
        } else if (listType.equals("Danh sách lớp học")) {
            tableModel.setRowCount(0);
            tableModel.setColumnIdentifiers(new Object[] {
                "Mã lớp", "Tên lớp", "Sĩ số"
            });
            tbList.setModel(tableModel);
            List<Class> listClass = classService.getAllClasses();
            for (Class c : listClass) {
             
                tableModel.addRow(new Object[] {
                    c.getClassID(), c.getClassName(), c.getNumber()
                });
            }
        } else {
            tableModel.setRowCount(0); // Xoa cac du lieu trong bang
        }
    }//GEN-LAST:event_cbbListItemStateChanged

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
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lists().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbList;
    // End of variables declaration//GEN-END:variables
}
