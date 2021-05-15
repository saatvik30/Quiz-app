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
public class ExamPojo {
    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalQno() {
        return totalQno;
    }

    public void setTotalQno(int Examid) {
        this.totalQno= Examid;
    }
    private String examID,language;
    private int totalQno;
}
