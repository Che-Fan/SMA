/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ontology;
import jade.content.Predicate;
/**
 *
 * @author che_f
 */
public class Leciona implements Predicate {
    private Professor Professor;
    private Curso Curso;
    
    public void setProfessor(Professor p){
        Professor = p;
    }
    
    public Professor getProfessor(){
        return Professor;
    }
    
    public void setCurso(Curso c){
        Curso = c;
    }
    
    public Curso getCurso(){
        return Curso;
    }
}
