package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ParoleArray;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleArray elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempi;

    @FXML
    void doInsert(ActionEvent event) {
    	String parola=txtParola.getText();
    	ArrayList<String>elencoParole=(ArrayList<String>) elenco.getElenco();
    	double tempoTot=0.0;
    	if(!elencoParole.contains(parola)) {
    		double startTime=System.nanoTime();
    		elencoParole.add(parola);
    		double endTime=System.nanoTime();
    		tempoTot=endTime-startTime;
    		
    	}
    	txtResult.clear();
    	txtTempi.clear();
    	txtTempi.appendText(String.valueOf(tempoTot));
    	Collections.sort(elencoParole);
    	for(int i=0;i<elencoParole.size();i++) {
    		txtResult.appendText(elencoParole.get(i)+"\n");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	double tempoTot=0.0;
    	double startTime=System.nanoTime();
    	txtResult.clear();
    	double endTime=System.nanoTime();
    	tempoTot=endTime-startTime;
    	txtTempi.clear();
    	txtTempi.appendText(String.valueOf(tempoTot));
    	
    }
    @FXML
    void doCancella(ActionEvent event) {
    	String parola=txtParola.getText();
    	ArrayList<String>elencoParole=(ArrayList<String>) elenco.getElenco();
    	boolean trovato=false;
    	double tempoTot=0.0;
    	int index=0;
    	for(int i=0;i<elencoParole.size();i++) {
    		if(elencoParole.contains(parola)) {
    			trovato=true;
    			index=i;
    		}
    	}
    	if(trovato==true) {
    		double startTime=System.nanoTime();
    		elencoParole.remove(index);
    		double endTime=System.nanoTime();
    		tempoTot=endTime-startTime;
    		
    	}
    	txtResult.clear();
    	txtTempi.clear();
    	txtTempi.appendText(String.valueOf(tempoTot));
    	Collections.sort(elencoParole);
    	for(int i=0;i<elencoParole.size();i++) {
    		txtResult.appendText(elencoParole.get(i)+"\n");
    	}
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new ParoleArray() ;
    }
}
