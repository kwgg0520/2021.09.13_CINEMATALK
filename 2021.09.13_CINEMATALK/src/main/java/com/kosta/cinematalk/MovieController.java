package com.kosta.cinematalk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.MovieDTO;
import com.kosta.service.NaverMovieService;
 
 
@Controller
public class MovieController {
    @Autowired
    private NaverMovieService service;
  
    //키워드가 있을때도 있고 없을때도있음 
    //있을때는 가져가고 없을때는 안가져가고
    @RequestMapping("movieList.do")
    public ModelAndView movieList(@RequestParam(required=false)String keyword){
        ModelAndView mav = new ModelAndView();
        
        if(keyword !=null)
        {
        	List<MovieDTO> movieList=service.searchMovie(keyword, 100 ,1);
			mav.addObject("movieList", movieList);
        }
        mav.setViewName("movieList");
        return mav;
    }
}
 
