package com.personalcv.personal_cv_project;


import com.fasterxml.jackson.databind.JsonNode;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Firebase {
    private static Firebase firebase;

    public static Firebase getInstance() throws IOException {
        if (firebase == null) {
            firebase = new Firebase();
        }
        return firebase;
    }

    public Firebase() throws IOException {

    }


    public void initialize() throws IOException {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://java-project-a39da-default-rtdb.firebaseio.com")
                    .setProjectId("java-project-a39da")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void addDataToDocument(String documentName, Map<String, Object> data) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("resumes").document(documentName);
        ApiFuture<WriteResult> result = docRef.set(data);
    }

    public void createResume(Map<String, Object> dataMap) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("resumes").document();
        ApiFuture<WriteResult> result = docRef.create(dataMap);
    }

    public void updateData(Map<String, Object> dataMap, String resumeID) {
        System.out.println(dataMap);
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("resumes").document(resumeID);
        ApiFuture<WriteResult> result = docRef.set(dataMap);
    }

    public JsonNode retrieveData() throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> docsDataFields = new HashMap<>();
        ApiFuture<QuerySnapshot> future = db.collection("resumes").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        final String[] docKey = {null};
        Map<Resume, Object> resumes = new HashMap<>();
        System.out.println("resumes ");
        for (QueryDocumentSnapshot document : documents) {
            docsDataFields.put(document.getId(), document.getData());
        }
        docsDataFields.forEach((key, value) -> docKey[0] = key);
        if (!Params.isDocumentIDInit) {
            Params.currentPersonID = docKey[0];
            Params.isDocumentIDInit = true;
        }
        Params.documentsID.clear();
        docsDataFields.forEach((key, value) -> {
            Params.documentsID.add(key);
        });
        return new Utility().mapObjectToJson((Map) docsDataFields.get(Params.currentPersonID));
    }

    public JsonNode retrieveDocuments() throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> docsDataFields = new HashMap<>();
        ApiFuture<QuerySnapshot> future = db.collection("resumes").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            docsDataFields.put(document.getId(), document.getData());
        }
        return new Utility().mapObjectToJson((Map) docsDataFields);
    }


}
