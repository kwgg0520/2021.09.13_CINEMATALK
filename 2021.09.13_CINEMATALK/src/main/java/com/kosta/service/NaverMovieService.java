package com.kosta.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.kosta.dto.MovieDTO;

@Service
public class NaverMovieService {
    private static String clientID = "EvxSrU_oM5JH9mMnopLh";
    private static String clientSecret = "HE_wFEGp96";
 
  
    
    //display ==> 몇개 출력
    //start==>몇번쨰부터 (item)
    
	public List<MovieDTO> searchMovie(String keyword, int display , int start){
        List<MovieDTO> list = null;
        try {
            URL url;
            url = new URL("https://openapi.naver.com/v1/search/"
                    + "movie.xml?query="
                    + URLEncoder.encode(keyword, "UTF-8")
                    + (display !=0 ? "&display=" +display :"")
                    + (start !=0 ? "&start=" +start :""));
 
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
            urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream()));
           
            
            
            int eventType = parser.getEventType();
            MovieDTO b = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
	                case XmlPullParser.END_DOCUMENT: // 문서의 끝
	                    break;
	                case XmlPullParser.START_DOCUMENT:
	                    list = new ArrayList<MovieDTO>();
	                    break;
	                case XmlPullParser.END_TAG: {
	                    String tag = parser.getName();
	                    if(tag.equals("item"))
	                    {
	                        list.add(b);
	                        b = null;
	                    }
	                }
	                case XmlPullParser.START_TAG: {
	                    String tag = parser.getName();
	                    switch (tag) {
	                    case "item":
	                        b = new MovieDTO();
	                        break;
	                    case "title":
	                        if(b != null)
	                            b.setTitle(parser.nextText());
	                        break;
	                    case "link":
	                        if(b != null)
	                            b.setLink(parser.nextText());
	                        break;
	                    case "image":
	                        if(b != null)
	                            b.setImage(parser.nextText());
	                        break;
	                    case "subtitle":
	                        if(b != null)
	                            b.setSubtitle(parser.nextText());
	                        break;
	                    case "pubDate":
	                        if(b != null)
	                            b.setPubDate(parser.nextText());
	                        break;
	                    case "director":
	                        if(b != null)
	                            b.setDirector(parser.nextText().replace("|", ""));
	                        break;
	                    case "actor":
	                        if(b != null)
	                        	b.setActorList(parser.nextText().replace("|", ",").split(","));
	//                            b.setActor(parser.nextText());
	                        break;
	                   
	                    case "userRating":
	                        if(b != null)
	                            b.setUserRating(parser.nextText());
	                        break;
	                  
	                    }
	                    
	                }
                }
                eventType = parser.next();
            }
            
            
            
            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}