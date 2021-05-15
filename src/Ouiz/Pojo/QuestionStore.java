/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ouiz.Pojo;

import java.util.ArrayList;

/**
 *
 * @author RC
 */
public class QuestionStore {

    @Override
    public String toString() {
        return "QuestionStore{" + "list=" + list + '}';
    }
    ArrayList<QuestionPojo>list;
public QuestionStore(){
    list=new ArrayList();
}
public void addQuestion(QuestionPojo q){
    list.add(q);
}
public QuestionPojo getQuestion(int pos){
   return list.get(pos);
}
public void setQuestion(int pos,QuestionPojo q){
    list.add(pos,q);
}
public ArrayList<QuestionPojo>getAllQuestion(){
    return list;
}
public void removeQuestion(int pos){
    list.remove(pos);
}
public QuestionPojo getQuestionByQno(int qno){
    for(QuestionPojo q:list){
        if(q.getQno()==qno){
            return q;
        }
    }
    return null;
}
public int getCount(){
  return list.size();
}
}





