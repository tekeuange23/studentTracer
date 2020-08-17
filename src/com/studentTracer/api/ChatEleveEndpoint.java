package com.studentTracer.api;

import javax.websocket.server.ServerEndpoint;

import com.studentTracer.beans.Enseignant;
import com.studentTracer.beans.Salle;
import com.studentTracer.dao.CommunicationEEDAO;
import com.studentTracer.servlets.ChatEnseignant;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@ServerEndpoint("/chateleveendpoint")
//@ServerEndpoint(value="/chat/{username}")
public class ChatEleveEndpoint {	//communication EE
	
	private static Set<Session> usersChat = Collections.synchronizedSet(new HashSet<Session>());
	///////////////////////////////////////////////////////////////////////////////////////////////////
	private CommunicationEEDAO communicationEEDAO;
	private Enseignant connectedEnseignant;
	private Salle selectedSalle;
	
    @OnOpen
    public void onOpen(Session session) throws IOException {
    	//Get session and WebSocket connection
    	this.usersChat.add(session);
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////
		this.connectedEnseignant = ChatEnseignant.getConnectedEnseignant();
		this.selectedSalle = ChatEnseignant.getSelectedSalle();
		this.communicationEEDAO = ChatEnseignant.getCommunicationEEDAO();
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        System.out.println(message);
       //Handle new messages
    	String username = (String) session.getUserProperties().get("username");
    	System.out.println("USERNAME: " + username);
    	if(username == null ) {
    		session.getUserProperties().put("username", message);
    		session.getBasicRemote().sendText("HELLO Mr " + message);	//this.buildJsonData("system", "You are now connected as " + message));
    	} else {
    		Iterator<Session> iterator = this.usersChat.iterator();
    		while(iterator.hasNext()) {
    			iterator.next().getBasicRemote().sendText(
    					session.getUserProperties().get("username") + ": " + message
    			); //this.buildJsonData(username, message));
    		}
    	}
    	
    	///////////////////////////////////////////////////////////////////////////////////////////////////
    	this.communicationEEDAO.addEnseignantMessage(connectedEnseignant, selectedSalle, message);
    	
    }

	@OnClose
    public void onClose(Session session) throws IOException {
       //WebSocket connection closes
    	this.usersChat.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
       //Do error handling here
    }
    
    private String buildJsonData(String username, String message) {
    	JsonObject jsonObj =(JsonObject) Json.createObjectBuilder().add("message", username + " " + message);
    	StringWriter stringWriter = new StringWriter();
    	try {
    		JsonWriter jsonWriter = Json.createWriter(stringWriter);
    		jsonWriter.write(jsonObj);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return stringWriter.toString();
	}

}
