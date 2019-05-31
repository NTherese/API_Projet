/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author meril
 */
public abstract class Subject {
    protected List<Observer> myObservers = new ArrayList<>();
  
   public void addObserver(Observer o){
       myObservers.add(o);
   }
   public void removeObserver(Observer o){
       myObservers.remove(o);
   }
   public void notifyObservers(){
       String msg=getNotification();
       myObservers.forEach((o) -> {
           o.update(msg);
        });
   }
   
   
   public abstract String getNotification();
}
