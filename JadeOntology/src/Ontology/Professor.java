/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ontology;

//import jade.content.ContentElement;
import jade.content.Concept;
//import jade.content.onto.annotations.Slot;
/**
 *
 * @author che_f
 */
public class Professor implements Concept{
    
    private String nome;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    //@Slot(mandatory = true)
    public String getNome(){
        return nome;
    }
    
}