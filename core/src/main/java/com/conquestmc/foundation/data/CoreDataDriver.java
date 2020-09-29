package com.conquestmc.foundation.data;

import com.conquestmc.foundation.player.DataDriver;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class CoreDataDriver<T extends DataObject> implements DataDriver<T> {
    private final MongoCollection<Document> collection;
    private final Class<? extends T> type;
    private final Gson gson;


    public CoreDataDriver(String hostname, int port, String name, Class<? extends T> type, Map<Type, Object> adapters) {
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("conquest");
        System.out.println(database.listCollectionNames().toString());

        this.collection = database.getCollection(name);
        this.type = type;

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        this.gson = gsonBuilder.create();
    }

    @Override
    public T findById(Object id) {
        Document document = collection.find(eq("id", id.toString())).first();

        return document == null ? null : deserialize(document);
    }

    @Override
    public T findByOne(String key, Object value) {
        Document document = collection.find(eq(key, value)).first();

        return document == null ? null : deserialize(document);
    }

    @Override
    public T findByTwo(String key, Object value, String keyTwo, Object valueTwo) {
        Document document = collection.find(and(eq(key, value), eq(keyTwo, valueTwo))).first();

        return document == null ? null : deserialize(document);
    }

    @Override
    public T findByThree(String key, Object value, String keyTwo, Object valueTwo, String keyThree, Object valueThree) {
        Document document = collection.find(and(eq(key, value), eq(keyTwo, valueTwo), eq(keyThree, valueThree)))
                .first();

        return document == null ? null : deserialize(document);
    }

    @Override
    public List<T> findAll() {
        List<T> list = Lists.newArrayList();

        for (Document document : collection.find()) {
            list.add(deserialize(document));
        }

        return list;
    }

    @Override
    public void create(T object) {
        collection.insertOne(serialize(object));
    }

    @Override
    public void update(T object) {
        collection.updateOne(eq("id", object.getPrimaryKey()), new Document("$set", serialize(object)));
    }

    @Override
    public void delete(T object) {
        collection.deleteOne(eq("id", object.getPrimaryKey()));
    }

    private Document serialize(T object) {
        return Document.parse(gson.toJson(object));
    }

    private T deserialize(Document document) {
        return document == null ? null : gson.fromJson(document.toJson(), type);
    }
}
