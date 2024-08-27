package com.bala.spring.mydairy.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bala.spring.mydairy.business.EntryBusinessInterface;
import com.bala.spring.mydairy.business.UserBusinessInterface;
import com.bala.spring.mydairy.entities.Entry;
import com.bala.spring.mydairy.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserBusinessInterface userBusinessInterface;
	@Autowired
	private EntryBusinessInterface entryBusinessInterface;
	@Autowired
	HttpSession session;
	
	


	public EntryBusinessInterface getEntryBusinessInterface() {
		return entryBusinessInterface;
	}

	public void setEntryBusinessInterface(EntryBusinessInterface entryBusinessInterface) {
		this.entryBusinessInterface = entryBusinessInterface;
	}

	@RequestMapping("login")
	public ModelAndView homepage() {
		ModelAndView model=new ModelAndView("loginform");
		return model;
	}
	
	@RequestMapping("register")
	public ModelAndView registrationpage() {
		ModelAndView model=new ModelAndView("registrationform");
		return model;
	}
	
	
	
	@RequestMapping(value="saveuser",method=RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user") User user) {
		ModelAndView model=new ModelAndView("registersuccess");
		userBusinessInterface.save(user);
		return model;
	}
	
	@RequestMapping(value="authenticate",method=RequestMethod.POST)
	public ModelAndView authenticateuser(@ModelAttribute("user") User user) {
		ModelAndView model=new ModelAndView("loginform");
		//login page lovi db lo match chese code rayali
		User user1=userBusinessInterface.findByUsername(user.getUsername());
		//db password is equals to the user attribute
		if(user1!=null && user.getPassword().equals(user1.getPassword()))
		{
			model.setViewName("userhomepage");
			model.addObject("user", user1);
			
			session.setAttribute("user", user1);
			
			List<Entry> entries=null;
			try {
				entries=entryBusinessInterface.findByUserid(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addObject("entrieslist", entries);
		}
		
		return model;
	}	
	@RequestMapping("addentry")
	public ModelAndView addentry() {
		ModelAndView model=new ModelAndView("addentryform");
		
		return model;
	}
	@RequestMapping("saveentry")
	public ModelAndView saveentry(@ModelAttribute("entry") Entry entry) {
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.save(entry);
		User user1=(User) session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryBusinessInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		
		
		return model;
	}
	@RequestMapping("viewentry")
	public ModelAndView viewentry(@RequestParam("id") int id) {
		ModelAndView model=new ModelAndView("displayentry");
		Entry entry=entryBusinessInterface.findById(id);
		model.addObject("entry",entry);
		
		return model;
	}
	@RequestMapping("userhome")
	public ModelAndView userhome() {
		ModelAndView model=new ModelAndView("userhomepage");
		User user1=(User) session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryBusinessInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
	
		return model;
	}
	@RequestMapping("updateentry")
	public ModelAndView updateentry(@RequestParam("id") int id) {
		ModelAndView model=new ModelAndView("displayentryupdate");
		Entry entry=entryBusinessInterface.findById(id);
		model.addObject("entry",entry);
		User user1=(User) session.getAttribute("user");
		if(user1==null) {
			model.setViewName("loginform");
		}
		
		return model;
	}
	@RequestMapping("processentryupdate")
	public ModelAndView processentryupdate(@ModelAttribute("entry") Entry entry) {
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.update(entry);
		User user1=(User) session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryBusinessInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		
		
		return model;
	}
	@RequestMapping("deleteentry")
	public ModelAndView deleteentry(@RequestParam("id") int id)
	{
		ModelAndView model=new ModelAndView("userhomepage");		
		User user1=(User) session.getAttribute("user");
		Entry entry=entryBusinessInterface.findById(id);
		entryBusinessInterface.delete(entry);
		if(user1==null) {
			model.setViewName("loginform");
		}
		else {
			entryBusinessInterface.delete(entry);
		}List<Entry> entries=null;
		try {
		entries=entryBusinessInterface.findByUserid(user1.getId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
	e.printStackTrace();
	}
	model.addObject("entrieslist", entries);

	return model;
}

	@RequestMapping("signout")
	public ModelAndView signout() {
		ModelAndView model=new ModelAndView("loginform");
		session.invalidate();
		return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public UserBusinessInterface getUserBusinessInterface() {
		return userBusinessInterface;
	}

	public void setUserBusinessInterface(UserBusinessInterface userBusinessInterface) {
		this.userBusinessInterface = userBusinessInterface;
	}
	
	

}
