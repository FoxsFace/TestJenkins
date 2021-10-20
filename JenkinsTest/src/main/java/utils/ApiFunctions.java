/*package utils;

import Constants.Config;
import Constants.TestValues;
import Models.Responce;
import aquality.selenium.core.logging.Logger;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiFunctions{

    public static Responce sendGet(String endpoint){
        Responce responce = new Responce();
        Logger.getInstance().info("Prepairing to send GET request");
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(Config.HOME_HTTP + endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            Logger.getInstance().info("Sending GET request");
            connection.setRequestProperty("Content-type", TestValues.CONTENT_TYPE);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                responce.setResponseCode(connection.getResponseCode());
                responce.setContentType(connection.getContentType());
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                responce.setContent(content.toString());
            }
            else {
                responce.setResponseCode(connection.getResponseCode());
                responce.setContentType(connection.getContentType());
                Logger.getInstance().info("Reading the content");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                responce.setContent(content.toString());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            Logger.getInstance().error(e.getMessage());
        }
        finally {
            connection.disconnect();
        }
        return responce;
    }

    public static Responce sendPost(String endpoint, String responce){
        Responce responcePost = new Responce();
        Logger.getInstance().info("Prepairing to send POST request");
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(Config.HOME_HTTP + endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", TestValues.CONTENT_TYPE);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();
            Logger.getInstance().info("Sending POST request");
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
            writer.write(responce.getBytes(StandardCharsets.UTF_8));
            responcePost.setResponseCode(connection.getResponseCode());
            responcePost.setContentType(connection.getContentType());
            writer.close();
            Logger.getInstance().info("Checking the content");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            Logger.getInstance().info("Reading the content");
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            responcePost.setContent(content.toString());
            connection.disconnect();

        } catch (IOException e) {
            responcePost.setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST);
            e.printStackTrace();
            Logger.getInstance().error(e.getMessage());
        }
        finally {
            connection.disconnect();
        }
        return responcePost;
    }
}*/