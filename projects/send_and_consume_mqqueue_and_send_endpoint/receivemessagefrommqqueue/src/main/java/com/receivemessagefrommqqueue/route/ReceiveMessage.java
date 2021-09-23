package com.receivemessagefrommqqueue.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.receivemessagefrommqqueue.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component

public class ReceiveMessage extends RouteBuilder{

	
	@Autowired
	GetEmployee getEmployee;
	
	
	
	@Override
	public void configure() throws Exception {
		
		from("activemq:test-activemq-queue")
		.unmarshal().json(JsonLibrary.Jackson, Employee.class)
		.bean(getEmployee)
		.to("log:myloggingqueue");
		
		
	}
	
	
	@Component
	class GetEmployee{
	    Logger logger= LoggerFactory.getLogger(GetEmployee.class);
	    public void getData(Employee employee){
	        logger.info("Emp data: "+employee.getId()+" Name: "+employee.getName());
	    }
	}
}
