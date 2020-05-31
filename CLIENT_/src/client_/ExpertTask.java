/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Benutzer
 */
public class ExpertTask extends javax.swing.JFrame {

   private Map<String, CreditProduct> map=new HashMap<String,CreditProduct>();
   private Map<String, CreditProduct> map2=new HashMap<String,CreditProduct>();
    /**
     * Creates new form ExpertTask
     */
    public ExpertTask() throws UnknownHostException, IOException, ClassNotFoundException {
        initComponents();
        Socket sock = new Socket(InetAddress.getByName("localhost"), 1024);
            
            OutputStream output = sock.getOutputStream();
            InputStream input =sock.getInputStream();
            
            ObjectOutputStream objoutput=new ObjectOutputStream(output);
            ObjectInputStream objinput=new ObjectInputStream(input);
            
            objoutput.writeObject(4);
            
            int size=(int)objinput.readObject();
            
            for(int i=0;i<size;i++){
                CreditProduct credit=new CreditProduct();
                credit.setName_of_product((String) objinput.readObject());
                credit.setMaturity_date((int) objinput.readObject());
                credit.setInitial_amount((double) objinput.readObject());
                credit.setInterest_rate((double) objinput.readObject());
                credit.setRecurring_payments((double) objinput.readObject());
                credit.setEarly_repayment((boolean)objinput.readObject());
                map.put(credit.getName_of_product(),credit);
            }
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            
            for(CreditProduct obj: map.values()){               
            model.addRow(new Object[]{obj.getName_of_product(),obj.getMaturity_date(),
                obj.getInitial_amount(),obj.getInterest_rate(),obj.getRecurring_payments(),obj.isEarly_repayment()});            
            }
            
            objinput.close();
            objoutput.close();
            output.close();
            input.close();
            sock.close();
        
             jTable1.setAutoCreateRowSorter (true);
    jTable1.getTableHeader ().setToolTipText("Нажмите на название столбца для сортировки");
            
    
     jTable2.setAutoCreateRowSorter (true);
    jTable2.getTableHeader ().setToolTipText("Нажмите на название столбца для сортировки");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Наименование кредитного продукта", "Срок погашения(дней)", "Начальная сумма(BYR)", "Процентная ставка(%)", "Размер периодических платежей(BYR)", "Возможность досрочного погашения"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Сохранить");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Назад");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Наименование кредитного продукта", "Срок погашения(дней)", "Начальная сумма(BYR)", "Процентная ставка(%)", "Размер периодических платежей(BYR)", "Возможность досрочного погашения"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Добавить");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setText("Удалить");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(494, 494, 494)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 116, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            Socket sock = new Socket(InetAddress.getByName("localhost"), 1024);
            
            OutputStream output = sock.getOutputStream();
            InputStream input =sock.getInputStream();
            
            ObjectOutputStream objoutput=new ObjectOutputStream(output);
            ObjectInputStream objinput=new ObjectInputStream(input);    
            
           
           
           if(map2.size()==4){
               
           objoutput.writeObject(6);
           objoutput.writeObject(map2.size());
               
               for(CreditProduct obj : map2.values()){
            objoutput.writeObject(obj.getName_of_product());
            objoutput.writeObject(obj.getMaturity_date());
            objoutput.writeObject(obj.getInitial_amount());
            objoutput.writeObject(obj.getInterest_rate());
            objoutput.writeObject(obj.getRecurring_payments());
            objoutput.writeObject(obj.isEarly_repayment());
            }
               
               
               int result = 1;
            result = (int)objinput.readObject();
            if(result == 1){
            JOptionPane.showMessageDialog(null, "Данные для экспертной оценки добавлены");
            objinput.close();
            objoutput.close();
            output.close();
            input.close();
            sock.close();      

            this.dispose();
           }
     
        }else JOptionPane.showMessageDialog(null, "Ошибка передачи или создания данных. Возможно, введены не все данные", "Ошибка",JOptionPane.ERROR_MESSAGE );

        } catch (UnknownHostException ex) {
            Logger.getLogger(ExpertTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExpertTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(ExpertTask.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        if(jTable2.getRowCount()>=4){
            jLabel7.setText("Заполнено максимальное число строк");
        }
        else{
        jLabel7.setText("");
        DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        DefaultTableModel model2= (DefaultTableModel)jTable2.getModel();
        
        String key = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        
        if(!map2.containsKey(key)){
        map2.put(key, map.get(key));
           
            model2.addRow(new Object[]{jTable1.getValueAt(jTable1.getSelectedRow(), 0),jTable1.getValueAt(jTable1.getSelectedRow(), 1),
                jTable1.getValueAt(jTable1.getSelectedRow(), 2),jTable1.getValueAt(jTable1.getSelectedRow(), 3),
                jTable1.getValueAt(jTable1.getSelectedRow(), 4),jTable1.getValueAt(jTable1.getSelectedRow(), 5)});            
        }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel model= (DefaultTableModel)jTable2.getModel();
        String key = (String) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
        map.remove(key);
        model.removeRow(jTable2.getSelectedRow());
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ExpertTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ExpertTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ExpertTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ExpertTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ExpertTask().setVisible(true);
//                } catch (IOException ex) {
//                    Logger.getLogger(ExpertTask.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(ExpertTask.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}