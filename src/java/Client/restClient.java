/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class restClient
 {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost:8080/LibaryWeb/webresources/entity.Book");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();
            
            System.out.println(output);

            System.out.println("Output from Server .... \n");
            
            if (output!= null) {
                System.out.println(output);
            }
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            Teacher[] teachers = gson.fromJson(output, Teacher[].class);
////
//            List<Teacher> teachersList = Arrays.asList(teachers);
//
//            for (Teacher te : teachers) {
//                System.out.println(te.getName());
//
//            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
