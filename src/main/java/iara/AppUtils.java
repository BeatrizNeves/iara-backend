package iara;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

public class AppUtils {
    public static boolean isObjectEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String) {
            if (((String) object).trim().length() == 0) {
                return true;
            }
        } else if (object instanceof Collection) {
            return isCollectionEmpty((Collection<?>) object);
        } else if (object instanceof StringBuilder) {
            return ((((StringBuilder) object).toString()).trim().length() == 0);
        } else if (object instanceof Enumeration) {
            return object == null || !(((Enumeration<?>) object).hasMoreElements());
        }
        return false;
    }

    public static boolean isCollectionOfEmptyObjects(Collection<?> collection) {
        if (isObjectEmpty(collection)) {
            return true;
        }
        for (Object i : collection) {
            if (!isObjectEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCollectionOfEmptyObjects(Object... collection) {
        return isCollectionOfEmptyObjects(Arrays.asList(collection));
    }
    
    public static Date parseAsDate(String text, DateFormat format) {
        try {
            return format.parse(text);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Integer parseAsInt(String text) {
        if (isObjectEmpty(text)) {
            return null;
        }
        try {
            return Integer.valueOf(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Long parseAsLong(String text) {
        if (isObjectEmpty(text)) {
            return null;
        }
        try {
            return Long.valueOf(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static boolean isCollectionEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }
}