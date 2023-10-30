package com.rufino.uolhost.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Service
@Getter
public class CodinameService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment environment;
	
	private List<String> vingadoresCodinamesList = new ArrayList<>();
	
	private List<String> ligaDaJusticaCodinamesList = new ArrayList<>();
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	//Vai ser chamado sempre que inicializar a aplicacao
	@PostConstruct
	public void loadJsonData() {
		
		try {
			
			String codinameResponse = restTemplate.getForObject(environment.getProperty("link.json.vingadores"), String.class);			
			JsonNode jsonNode = objectMapper.readTree(codinameResponse);
			
			ArrayNode codinamesList = (ArrayNode) jsonNode.get("vingadores");
			
			for(JsonNode item : codinamesList) {
				vingadoresCodinamesList.add(item.get("codinome").asText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void loadXmlData() {
		
		try {
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(environment.getProperty("link.xml.liga.da.justica"));
			
			NodeList codinamesList = document.getElementsByTagName("codinome");
			
			//NodeList não é um ArrayList por isso não podemos fazer "foreach"
			for(int i = 0 ; i < codinamesList.getLength(); i++) {
				Element element = (Element) codinamesList.item(i);
				String codiname = element.getTextContent();
				ligaDaJusticaCodinamesList.add(codiname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
