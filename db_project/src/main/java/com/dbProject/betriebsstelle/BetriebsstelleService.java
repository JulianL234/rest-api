package com.dbProject.betriebsstelle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;

public class BetriebsstelleService {
		
	public Map<String, Betriebsstelle> createMapFromCSV() {
		
		String filePath = "../../../../resources/DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv";
		Map <String, Betriebsstelle> bsMap = new HashMap<>();
		String line;
		boolean firstLine = true;
		int indexOfName = -1;
		int indexOfKurzname = -1;
		int indexOfTyp = -1;
		int indextOfAbk = -1;
		
	    try {
	    	
	        BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        
	        while ((line = reader.readLine()) != null) {
	        	String[] spLine = line.split(";");
	            if (firstLine == true) {
	            	indexOfName = ArrayUtils.indexOf(spLine, "RL100-Langname");
	        	    indexOfKurzname = ArrayUtils.indexOf(spLine, "RL100-Kurzname");
	        	    indexOfTyp = ArrayUtils.indexOf(spLine, "Typ Lang");
	        	    indextOfAbk = ArrayUtils.indexOf(spLine, "RL100-Code");
	        	    firstLine=false;
	            } else {
	            	if (spLine.length >= 5) {
	            		Betriebsstelle bs = new Betriebsstelle(spLine[indexOfName], spLine[indexOfKurzname], spLine[indexOfTyp]);
	            		if (!bsMap.containsKey(spLine[indextOfAbk])) {
	            			bsMap.put(spLine[indextOfAbk], bs);
			        	}
		        	}
	            }
	        }
	    } catch (IOException exc) {
	        exc.printStackTrace();
	    }
	    
	    return bsMap;
	}
}

