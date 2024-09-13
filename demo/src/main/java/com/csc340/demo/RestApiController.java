package com.csc340.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    /**
     * Get information about an amiibo
     *
     * @return an Amiibo object
     */
    @GetMapping("/amiibo")
    public Object getAmiibo() {

        try {
            String url = "https://amiiboapi.com/api/amiibo/?name=link";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            List<Amiibo> amiiboList = new ArrayList<>();


            //for (JsonNode rt : root) {
            //Extract relevant info from the response and use it for what you want, in this case build an Amiibo object

            for (JsonNode rt : root.get("amiibo")) {
                String name = rt.get("name").asText();
                String gameSeries = rt.get("gameSeries").asText();
                String type = rt.get("type").asText();

                Amiibo amiibo = new Amiibo(name, gameSeries, type);
                amiiboList.add(amiibo);
            }

            return amiiboList;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /amiibo";
        }
    }


}
