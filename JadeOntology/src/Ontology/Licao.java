/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ontology;
import jade.content.Concept;
/**
 *
 * @author che_f
 */
public class Licao implements Concept{
    private String nome;
    
    public void setParteDe(String nome){
        this.nome = nome;
    }
    
    public String getParteDe(){
        return nome;
    }
}
