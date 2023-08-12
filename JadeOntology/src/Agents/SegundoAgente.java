/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agents;


import Ontology.*;
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


import jade.core.Agent;

public class SegundoAgente extends Agent{
    
    private ContentManager manager = (ContentManager) getContentManager();
    private Codec codec = new SLCodec();
    private Ontology ontology = EnsinoOntologia.getInstance();
    
    @Override
    protected void setup(){
        
        manager.registerLanguage(codec);
        manager.registerOntology(ontology);
        
        System.out.println("Oi, eu sou o " + getAID().getLocalName());
        
        addBehaviour(new AgenteRecebe(this));
        
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
                   ContentElement content = myAgent.getContentManager().extractContent(msg);
                   
                   if(msg.getPerformative() == ACLMessage.INFORM){
                        if(content instanceof Leciona){                                 
                            Leciona leciona = (Leciona) content;
                            System.out.print("O professor " + leciona.getProfessor().getNome());
                            System.out.println(" leciona o curso de " + leciona.getCurso().getNome());
                        }
                    }
                   
                    if(msg.getPerformative() == ACLMessage.QUERY_IF){
                        if(content instanceof Leciona){                                 
                            Leciona leciona = (Leciona) content;
                            System.out.println(getLocalName() + " recebeu consulta.");
                            System.out.println(getLocalName() + " retornando a consulta.");
                            
                            ACLMessage reply = msg.createReply();
                            reply.setPerformative(ACLMessage.INFORM);
                            reply.setContent("O professor " + leciona.getProfessor().getNome()+
                                             " leciona o curso de " + leciona.getCurso().getNome());
                            send(reply);
                        }
                    }
                    

               }
               else
                   block();
           }
           catch(Exception e){
           }
        }
    }
   
   @Override
   protected void takeDown(){
       System.out.println("Agente "+ getLocalName() + " finalizado.");
   }
    
}
