/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz.Dao;

import Ouiz.Pojo.AnswerPojo;
import Ouiz.Pojo.PerformancePojo;
import Ouiz.Pojo.UserProfile;
import Quiz.Dbutil.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author RC
 */
public class PerformanceDAO {
    public static void addPerformance(PerformancePojo p)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
        ps.setString(1, p.getUserid());
        ps.setString(2, p.getExamid());
         ps.setInt(3, p.getRight());
         ps.setInt(4, p.getWrong());
         ps.setInt(5, p.getUnattemp());
         ps.setString(7, p.getLanguage());
         ps.setDouble(6,p.getPer());
         int i=ps.executeUpdate();
        // return i==1;
    }
    public static ArrayList<PerformancePojo> viewAllStudentsScore()throws SQLException{
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs= st.executeQuery("select * from performance");
        ArrayList<PerformancePojo>list=new ArrayList<>();
        PerformancePojo p;
        while(rs.next()){
           p=new PerformancePojo();
           p.setUserid(rs.getString(1));
           p.setExamid(rs.getString(2));
           p.setRight(rs.getInt(3));
           p.setWrong(rs.getInt(4));
           p.setUnattemp(rs.getInt(5));
           p.setLanguage(rs.getString(7));
           p.setPer(rs.getDouble(6));
           list.add(p);
        }
        return list;
    }
    public static ArrayList<PerformancePojo> viewSingleScore()throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from performace where userid=?");
        ResultSet rs=ps.executeQuery();
        ArrayList arr=new ArrayList();
        PerformancePojo p;
        if(rs.next()){
           p=new PerformancePojo();
           p.setUserid(rs.getString(1));
           p.setExamid(rs.getString(2));
           p.setRight(rs.getInt(3));
           p.setWrong(rs.getInt(4));
           p.setUnattemp(rs.getInt(5));
           p.setLanguage(rs.getString(6));
           p.setPer(rs.getDouble(7));
            arr.add(p);
        }
        return arr;
    }
    public static ArrayList<String> getAllUserId()throws SQLException{
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs= st.executeQuery("select unique userid from performance");
        ArrayList<String>list=new ArrayList<>();
        while(rs.next()){
          String uid=  rs.getString(1);
            list.add(uid);
        }
        return list;
    }
    public static ArrayList<String> getExamIdByUserId(String uid)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select examid from performance where userid=?");
        ps.setString(1, uid);
        ArrayList<String>list=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String examid=rs.getString(1);
           list.add(examid);
        }
        return list;
    }
     public static PerformancePojo getDetailsByEid(String uid)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select language,per from performance where examid=?");
        ps.setString(1, uid);
        ResultSet rs=ps.executeQuery();
        PerformancePojo p=null;
        if(rs.next()){
           p=new PerformancePojo(); 
           p.setLanguage(rs.getString(1));
           p.setPer(rs.getDouble(2));
        }
        return p;
    }
    
}








