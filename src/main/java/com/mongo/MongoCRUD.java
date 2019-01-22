package com.mongo;

import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.List;

public interface MongoCRUD {
    void addToDatabase(Document document);

    void addToDatabase(List<Document> documents);

    void updateOne(String parameter, Object valueBefore, Object newValue);

    void updateOne(String parameter, Object parameterValue, String newParameter, Object newParameterValue);

    void updateMany(String parameter, Object valueBefore, Object newValue);

    void updateMany(String parameter, Object parameterValue, String newParameterName, Object newParameterValue);

    void deleteOne(String parameter, Object parameterValue);

    void deleteMany(String parameter, Object parameterValue);

    FindIterable showByParameters(List<String> parameters, boolean id);

}
