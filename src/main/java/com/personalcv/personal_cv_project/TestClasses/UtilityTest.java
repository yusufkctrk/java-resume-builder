package com.personalcv.personal_cv_project.TestClasses;

import com.fasterxml.jackson.databind.JsonNode;
import com.personalcv.personal_cv_project.Params;
import com.personalcv.personal_cv_project.PersonalInformation;
import com.personalcv.personal_cv_project.Utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UtilityTest {
    Utility utility = new Utility();
    PersonalInformation personalInformation = new PersonalInformation();

    public UtilityTest() throws IOException {
        personalInformation.setFullname("Yusuf Kocatürk");
        personalInformation.setPhoneNumber("5555555555");
        personalInformation.setMail("example@xc.com");
        personalInformation.setBirthDate("28.08.2016");
        personalInformation.setZipCode("34119");
        personalInformation.setAddress("Sirekci/İstnabul");
        personalInformation.setGender("male");

        Map<String, Object> mapUser = new HashMap<>();

        mapUser.put(Params.fullname, personalInformation.getFullname());
        mapUser.put(Params.gender, personalInformation.getGender());
        mapUser.put(Params.address, personalInformation.getAddress());
        mapUser.put(Params.zipCode, personalInformation.getZipCode());
        mapUser.put(Params.birthdate, personalInformation.getBirthDate());
        mapUser.put(Params.phoneNumber, personalInformation.getPhoneNumber());
        mapUser.put(Params.mail, personalInformation.getMail());


        JsonNode json = utility.mapObjectToJson(mapUser);
        System.out.println(json);

        System.out.println("İsim Soyisim: "+json.get(Params.fullname).asText() );
        System.out.println("Cinsiyet: "+json.get(Params.gender).asText() );
        System.out.println("Doğum Tarihi: "+json.get(Params.birthdate).asText() );
        System.out.println("Telefon Numarası: "+json.get(Params.phoneNumber).asText() );
        System.out.println("Mail: "+json.get(Params.mail).asText() );
        System.out.println("Adres: "+json.get(Params.address).asText() );
        System.out.println("Posta Kodu: "+json.get(Params.zipCode).asText() );
    }
}
