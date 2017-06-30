package cartracker.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cartracker.entity.Alert;
import cartracker.repository.AlertRepository;

/**
 * Created by mannu.
 */

@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    AlertRepository alertRepository;

    public List<Alert> getAllAlerts() {
        return alertRepository.getAllAlerts();
    }

    public List<Alert> gethighAlerts(int hours) {
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	long currenttime=timestamp.getTime();
    	long caltime = currenttime - (hours*3600000);
    	Timestamp time = new Timestamp(caltime);	
    	List<Alert> alertlist= alertRepository.getAllAlerts();
    	List<Alert> output= new ArrayList<Alert>();
    	for(int i=0;i<alertlist.size();i++){
    		if(alertlist.get(i).getReading().getTimestamp().after(time)&& alertlist.get(i).getType().getId().equals("at-04")){
    			output.add(alertlist.get(i));
    		}
    	}

        return output;
    }
}
