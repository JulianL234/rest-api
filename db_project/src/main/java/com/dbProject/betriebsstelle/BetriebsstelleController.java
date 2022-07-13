package com.dbProject.betriebsstelle;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@ResponseBody
public class BetriebsstelleController {

	private BetriebsstelleService bsService = new BetriebsstelleService();
	private Map<String, Betriebsstelle> bsMap = bsService.createMapFromCSV();
	
	@GetMapping(path="/betriebsstelle/{bsAbk}")
	@ResponseStatus(code = HttpStatus.OK)
	public String getBs (@PathVariable("bsAbk") String bsAbk) {
		
		// Betriebsstelle gibt es
		if (bsMap.containsKey(bsAbk.toUpperCase())) {
			String outputline = "HTTP-STATUS: 200\n\n"
					+ "{\n\tName: " + bsMap.get(bsAbk.toUpperCase()).getName()
					+ "\n\tKurzname: " + bsMap.get(bsAbk.toUpperCase()).getKurzname()
					+ "\n\tTyp: " + bsMap.get(bsAbk.toUpperCase()).getTyp() + "\n}";	
			return outputline;
		} 
		
		// Betriebsstelle  gibt es nicht
		else { // Fehlermeldung - HTTP-Status 400
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
}
