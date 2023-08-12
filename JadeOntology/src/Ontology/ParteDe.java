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
public class ParteDe implements Predicate{
    private Licao licao;
    private Curso curso;
    
    public void setLicao(Licao licao){
        this.licao = licao;
    }
    
    public Licao getLicao(){
        return licao;
    }
    
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    
    public Curso getCurso(){
        return curso;
    }
}
