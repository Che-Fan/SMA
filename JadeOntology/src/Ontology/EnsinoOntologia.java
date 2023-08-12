/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ontology;

import jade.content.onto.*;
import jade.content.schema.*;


public class EnsinoOntologia extends Ontology implements EnsinoVocabulario{

    // Nome da Ontologia
    public static final String NOME_ONTOLOGIA = "Instituição de Ensino";
    
    // Instância única da Ontologia criada
    private static final Ontology instancia = new EnsinoOntologia();
    
    public static Ontology getInstance(){
        return instancia;
    }

    private EnsinoOntologia(){
        super(NOME_ONTOLOGIA, BasicOntology.getInstance());
        
        try{
            // Professor
            ConceptSchema cs = new ConceptSchema(PROFESSOR);
            add(cs, Professor.class);
            cs.add(NOME, (PrimitiveSchema) getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
            
            // Curso
            cs = new ConceptSchema(CURSO);
            add(cs, Curso.class);
            cs.add(NOME, (PrimitiveSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
            
            // Leciona
            PredicateSchema ps = new PredicateSchema(LECIONA);
            add(ps, Leciona.class);
            ps.add(PROFESSOR, (ConceptSchema)getSchema(PROFESSOR), ObjectSchema.MANDATORY);
            ps.add(CURSO, (ConceptSchema)getSchema(CURSO), ObjectSchema.MANDATORY);
            
            
         
            // Titular
            cs = new ConceptSchema(TITULAR);
            add(cs, Titular.class);
            cs.addSuperSchema((ConceptSchema)getSchema(PROFESSOR)); // Subclasse de Professor
            
            // Assistente
            cs = new ConceptSchema(ASSISTENTE);
            add(cs, Assistente.class);
            cs.addSuperSchema((ConceptSchema)getSchema(PROFESSOR)); // Subclasse de Professor
            
            // Curso regular
            cs = new ConceptSchema(REGULAR);
            add(cs, Regular.class);
            cs.addSuperSchema((ConceptSchema)getSchema(CURSO)); //Subclasse de Curso
            
            // Curso de laboratorio
            cs = new ConceptSchema(LABORATORIO);
            add(cs, Laboratorio.class);
            cs.addSuperSchema((ConceptSchema)getSchema(CURSO)); //Subclasse de Curso
            
            // Licao de casa
            cs = new ConceptSchema(LICAO);
            add(cs, Licao.class);
            cs.add(NOME, (PrimitiveSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
            
            // Parte de
            ps = new PredicateSchema(PARTE_DE);
            add(ps, ParteDe.class);
            ps.add(LICAO, (ConceptSchema)getSchema(LICAO), ObjectSchema.MANDATORY);
            ps.add(CURSO,(ConceptSchema)getSchema(CURSO), ObjectSchema.MANDATORY);
            
            // Organiza
            ps = new PredicateSchema(ORGANIZA);
            add(ps, Organiza.class);
            ps.add(PROFESSOR, (ConceptSchema)getSchema(PROFESSOR), ObjectSchema.MANDATORY);
            ps.add(CURSO, (ConceptSchema)getSchema(CURSO), ObjectSchema.MANDATORY);
            
        }
        catch(OntologyException oe){
            oe.printStackTrace();
        }
    }
    

    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
