#define VERSION_NUMBER 1 // Defines the version number of specification
struct date { 
	int day; 
	int month; 
	int year;
};
program SIMP_PROG {
	version SIMP_VERSION {
		int days_to_be_added(date) = 1; /* function id = 1 */
		int days_elapsed(date) = 2; /* function id = 2 */
		int find_day(date) = 3;
	} = 1; /* Version number of program */
} = 0x39876543; /* ID of program */
