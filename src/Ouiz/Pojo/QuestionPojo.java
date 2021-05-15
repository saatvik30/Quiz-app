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
public class QuestionPojo {

    @Override
    public int hashCode() {
        int hash = 3;
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
        final QuestionPojo other = (QuestionPojo) obj;
        if (this.qno != other.qno) {
            return false;
        }
        if (!Objects.equals(this.examId, other.examId)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.ans1, other.ans1)) {
            return false;
        }
        if (!Objects.equals(this.ans2, other.ans2)) {
            return false;
        }
        if (!Objects.equals(this.ans3, other.ans3)) {
            return false;
        }
        if (!Objects.equals(this.ans4, other.ans4)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.correct_ans, other.correct_ans)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QuestionPojo{" + "examId=" + examId + ", question=" + question + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans3=" + ans3 + ", ans4=" + ans4 + ", language=" + language + ", correct_ans=" + correct_ans + ", qno=" + qno + '}';
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }
    private String examId,question,ans1,ans2,ans3,ans4,language,correct_ans;
    private int qno;
}
