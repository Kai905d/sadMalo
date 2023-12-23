package com.own.ff14logsbot.mapper;


import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class HttpMapper {
    public Object getHttpSourceCodeByUrl(String url){
        try{
            Document document = Jsoup.connect(url).get();
            try {
                Elements elements = document.getElementsByTag("body");
                Element mainElement = elements.first().getElementById("content-and-footer");
                Element character = mainElement.getElementById("character-portrait-box");
                Element characterInset = character.getElementById("character-inset");
                Element portraitAndBasics = characterInset.getElementById("portrait-and-basics");
                Element characterBasics = portraitAndBasics.getElementById("character-basics");
                Element characterName = characterBasics.getElementById("character-name");
                Elements nameElement = characterName.getElementsByTag("a");
                String name = nameElement.toString();
                return name;

            }catch (Exception e){
                e.printStackTrace();
                log.warn("exists null tag");
                return "null tag";
            }
        }catch (Exception e){
            log.error("get source code failed");
            e.printStackTrace();
            return null;
        }
    }
}
