package com.xmut.ly.imart;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
            String ip1 = getCommIpAddr();
            System.out.println("myIP:" + ip1);


    }

    public static String getCommIpAddr() {
        try {
            URL url = new URL("http://2020.ip138.com/ic.asp");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            StringBuffer sb = new StringBuffer("");
            String webContent = "";
            while ((s = br.readLine()) != null) {
                sb.append(s + "\r\n");
            }
            br.close();
            webContent = sb.toString();
            int start = webContent.indexOf("[")+1;
            int end = webContent.indexOf("]");
            webContent = webContent.substring(start,end);
            return webContent;
        } catch (Exception e) {
            return "error";
        }
    }


}
