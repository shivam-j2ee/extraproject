package in.co.rays.project_4.utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.Object;

import com.sun.org.glassfish.external.statistics.TimeStatistic;

public class DataUtility {
	public static final String APP_DATE_FORMAT="MM/dd/yyyy";
	public static final String APP_TIME_FORMAT="MM/dd/yyyy HH:mm:ss";
	public static final SimpleDateFormat formatter=new SimpleDateFormat(APP_DATE_FORMAT);
	public static final SimpleDateFormat timeFormatter=new SimpleDateFormat(APP_TIME_FORMAT);
	
	public static String getString(String val){
		if(DataValidator.isNotNull(val)){
			return val.trim();
		}else{
			return val;
		}
	}
	public static String getStringData(Object val){
		if(val!=null){
			return val.toString();
		}else{
			return "";
		}
	}
	
	public static int getInt(String val){
		if(DataValidator.isInteger(val)){
			return Integer.parseInt(val);
		}else{
			return 0;
		}
	}
	
	public static Long getLong(String val){
		if(DataValidator.isLong(val)){
			return Long.parseLong(val);
		}else{
			return (long) 0;
		}
	}
	
	public static Date getDate(String val){
		Date date=null;
		try{
			date=formatter.parse(val);
			
		}catch(Exception e){
		}
		
		return date;
		}
		
	public static String getDateString(Date date){
		try{
			return formatter.format(date);
		}catch(Exception e){
			
		}
		return "";
		
	}
	public static Date getDate(Date date,int day){
		return null;
	}
	public static Timestamp geTimestamp(String val){
		Timestamp timeStamp=null;
		try{
			timeStamp=new Timestamp(timeFormatter.parse(val).getTime());
			
		}catch(Exception e){
			return null;
		}
		return timeStamp;
		
	}
	public static  Timestamp getTimeStamp(long l){
		Timestamp timeStamp=null;
		try{
			timeStamp=new Timestamp(l);
			
		}catch(Exception e){
			return null;
		}
		return timeStamp;
	}
	public static Timestamp getCurrentTimeStamp(){
		Timestamp timeStamp=null;
		try{
			timeStamp=new Timestamp(new Date().getTime());
		}catch(Exception e){
			
		}return timeStamp;
		
	}
	public static long getTimestamp(Timestamp tm) {
        try {
            return tm.getTime();
        } catch (Exception e) {
            return 0;
        }
    }
	}

