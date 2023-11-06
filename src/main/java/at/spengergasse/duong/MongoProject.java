package at.spengergasse.duong;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoProject {
    public static void main(String[] args) {
        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            var db = client.getDatabase("5dhif-mongo");
            System.out.println("Databases");
            client.listDatabaseNames().forEach(System.out::println);
            db.createCollection("DUO");
            System.out.println("Collections");
            db.listCollectionNames().forEach(System.out::println);
            var db2 = client.getDatabase("wahlpflichtfaecher");
            System.out.println("Collections");
            db2.listCollectionNames().forEach(System.out::println);
            var wpfCollection = db2.getCollection("wahlpflichtfaecher");
            System.out.println("Wahlpflichtfächer Daten:");
            wpfCollection.find().forEach(System.out::println);
        }
    }
}
