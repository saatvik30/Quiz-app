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
public class AnswerStore {
    ArrayList<AnswerPojo>ansList;
    public AnswerStore(){
        ansList=new ArrayList<>();
    }
    public void addAnswer(AnswerPojo ans){
        ansList.add(ans);
    }
    public AnswerPojo getAnswer(int pos){
        return ansList.get(pos);
    }
     public AnswerPojo removeAnswer(int pos){
        return ansList.remove(pos);
    }
     public ArrayList<AnswerPojo>getAllQuestion(){
         return ansList;
     }
     public int getCount(){
         return ansList.size();
     }
     public AnswerPojo getAnswerByQno(int qno){
         for(AnswerPojo ans:ansList){
             if(ans.getQno()==qno){
                 return ans;
             }
         }
         return null;
     }
     public void setAnswer(int pos,AnswerPojo q){
    ansList.add(q);
}
     public int removeAnswer(AnswerPojo ans){
         int pos=ansList.indexOf(ans);
         ansList.remove(pos);
         return pos;
     }
}












