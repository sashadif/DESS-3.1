/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibTest;

import PetriObj.ExceptionInvalidNetStructure;
import PetriObj.PetriObjModel;
import PetriObj.PetriSim;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ю
 */
public class Main  {
    
    public static void main(String[] args) throws ExceptionInvalidNetStructure{
    ArrayList<PetriSim> list = new ArrayList<>();
    
        
    PetriSim A = new PetriSim(NetLibrary.CreateNetFR());
    PetriSim B = new PetriSim(NetLibrary.CreateNetFR());
    A.getNet().getListP()[4] = B.getNet().getListP()[7]; 
    
    B.getNet().getListP()[4] = A.getNet().getListP()[7]; 
    
    
        list.add(A);                
        list.add(B);
        
        PetriObjModel model = new PetriObjModel(list);
        model.go(100);
    }    
    
}
