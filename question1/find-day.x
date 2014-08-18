#define VERSION_NUMBER 1 // Defines the version number of specification
struct date { 
	unsigned int day; 
	unsigned int month; 
	unsigned int year_upper;
	unsigned int year_lower;
};
struct find_diff {
	unsigned int upper;
	unsigned int lower;
	unsigned int specific_day;
};
struct result {
	unsigned int low;
	unsigned int upp;
};
program SIMP_PROG {
	version SIMP_VERSION {
		int days_to_be_added(date) = 1; /* function id = 1 */
		int days_elapsed(date) = 2; /* function id = 2 */
		int find_day(date) = 3;
		int find_difference_between_dates(find_diff) = 4;
	} = 1; /* Version number of program */
} = 0x39876543; /* ID of program */
