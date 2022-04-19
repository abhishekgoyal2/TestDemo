package com.bh.assign.helper;

import com.bh.assign.model.organization.CreateOrgranization;
import com.bh.assign.model.organization.Phone;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RandomGenrator {
    CreateOrgranization createOrgranization = new CreateOrgranization();

    public static String getRandomString(String inputString) {
        final int RANDOM_UPPER_LIMIT = 900000;
        final int RANDOM_LOWER_LIMIT = 100000;
        int randomInt = (int) (Math.floor(Math.random() * RANDOM_UPPER_LIMIT) + RANDOM_LOWER_LIMIT);
        return inputString + randomInt;
    }

    public String stringGen(int len) {
        var text = "";

        var charset = "abcdefghijklmnopqrstuvwxyz";

        for (var i = 0; i < len; i++)
            text += charset.charAt((int) Math.floor(Math.random() * charset.length()));

        return text;
    }
//    String name= stringGen(5);

    public String convertObjectIntoString(Object key) {
        return (String) key;
    }

   @Test
    public JSONObject getRequestBody() throws IOException {
       Map<String, Object> organizationObject = new HashMap<>();
       organizationObject.put("phone.number","12345678");
       organizationObject.put("phone.extension","91");
       String phoneNumber = (String) organizationObject.get("phone.number");
       String phoneExtension = (String) organizationObject.get("phone.extension");

       System.out.println("getting phone number ->> " + phoneNumber);

       JSONObject requestBody =new JSONObject();
       String name=  getRandomString("name").toString();
//       organizationObject.put("name",name);
       String email = getRandomString("email")+"@qa4life.com";
       System.out.println("getting name >> " +name);
          createOrgranization.setName(name);
//       requestBody.put("name",name);
//       requestBody.put("email",email);
       FileWriter file = new FileWriter(APIConstants.fileBasePath + "Jsonfile/Orgranization/CreateOgranization.json");
       createOrgranization.setName(name);
       createOrgranization.setEmail(email);
       Phone phone = new Phone();
       phone.setNumber(String.valueOf(phoneNumber));
       phone.setExtension(phoneExtension);
       phone.setCountryCode("US");
       createOrgranization.setPhone(phone);
       createOrgranization.setSignInLink(convertObjectIntoString(organizationObject.get("signInLink")));
       createOrgranization.setTimezone(convertObjectIntoString(organizationObject.get("timezone")));
       createOrgranization.setWebsiteUrl(convertObjectIntoString(organizationObject.get("websiteUrl")));
//       createOrgranization.setAddress(addressVO);
//       createOrgranization.setLocale(localeData);
       requestBody.put("name",name);
       requestBody.put("email",email);
       requestBody.put("phone",phone);
       requestBody.put("signInLink","https://test.url.qa4life.com");
       file.write(requestBody.toString());
       System.out.println("getting createOrgranization ->> " + createOrgranization.getPhone());

       System.out.println("getting request body ->> " + requestBody);
       return requestBody;
    }


//postman.setEnvironmentVariable("name", "Singh"+name);


//    List<String> names = ["Savage", 'Stephens', 'Sparks', 'Stark', 'Sparks', 'Bottin', 'Jones', 'Arthurson', 'Harden', 'Gray', 'Bryson', 'Matthison', 'Wilson', 'Ivey', 'Netzley', 'Piche','Metz','Cass','Kuzma','Reno','Avis','Saville','Selvey','Stoecker','Auerbach','Eilerman','Holsey','Zepp','Davids','Foster','Sim','Messana','Schloss','Sylvester','Leathers','Niles','Combs','Phillips','Augsburger','Stroman','Beveridge','Gattis','Minnis','Fortes','Ullman','Bunkley','Spivey','Sterrett','Crist','Chow','Lierman','Ashalintubbi','Laura','Crawford','Balmer','Mcmullin','Dussault','Holbrook','Dion','Lechler','Beaton','Elzey','Sams','Irby','Hollaway','Levert','Gough','Croom','Dedman','Hatmaker','Tippetts','Odoms','Banaszak','Viveros','Hempstead','Tower','Atlas','Lozoya','Fulp','Corbo','Chapell','Monier','Selle','Parenti','Karl','Kuehn','Speers','Cambron','Blossom','Peart','Gunter','Hagenbuch','Amend','Tiernan','Ayala','Maclenn','Golden','Colone','Golding','Landreth','Shams','Liddle','Alley','Levy','Barajas','Tetrault','Shue','Lenton','Boss','Weedman','Bergeron','Valls','Pooler','Mollett','Viger','Donnellan','Dedeaux'];

//    String randName1 = names[Math.floor(Math.random() * names.size())];
//postman.setEnvironmentVariable("randName", randName1);
}
