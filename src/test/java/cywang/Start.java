package cywang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import schedule.job.impl.LeftJobServiceImpl;
import schedule.job.impl.RightJobServiceImpl;

public class Start {
	
	public static void main(String[] args){
		
		Logger logger = LoggerFactory.getLogger(Start.class);
		logger.info("Can it work?");
		
    	BeanFactory bf = new ClassPathXmlApplicationContext("spring.xml");
/*        App at=(App)bf.getBean("app");
        at.getPerson().printPerson();*/
    	
    	new Thread(){
    		@Override
    		public void run(){
    			while(true){
    				try{
        				Thread.sleep(1000);
        			} catch (Exception e) {
        				// ignore
        			}
        			String left = (LeftJobServiceImpl.leftLight)? "on" : "off";
        	    	String right = (RightJobServiceImpl.rightLight)? "on" : "off";
        			System.out.println("left: " + left + " ,right: " + right);
    			}
    		}
    	}.start();
	}
}
