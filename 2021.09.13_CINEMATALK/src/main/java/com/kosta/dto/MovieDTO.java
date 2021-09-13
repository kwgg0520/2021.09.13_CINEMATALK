package com.kosta.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MovieDTO {
	  public String title;
      public String link;
      public String image;
      public String subtitle;
      public String pubDate;
      public String director;
      public String actor;
      public String userRating;
      public String[] actorList;
}