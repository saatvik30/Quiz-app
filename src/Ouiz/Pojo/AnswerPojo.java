/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ouiz.Pojo;

import java.util.Objects;

/**
 *
 * @author RC
 */
public class AnswerPojo {


    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnswerPojo other = (AnswerPojo) obj;
        if (this.qno != other.qno) {
            return false;
        }
        if (!Objects.equals(this.examid, other.examid)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.choosenAnswer, other.choosenAnswer)) {
            return false;
        }
        if (!Objects.equals(this.correctAnswer, other.correctAnswer)) {
            return false;
        }
        return true;
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getChoosenAnswer() {
        return choosenAnswer;
    }

    public void setChoosenAnswer(String choosenAnswer) {
        this.choosenAnswer = choosenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "AnswerPojo{" + "examid=" + examid + ", subject=" + subject + ", qno=" + qno + ", choosenAnswer=" + choosenAnswer + ", correctAnswer=" + correctAnswer + '}';
    }
    private String examid;
    private String subject;
    private int qno;
    private String choosenAnswer,correctAnswer;
}
