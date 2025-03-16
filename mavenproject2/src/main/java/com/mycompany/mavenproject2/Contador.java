/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

public class Contador {
    static int numVeces;
    
    Contador(){
        numVeces = 0;
    }

    public static int getNumVeces() {
        return numVeces;
    }

    public static void setNumVeces(int numVeces) {
        Contador.numVeces = numVeces;
    }
    
    
    
    
    public void sumarContador(){
        numVeces++;
        System.out.println("Contador: " + numVeces);
    }
    
    
    
    public void saludo(){
        boolean seguir = true;
        for(int i = 0; i < 4  && seguir ;i++){
            System.out.println("Hola");
        }   
    }
    
}
