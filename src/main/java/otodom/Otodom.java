package otodom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Otodom {

    public static void main(String[] args) throws Exception {

        URL otodom = new URL("https://www.otodom.pl/sprzedaz/mieszkanie/sopot/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(otodom.openStream()));

        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }

        in.close();
        Set<String> links = new TreeSet<>();
        String content = stringBuilder.toString();

        for (int i = 0; i < content.length(); i++) {
            i = content.indexOf("https://www.otodom.pl/oferta/", i);

            if(i < 0){
                break;
            }
            String substring = content.substring(i);
            String link = substring.split(".html")[0];
            links.add(link);
        }
        links.forEach(System.out::println);
        System.out.println(links.size());
    }
}
