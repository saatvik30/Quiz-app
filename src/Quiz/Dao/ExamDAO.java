/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz.Dao;
import Ouiz.Pojo.ExamPojo;
import Quiz.Dbutil.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author RC
 */
public class ExamDAO {
    public static String getExamID()throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select count(*)from exam");
        ResultSet rs=ps.executeQuery();
        String examID;
        if(rs.next()){
            int id=rs.getInt(1);
            examID="EX-"+(id+1);
            return examID;
        }
        else
            return "EX-1";
    }
    public static boolean addExam(ExamPojo e)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into exam values(?,?,?)");
        ps.setString(1,e.getExamID());
        ps.setString(2,e.getLanguage());
        ps.setInt(3, e.getTotalQno());
        int i=ps.executeUpdate();
        return i==1;
    }
    public static ArrayList<String> getExamIdBySub(String sub)throws SQLException{
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("select examid from exam where language=?");
       ps.setString(1, sub);
       ArrayList<String>list=new ArrayList();
       ResultSet rs=ps.executeQuery();
       while(rs.next()){
         String examid=rs.getString(1);
         list.add(examid);
       }
       return list;
    }
     public static int getQuestionbyId(String examid)throws SQLException{
         PreparedStatement ps=DBConnection.getConnection().prepareStatement("select total_question from exam where examid=?");
         ps.setString(1, examid);
         ResultSet rs=ps.executeQuery();
         int question=0;
         if(rs.next()){
            question= rs.getInt(1);
         }
         return question;
         
    }
     public static ArrayList<String>getAllSub()throws SQLException{
       Statement st=DBConnection.getConnection().createStatement();
       ResultSet rs=st.executeQuery("select unique language from exam");
       ArrayList<String>list=new ArrayList<>();
       while(rs.next()){
           String sub=rs.getString(1);
           list.add(sub);
                   
       }
       return list;
     }
     public static ArrayList<String>getExamIdBySub(String userid,String sub)throws SQLException{
         PreparedStatement ps=DBConnection.getConnection().prepareStatement("select examid from exam where language=? minus select examid from performance where userid=? ");
         ps.setString(1, sub);
         ps.setString(2, userid);
         ResultSet rs=ps.executeQuery();
         ArrayList<String>list=new ArrayList<>();
       while(rs.next()){
           String eid=rs.getString(1);
           list.add(eid);
                   
       }
       return list;
     }
}




