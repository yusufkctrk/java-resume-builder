package com.personalcv.personal_cv_project;


import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

    public void addData(String documentName) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("resumes").document(documentName);
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> mapH = new HashMap<>();
        mapH.put("yaş", 12);
        mapH.put("isim", "Yusuf");
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        data.put("born", 1811);
        data.put("personal", mapH);
        ApiFuture<WriteResult> result = docRef.set(data);
    }

    public void createData(Map<String, Object> dataMap) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("resumes").document();
        ApiFuture<WriteResult> result = docRef.create(dataMap);
    }

    public void retrieveData() throws ExecutionException, InterruptedException {
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
        Map<Resume, Object> resumes = new HashMap<>();

        for (QueryDocumentSnapshot document : documents) {
            docsDataFields.put(document.getId(), document.getData());
        }
        final ArrayList<String>[] skillsArray = new ArrayList[]{new ArrayList<>()};
        docsDataFields.forEach((key, value) -> {
            System.out.println(key + ": " + value);
            skillsArray[0] = (ArrayList<String>) ((Map) ((Map) docsDataFields.get(key)).get("skillsInformation")).get("skills");
        });
        skillsArray[0].forEach(System.out::println);

    }
}
