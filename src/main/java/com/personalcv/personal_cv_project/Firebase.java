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

 /*       Skills skills = new Skills();
        docsDataFields.forEach((key, value) -> {
            System.out.println(key + ": " + value);
            skills.setSkills((ArrayList<String>) ((Map) ((Map) docsDataFields.get(key)).get("skillsInformation")).get("skills"));

        });
        skills.getSkills().forEach(System.out::println);
*/
        final String[] docKey = {null};
        Map<Resume, Object> resumes = new HashMap<>();
        for (QueryDocumentSnapshot document : documents) {
            docsDataFields.put(document.getId(), document.getData());
        }
        docsDataFields.forEach((key, value) -> docKey[0] = key);
        Params.currentPersonID = docKey[0];
        return new Utility().mapObjectToJson((Map) docsDataFields.get(docKey[0]));


    }
}
