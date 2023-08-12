/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agents;

import Ontology.*;
import jade.content.Concept;
import jade.content.ContentElement;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import jade.lang.acl.ACLMessage;
import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.onto.basic.*;
import jade.content.ContentManager;
import jade.content.lang.*;
import jade.content.lang.sl.*;
import jade.content.onto.basic.Action;

public class PrimeiroAgente extends Agent implements EnsinoVocabulario{
    
    // Manager que manipula as mensagens em forma de ontologia entre agentes
    private ContentManager manager =  (ContentManager) getContentManager();
    
    // Linguagem utilizada pelo Manager
    private Codec codec = new SLCodec();
    
    // Ontologia utilizada pelo agente
    private Ontology ontology = EnsinoOntologia.getInstance();
    
    @Override
    protected void setup(){
        
        // Registrando as ontologias no Manager
        manager.registerLanguage(codec);
        manager.registerOntology(ontology);
        
        System.out.println("Oi, eu sou o " + getLocalName());
        
        Professor professor = new Professor();
        
        professor.setNome("Navarro");
        
        Curso curso = new Curso();
        curso.setNome("Circuitos");
        
        Leciona leciona = new Leciona();
        leciona.setProfessor(professor);
        leciona.setCurso(curso);
        
        addBehaviour(new AgenteEnvia(this, leciona));
        addBehaviour(new AgenteRecebe(this));
    }
    
    @Override
    protected void takeDown(){
        System.out.println("Agente " + getAID().getLocalName() + " finalizado.");
    }
    
    class AgenteEnvia extends OneShotBehaviour{
    
        private final Object obj;
    
        public AgenteEnvia(Agent a, Object obj){
            super(a);
            this.obj = obj;
        }

        @Override
        public void action(){
            
            try{
                //informar(obj);
                consultar(obj);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    class AgenteRecebe extends CyclicBehaviour{

       public AgenteRecebe(Agent a){
           super(a);
       }

       @Override
       public void action(){
           try{
               ACLMessage msg = myAgent.receive();
               if(msg != null){
                   String content = msg.getContent();
                   System.out.println(getLocalName() + " recebeu como resposta: ");
                   System.out.println(content);
               }
               else
                   block();
           }
           catch(Exception e){
           }
        }
    }
    
    void informar(Object obj){
       try{
           
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setSender(getAID());
            msg.addReceiver(new AID("Agente2", AID.ISLOCALNAME));
            msg.setLanguage(codec.getName());
            msg.setOntology(ontology.getName());
            
            if(obj instanceof Leciona)
                manager.fillContent(msg, (Leciona)obj);
            
            send(msg);
            System.out.println(getLocalName() + " enviando informação...");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
     void consultar(Object obj){
       try{
           
            ACLMessage msg = new ACLMessage(ACLMessage.QUERY_IF);
            msg.setSender(getAID());
            msg.addReceiver(new AID("Agente2", AID.ISLOCALNAME));
            msg.setLanguage(codec.getName());
            msg.setOntology(ontology.getName());
            
            if(obj instanceof Leciona)
                manager.fillContent(msg, (Leciona)obj);
            
            send(msg);
            System.out.println(getLocalName() + " enviando consulta...");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
     
    
    
}