/**
 * 
 */
package com.har.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * @author HSandadi
 *
 */
public final class ExpensesUtil {
	public static Date getDateFromString(final String sDate) {
		if (sDate == null)
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date date = dateFormat.parse(sDate);
			return date;
		} catch (ParseException e) {
			return null;
		}

	}

	public static String getStringFromDate(final Date date) {
		if (date == null)
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		String sDate = dateFormat.format(date);
		return sDate;

	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmptyList(Collection collection) {
		if (collection == null || collection.isEmpty())
			return true;
		return false;
	}

}
