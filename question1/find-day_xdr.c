/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "find-day.h"

bool_t
xdr_date(xdrs, objp)
	XDR *xdrs;
	date *objp;
{

	if (!xdr_int(xdrs, &objp->day))
		return (FALSE);
	if (!xdr_int(xdrs, &objp->month))
		return (FALSE);
	if (!xdr_int(xdrs, &objp->year))
		return (FALSE);
	return (TRUE);
}