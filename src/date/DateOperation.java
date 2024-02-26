package date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import commonChecker.CommonChecker;
import customException.CustomException;
public class DateOperation {
	
	public LocalDateTime getCurrentTime() {
		return  LocalDateTime.now();
	}
	
	public ZonedDateTime getCurrentTimeSpecificLoc(String location) throws CustomException {
		CommonChecker.checkNull(location);
		return  ZonedDateTime.now(getZoneId(location));
	}
	
	public long currentTimeMillis() {
		return System.currentTimeMillis();
	}
	
	public ZoneId getZoneId(String inputString) throws CustomException {
		CommonChecker.checkNull(inputString);
		return ZoneId.of(inputString);
	}
	
	
	public Month getMonth(long millisec,String zone) throws CustomException {
		Instant instant = Instant.ofEpochMilli(millisec);
		YearMonth yearMonth = YearMonth.from(instant.atZone(getZoneId(zone)));
		return yearMonth.getMonth(); 
	}
	
	public Year getYear(long millisec,String zone) throws CustomException {
		Instant instant = Instant.ofEpochMilli(millisec);
		return Year.from(instant.atZone(getZoneId(zone)));
	}
	
	public String getDay(long timeMillis,String zone) throws CustomException {
        Instant instant = Instant.ofEpochMilli(timeMillis);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,getZoneId(zone));
        return DayOfWeek.from(localDateTime).toString();
    }

	public ArrayList<String> getZoneIds() {
		return new ArrayList<>(ZoneId.getAvailableZoneIds());
	}
}
