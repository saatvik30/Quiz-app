/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz.Dao;

import Ouiz.Pojo.UserPojo;
import Quiz.Dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RC
 */
public class UserDAO {
    public static boolean validateUser(UserPojo user) throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select upper(userid) from users where userId=? and password=? and userType=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType().toLowerCase());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            String uname=rs.getString(1);
            System.out.println(uname);
            return true;
        }
        return false;
    }
    public static boolean RegisterStudent(UserPojo user)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int i=ps.executeUpdate();
        return i==1;
    }
    public static boolean ChangePassowrd(UserPojo u)throws SQLException{
         PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users set password=? where userid=? and usertype=? ");
         ps.setString(2,u.getPassword());
         ps.setString(1,u.getUserId());
         ps.setString(3,u.getUserType());
         int i=ps.executeUpdate();
         return i==1;
    }
     public static boolean ChangePassword2(UserPojo user)throws SQLException{
            Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set PASSWORD=? where USERID=?");
        ps.setString(2,user.getUserId());
        ps.setString(1,user.getPassword());
        int result=ps.executeUpdate();
        if(result==1)
            return true;
        return false;
      }
}
