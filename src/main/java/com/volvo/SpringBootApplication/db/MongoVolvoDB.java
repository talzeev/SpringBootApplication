package com.volvo.SpringBootApplication.db;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

public class MongoVolvoDB {
    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection collection;


    public MongoVolvoDB() throws UnknownHostException {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("MongoVolvoDB");
        collection = database.getCollection("vehicles");
    }


    public DBCursor seedVehiclesfromApi(){
        String fooResourceUrl = "http://localhost:1337/vehicle";
        RestTemplate restTemplateVehicle = new RestTemplate();
        RestTemplate restTemplateInfo = new RestTemplate();
        RestTemplate restTemplateService = new RestTemplate();
        ResponseEntity<String> responseVehicle =
                restTemplateVehicle.getForEntity((fooResourceUrl), String.class);
        JsonObject obj = new JsonParser().parse(responseVehicle.getBody()).getAsJsonObject();

        //try to use .map but throw an error. check it out later
        for(int i=0 ; i< obj.getAsJsonArray("vehicles").size() ; i++){
            String objectString = (obj.getAsJsonArray("vehicles").get(i).toString());
            BasicDBObject dbObject = (BasicDBObject) JSON.parse(objectString);
            String fooResourceUrlInfo = "http://localhost:1337/info?id="+dbObject.get("id");
            String fooResourceUrlService = "http://localhost:1337/services?id="+dbObject.get("id");

            try{
                ResponseEntity<String> responseInfo =
                        restTemplateInfo.getForEntity((fooResourceUrlInfo), String.class);
                JsonObject objInfo = new JsonParser().parse(responseInfo.getBody()).getAsJsonObject();
                String objectInfoString = (objInfo.toString());
                BasicDBObject dbObjectInfo = (BasicDBObject) JSON.parse(objectInfoString);
                dbObject.append("info", dbObjectInfo);
            } catch (HttpStatusCodeException e){
                System.out.println(e.getStatusText());
            } catch (RestClientException e){
                System.out.println("Error from client");
            }

            try{
                ResponseEntity<String> responseService =
                        restTemplateService.getForEntity((fooResourceUrlService), String.class);
                JsonObject objService = new JsonParser().parse(responseService.getBody()).getAsJsonObject();
                String objectServiceString = (objService.toString());
                BasicDBObject dbObjectService = (BasicDBObject) JSON.parse(objectServiceString);
                dbObject.append("services",dbObjectService);
            } catch (HttpStatusCodeException e){
                System.out.println(e.getStatusText());
            } catch (RestClientException e){
                System.out.println("Error from client");
            }

            collection.insert(dbObject);
        }
        return collection.find();
    }

    public DBCursor getAllVehicles(){
        return collection.find();
    }

    public DBObject getVehicleById(String id){
         return collection.findOne(new BasicDBObject("id", id));
    }

    @GetMapping("regex")
    public DBCursor getVehiclesByName(String name){
        BasicDBObject regexQuery = new BasicDBObject();

         return collection.find((DBObject) regexQuery.append("name",
                new BasicDBObject("$regex", name)));
    }
}
