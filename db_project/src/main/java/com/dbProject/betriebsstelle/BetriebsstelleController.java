package com.dbProject.betriebsstelle;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.Gson;


@RestController
@ResponseBody
public class BetriebsstelleController {

	private BetriebsstelleService bsService = new BetriebsstelleService();
	Map<String, Betriebsstelle> bsMap = bsService.createMapFromCSV();
	

	@GetMapping(path="/betriebsstelle/{bsAbk}")
	@ResponseStatus(code = HttpStatus.OK)
	public String getBsInfos (@PathVariable("bsAbk") String bsAbk) {
		
		
		if (bsMap.containsKey(bsAbk)) { // Betriebsstelle gibt es
			//System.out.println(HttpStatus.OK.is2xxSuccessful());
			//GJSON oder ähnliches .. TO DO
			return "Test\n";
			// to do: HTTP STATUS:200 + JSON Format
		}
		
		else { // Betriebsstelle  gibt es nicht
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Betriebsstelle ist nicht vorhanden!");
		}
	}
	
}
