package br.com.belaAgenda.infra.util;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class InitAplication implements ServletRequestListener {


    public void requestDestroyed(ServletRequestEvent arg0)  { 
    }


    public void requestInitialized(ServletRequestEvent arg0)  { 
    	Global.path = arg0.getServletContext().getRealPath("").replace("\\", "/");
    }
	
}
