package com.kosta.cinematalk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.ActorDTO;
import com.kosta.service.NaverActorService;

@Controller
public class ActorController {
	@Autowired
    private NaverActorService service;
  
    //키워드가 있을때도 있고 없을때도있음 
    //있을때는 가져가고 없을때는 안가져가고
    @RequestMapping("actorList.do")
    public ModelAndView actorList(@RequestParam(required=false)String keyword){
        ModelAndView mav = new ModelAndView();
        
        if(keyword !=null)
        {
        	List<ActorDTO> actorList=service.searchActor(keyword, 10 ,1);
        	String actor=actorList.get(0).getThumbnail();
			mav.addObject("actor", actor);
        }
        mav.setViewName("actorList");
        return mav;
    }
}