/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphnet;

import PetriObj.PetriT;
import graphpresentation.GraphTransition;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 *
 * @author Инна
 */
public class GraphPetriTransition extends GraphTransition implements Serializable {

    private PetriT transition;
    private int id;
    private static int simpleInd=0; // added by Inna 18.01.2013
    private int font; //added by Sasha 17.10.17

    public GraphPetriTransition(PetriT T, int i) //додано Олею
    {
        transition = T;
        id=i;
        font = 10;
    }

    public GraphPetriTransition(PetriT T) {
        transition = T;
        id = transition.getNumber(); // added by Katya 20.11.2016
        font = 10;
    }
    public PetriT getPetriTransition()
    {
       return transition;
    }

    @Override
    public void drawGraphElement(Graphics2D g2) {
        super.drawGraphElement(g2);
        g2.drawString(transition.getName(), (float) this.getGraphElement().getCenterX() - transition.getName().length() * font / 2, (float) this.getGraphElement().getCenterY() - GraphPetriTransition.getHEIGHT()/ 2-GraphPetriTransition.getHEIGHT()/5);
        String parametrString = transition.parametrIsParam() // added by Katya 08.12.2016
            ? transition.getParametrParamName()
            : Double.toString(transition.getParametr());
        String distributionString = transition.distributionIsParam() // added by Katya 08.12.2016
            ? transition.getDistributionParamName()
            : transition.getDistribution();
        if (transition.getDistribution() != null || transition.distributionIsParam()) {
            g2.drawString("t=" + parametrString + "(" + distributionString + ")", (float) this.getGraphElement().getCenterX() - Double.toString(transition.getParametr()).length() * font / 2, (float) this.getGraphElement().getCenterY() + GraphPetriTransition.getHEIGHT() / 2 + 20);
        } else {
            g2.drawString("t=" + parametrString, (float) this.getGraphElement().getCenterX() - Double.toString(transition.getParametr()).length() * font / 2, (float) this.getGraphElement().getCenterY() + GraphPetriTransition.getHEIGHT() / 2 + 20);
        }
        g2.drawString("b=" + transition.getBuffer(), (float) this.getGraphElement().getCenterX() - Double.toString(transition.getBuffer()).length() * font / 2, (float) this.getGraphElement().getCenterY() + GraphPetriTransition.getHEIGHT() / 2 + 40);
    }

    @Override
    public String getType() { // added by Katya 23.10.2016
        return "GraphPetriTransition";
    }
    
    @Override
    public int getId(){
        return id;
    }

     @Override
     public String getName(){
           return this.getPetriTransition().getName();
       }
    @Override
       public int getNumber(){
           return this.getPetriTransition().getNumber();
       }
   
    public static String setSimpleName(){ // added by Inna 18.01.2013
          simpleInd++; 
          return "T"+simpleInd;
       }
    public static void setNullSimpleName(){ // added by Inna 18.01.2013
          simpleInd = 0; 
          
       }
    
    public void setFont(int f){
        font = f;
    }
     
}
