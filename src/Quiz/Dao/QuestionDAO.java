/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz.Dao;

import Ouiz.Pojo.QuestionPojo;
import Ouiz.Pojo.QuestionStore;
import Quiz.Dbutil.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RC
 */
public class QuestionDAO {
    public static void addQuestion(QuestionStore q)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
      // QuestionPojo qu=new QuestionPojo();
        ArrayList<QuestionPojo> arr=q.getAllQuestion();
        int i=0;
        for(QuestionPojo p:arr){
            ps.setString(1, p.getExamId());
            ps.setInt(2,p.getQno());
            ps.setString(3, p.getQuestion());
            ps.setString(4,p.getAns1());
            ps.setString(5,p.getAns2());
            ps.setString(6, p.getAns3());
            ps.setString(7, p.getAns4());
            ps.setString(8,p.getCorrect_ans());
            ps.setString(9, p.getLanguage());
            ps.executeUpdate();
        }
        
    }
    public static ArrayList<QuestionPojo>getAllQuestionByID(String examid)throws SQLException{
      PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from questions where examid=? order by qno ");  
      ps.setString(1, examid);
      ResultSet rs=ps.executeQuery();
      ArrayList<QuestionPojo>list=new ArrayList();
      while(rs.next()){
        QuestionPojo q=new QuestionPojo();
        q.setExamId(rs.getString(1));
        q.setQno(Integer.parseInt(rs.getString(2)));
        q.setQuestion(rs.getString(3));
        q.setAns1(rs.getString(4));
        q.setAns2(rs.getString(5));
        q.setAns3(rs.getString(6));
        q.setAns4(rs.getString(7));
        q.setCorrect_ans(rs.getString(8));
        q.setLanguage(rs.getString(9));
        list.add(q);
      }
      return list;
    }
   public static void updateQuestion(QuestionStore q)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update questions set Question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where examid=? and Qno=?");
      
        ArrayList<QuestionPojo> arr=q.getAllQuestion();
        
        int i=0;
        for(QuestionPojo p:arr){
            ps.setString(1, p.getQuestion());
            ps.setString(2,p.getAns1());
            ps.setString(3,p.getAns2());
            ps.setString(4, p.getAns3());
            ps.setString(5, p.getAns4());
            ps.setString(6,p.getAns4());
            ps.setString(7, p.getExamId());
            ps.setInt(8, p.getQno());
            ps.executeUpdate();
        }
        
    } 
}





