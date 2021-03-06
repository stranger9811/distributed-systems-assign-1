/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "find-day.h"

int * days_to_be_added_1_svc(date *argp,struct svc_req *rqstp)
{

	static int  result;

	int year = argp->year_lower;
	int month = argp->month;
	int day_of_month = argp->day;
	if(month > 2) {
		result = (year / 4) - (year / 100) + (year / 400);
	}
	else
	{
		year--;
		result = (year / 4) - (year / 100) + (year / 400);
	}
	/*
	 * insert server code here
	 */

	return(&result);
}

int * days_elapsed_1_svc(date *argp,struct svc_req *rqstp)
{

	static int  result;
	int year = argp->year_lower;
	int month = argp->month;
	int day_of_month = argp->day;

	int total_days = (year - 1)*365 + day_of_month - 1;
	int i=0;
	for(i=1; i< month; i++) {
		if(i == 1 || i==3 || i==5 || i==7 || i==8 || i==10 ) {
			total_days = total_days + 31;
		}
		else if(i==2) {
			total_days = total_days + 28;
		}
		else {
			total_days += 30;
		}
	}
	result = total_days;

	/*
	 * insert server code here
	 */

	return(&result);
}

int * find_day_1_svc(date *argp,struct svc_req *rqstp)
{

	static int  result;

	result = argp->day;

	result = result%7;
	/*
	 * insert server code here
	 */

	return(&result);
}


int *
find_difference_between_dates_1_svc(find_diff *argp,struct svc_req *rqstp)
{

	static int  result;

	int no_of_days1;
	no_of_days1 = argp->lower/7;
	if(argp->lower%7>=argp->specific_day) 
		no_of_days1++;

	int no_of_days2;
	no_of_days2 = argp->upper/7;
	if(argp->upper%7>=argp->specific_day) 
		no_of_days2++;

	result = no_of_days2 - no_of_days1;
	/*
	 * insert server code here
	 */

	return(&result);
}