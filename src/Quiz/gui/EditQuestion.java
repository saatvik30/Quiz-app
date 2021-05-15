/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz.gui;

import Ouiz.Pojo.ExamPojo;
import Ouiz.Pojo.QuestionPojo;
import Ouiz.Pojo.QuestionStore;
import Ouiz.Pojo.UserProfile;
import Quiz.Dao.QuestionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author RC
 */
public class EditQuestion extends javax.swing.JFrame {
    ExamPojo exam;
    String examId;
    QuestionStore qs;
    int pos=0;
    HashMap<String,String>hs=new HashMap();
    int qno;
    private String option1,option2,option3,option4,correctOption,question;
    public EditQuestion() {
        initComponents();
        this.setLocationRelativeTo(null);
        hs.put("Option 1","Answer1");
        hs.put("Option 2","Answer2");
        hs.put("Option 3","Answer3");
        hs.put("Option 4","Answer4");
      // lblUserName1.setText(lblUserName1.getText()+" "+UserProfile.getUserId());

    }
    public EditQuestion(ExamPojo e){
        this();
       exam=e; 
       qs=new QuestionStore();
        qno=1;
       lblQno.setText(lblQno.getText()+qno);
       qs=new QuestionStore();
       loadQuestions();
       showQuestions();
    }
   
    public void loadQuestions(){
        examId=exam.getExamID();
        System.out.println("exam id is given"+examId);
        try{
            ArrayList<QuestionPojo>list=QuestionDAO.getAllQuestionByID(examId);
            System.out.println("size of list"+list.size());
            //System.out.println("list item is"+list);
            for(QuestionPojo q:list){
            qs.addQuestion(q);
            }
            System.out.println(qs);
             int va=qs.getCount();
            // System.out.println(va);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"problem in db","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }        
    }
    public void showQuestions(){
       
        QuestionPojo q=qs.getQuestion(pos);
        //System.out.println("questions in pojo"+q
        txtOp1.setText(q.getAns1());
        txtOp2.setText(q.getAns2());
        txtOp3.setText(q.getAns3());
        txtOp4.setText(q.getAns4());
        jtaQuestion.setText(q.getQuestion());
        String correctans=q.getCorrect_ans();
        String correctOpt=getKeyFromValue(correctans);
        correctAns.setSelectedItem(correctOpt);
        System.out.println("options one is"+q.getAns1());
        System.out.println("Option 2 is "+q.getAns2());
        System.out.println("Option 3 is "+q.getAns3());
        System.out.println("Option 4 is "+q.getAns4());
        System.out.println("langusage is "+q.getLanguage());
        System.out.println("exam id is "+q.getExamId());
        System.out.println("total question is "+qs.getCount());
        System.out.println("question is "+q.getQuestion());   
    }
   private String getKeyFromValue(String value){
     Set<String> keys =hs.keySet();
     for(String k:keys){
         String v=hs.get(k);
         if(v.equals(value))
         return k;
     }
     return null;
   }
   public boolean validateInputes(){
        option1=txtOp1.getText();
        option2=txtOp2.getText();
        option3=txtOp3.getText();
        option4=txtOp4.getText();
        question=jtaQuestion.getText();
       correctOption=  correctAns.getSelectedItem().toString();
       //correctOption=hs.get(correctAns.getSelectedItem().toString());
        if(option1.isEmpty()||option2.isEmpty()||option3.isEmpty()||option4.isEmpty()||question.isEmpty()){
            return false;
        }
        return true;
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaQuestion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        correctAns = new javax.swing.JComboBox<String>();
        jButton3 = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        QNO = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        txtOp1 = new javax.swing.JTextField();
        txtOp2 = new javax.swing.JTextField();
        txtOp3 = new javax.swing.JTextField();
        txtOp4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        btnLogout.setBackground(new java.awt.Color(0, 0, 0));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 153, 102));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jtaQuestion.setColumns(20);
        jtaQuestion.setRows(5);
        jScrollPane1.setViewportView(jtaQuestion);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 102));
        jLabel1.setText("Option 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("Option 2");

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 153, 102));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 102));
        jLabel3.setText("Option 3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 102));
        jLabel4.setText("Option 4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 102));
        jLabel5.setText("Correct  Answer");

        correctAns.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        correctAns.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Option 1", "Option 2", "Option 3", "Option 4" }));
        correctAns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctAnsActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 153, 102));
        jButton3.setText("cancel");

        btnDone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 153, 102));
        btnDone.setText("done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        QNO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        QNO.setForeground(new java.awt.Color(255, 153, 102));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon("E:\\onlineexam\\questionpaper4.jpg")); // NOI18N
        jLabel7.setText("jLabel7");

        lblQno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 153, 102));
        lblQno.setText("Question");

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 153, 102));
        btnPrevious.setText("Prevoius");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)
                                        .addComponent(correctAns, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnNext)
                                .addGap(47, 47, 47)
                                .addComponent(btnPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtOp4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDone)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(QNO, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLogout)
                        .addGap(33, 33, 33))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblQno)))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtOp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(QNO)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtOp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(correctAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(jButton3)
                    .addComponent(btnDone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Login l=new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        //TODO add your handling code here:
        boolean validate=validateInputes();
           if(validate==false){
               JOptionPane.showMessageDialog(null,"fill all the value");
               return;
           }
           String optionName=hs.get(correctOption);
           System.out.println("correct name"+optionName);
           QuestionPojo q=new QuestionPojo();
           q.setAns1(option1);
           q.setAns2(option2);
           q.setAns3(option3);
           q.setAns4(option4);
           q.setCorrect_ans(optionName);
           q.setExamId(examId);
           q.setLanguage(exam.getLanguage());
           q.setQuestion(question);
           q.setQno(qno);
           qs.removeQuestion(pos);
           qs.setQuestion(pos, q);
         pos++;
           if(pos>=qs.getCount()){
            pos=0;
           }
           showQuestions();
           qno++;
             if(qno>qs.getCount()){
                 qno=1;
           }
        lblQno.setText("Question no :"+qno);
    }//GEN-LAST:event_btnNextActionPerformed

    private void correctAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correctAnsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correctAnsActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        
            //QuestionDAO.addQuestion(qs);
            //JOptionPane.showMessageDialog(null,"record insertes");

            // System.out.println(op1);
            //System.out.println(op2);
            //System.out.println(op3);
            //System.out.println(op4);
            // System.out.println(correct_ans);
            //System.out.println(question);
            //  System.out.println("Option 1 is "+q.getAns1());
            // System.out.println("Option 2 is "+q.getAns2());
            // System.out.println("Option 3 is "+q.getAns3());
            //  System.out.println("Option 4 is "+q.getAns4());
            // System.out.println("langusage is "+q.getLanguage());
            // System.out.println("exam id is "+q.getExamId());
            // System.out.println("total question is "+q.getQno());
            // System.out.println("question is "+q.getQuestion());
            // System.out.println(" corrcet ans is "+q.getCorrect_ans());
           
                try{
                    QuestionDAO.updateQuestion(qs);
                    JOptionPane.showMessageDialog(null,"all record updated ","Update",JOptionPane.INFORMATION_MESSAGE);
                }
                 catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"problem in db while updating","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);

        }
           
         
         
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
         boolean validate=validateInputes();
           if(validate==false){
               JOptionPane.showMessageDialog(null,"fill all the value");
               return;
           }
           String optionName=hs.get(correctOption);
           QuestionPojo q=new QuestionPojo();
           q.setAns1(option1);
           q.setAns2(option2);
           q.setAns3(option3);
           q.setAns4(option4);
           q.setCorrect_ans(optionName);
           q.setExamId(examId);
           q.setLanguage(exam.getLanguage());
           q.setQuestion(question);
           q.setQno(qno);
           qs.removeQuestion(pos);
           qs.setQuestion(pos, q);
           pos--;
           if(pos<0){
            pos=qs.getCount()-1;
           }
           qno--;
             if(qno<=0){
                 qno=qs.getCount();
           }
        lblQno.setText("Question no :"+qno);
        showQuestions();
    }//GEN-LAST:event_btnPreviousActionPerformed

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
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel QNO;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox<String> correctAns;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaQuestion;
    private javax.swing.JLabel lblQno;
    private javax.swing.JTextField txtOp1;
    private javax.swing.JTextField txtOp2;
    private javax.swing.JTextField txtOp3;
    private javax.swing.JTextField txtOp4;
    // End of variables declaration//GEN-END:variables
}
