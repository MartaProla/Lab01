package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	LinkedList<String>parole;
	
		
	public Parole() {
		//TODO
		parole= new LinkedList<String>();
	}
	
	public void addParola(String p) {
		if(!parole.contains(p))
			parole.add(p);
	
	}
	public void removeParola(String p) {
		parole.remove(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

}
