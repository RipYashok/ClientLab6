package models.utils;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class FormaterZonedDataTime {

    public static String Formating(ZonedDateTime zdt){
        String zoneDisplayName = zdt.getZone().getDisplayName(TextStyle.SHORT, Locale.getDefault());
        String zoneOffset = zdt.getOffset().getId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'GMT'" + zoneOffset + " ('" + zoneDisplayName + "')");
        String formattedDateTime = zdt.format(formatter);
        return formattedDateTime;
    }

}
