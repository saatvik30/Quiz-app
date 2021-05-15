/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ouiz.Pojo;

/**
 *
 * @author RC
 */
public class PerformancePojo {


    @Override
    public String toString() {
        return "PerformancePojo{" + "examid=" + examid + ", language=" + language + ", userid=" + userid + ", right=" + right + ", wrong=" + wrong + ", unattemp=" + unattemp + ", per=" + per + '}';
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getUnattemp() {
        return unattemp;
    }

    public void setUnattemp(int unattemp) {
        this.unattemp = unattemp;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }
    private String examid,language,userid;
    int right,wrong,unattemp;
    double per;
    
}
