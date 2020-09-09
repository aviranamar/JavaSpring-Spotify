package com.listsong.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class manager {
	
	public List<song> songList;
	public List<song> songs = new ArrayList<>();
	int[] previousChecked = new int[4];
	int index=0;
	
	public void songlist(HttpServletRequest request) {
		String [] maharah=request.getParameterValues("video"); 
		if(maharah!=null)
		{
			for(int i=0;i<songs.size();i++)
			{
				if(songs.get(i).getSongActive()==1) {
					for(int j=0;j<previousChecked.length;j++) {
						if(((previousChecked[i]) == 1)) {
							songs.get(i).setSongActive(0);
							previousChecked[i] = 0;
						}
					}
				}
			}
			
			for(int i=0;i<songs.size();i++)
			{
				if(songs.get(i).getSongActive()==0) {
					for(int j=0;j<maharah.length;j++) {
						if(Integer.parseInt(maharah[j]) == i) {
							songs.get(i).setSongActive(1);
							previousChecked[i] = 1;
						}
					}
				}
			}
		}
		request.setAttribute("songs", songs);
		request.getParameterValues("video"); 
	}
	
	public void mysongspre(HttpServletRequest request) {
		int thenum=0;
		int pgae=0;
		if(request.getParameter("index")!=null)
		{
			
			pgae=Integer.parseInt(request.getParameter("index"))-1;
		}
		
		for(int i=0;i<songs.size();i++)
		{
			if(songs.get(i).getSongActive()==1)
			{
				thenum++;
			}				
		}

		int j=0;
		song [] fff= new song[thenum];
		for(int i=0;i<songs.size();i++)
		{
			if(songs.get(i).getSongActive()==1)
			{
				fff[j]=songs.get(i);
				j++;	
			}		
		}
		
		if(pgae<0)
		{
			pgae=fff.length-1;
		}
		
		request.setAttribute("songs", fff);
		request.setAttribute("index", pgae);
	}
	
	public void mysongs(HttpServletRequest request) {
		int thenum=0;
		int pgae=0;
		if(request.getParameter("index")!=null)
		{
			pgae=Integer.parseInt(request.getParameter("index"))+1;
		}
		
		for(int i=0;i<songs.size();i++)
		{
			if(songs.get(i).getSongActive()==1)
			{
				thenum++;
			}				
		}

		int j=0;
		song [] fff= new song[thenum];
		for(int i=0;i<songs.size();i++)
		{
			if(songs.get(i).getSongActive()==1)
			{
				fff[j]=songs.get(i);
				j++;	
			}		
		}
		
		if(pgae>=fff.length)
		{
			pgae=0;
		}
		
		request.setAttribute("songs", fff);
		request.setAttribute("index", pgae);
	}
	
	public List<song> getsongs(){
		return songList;
	}	
	
	@PostConstruct
	public void doStartupActions(){
		
		System.out.println("Pre");
		songList = new ArrayList<>();
		
		songList.add(new song("Riboin Haolomim","Avraham Fried",0,"https://www.youtube.com/embed/_1g-xIP7tG0","06:30"));
		songList.add(new song("Hatov","Yonatan Razel",0,"https://www.youtube.com/embed/6V4us4q5v-c","04:42"));
		songList.add(new song("Katonti","Yonatan Razel",0,"https://www.youtube.com/embed/HZYivKwVmJc","04:42"));
		songList.add(new song("kayal tarog","Motty Steinmetz",0,"https://www.youtube.com/embed/xZWSaQSG1Ws","07:00"));
		
		this.songs = getsongs();
		
		for(int i=0;i<previousChecked.length;i++) {
			previousChecked[i] = 0;
		}
	}
	
	@PreDestroy
	public void doCleanupActions() 
	{
		System.out.println("After");
	}
}
