/**
* This program will prompt the user to enter a year and then will 
* display accurate calendars for each month of that year.
* This program will complete Module 4 Assignment 1 for 605.201.82. 
*
* @author Candace Holcombe-Volke
*
*/


import java.util.Scanner;

public class YearCalendar
{
    /**
     * This method creates a user input variable for year. Then 
     * it invokes the printMonthCalendar method.
     * 
     * @param year is the user input variable for the desired year of the cal
     *
     * precondition: year is an integer
     * postcondition: will transfer control to printMonthCalendar with 
     * year argument
     * 
     * @author Candace Holcombe-Volke
     */
    public static void main( String [] args )
    {
        int year;   


        // Create a Scanner to obtain user input
        Scanner input = new Scanner( System.in ); 
        

        // Get user input for year
        System.out.println("Enter the year (YYYY format): ");
        year = input.nextInt();
    
        // Pass year value to printMonthCalendar method
        printMonthCalendar( year );
    }




    /** 
     * This method calls methods printMonthHeader and printMonthBody 
     * with varaible year declared in main() and combines
     * their output to display calendars for each month in the year. 
     *
     * @param month isan integer initalized at 1
     *
     * precondition: year called in main will be used
     *
     * postcondition: month will increase to 12
     * printMonthHeader and printMonthBody
     * 
     * @author Candace Holcombe-Volke
     */
    public static void printMonthCalendar( int year )
    {
        int month = 1; 
        
        // Prints calendars for all months 1-12 for specified year
        while(month <=12)
        {
        // Prints the month name, year, dashed line, and days of the week
        printMonthHeader( month, year ); 
        
        // Prints the days of the week in the appropriate space on the cal
        printMonthBody( month, year );
        System.out.println();
        System.out.println();
        month++;
        }
    }



    /**
     * This method displays the header information (month name, year, line 
     * separator, 3-character day names) for the calendar
     * 
     * precondition: method uses argument year from main() which is an int
     * postcondition: invokes method getMonthHeader to assign month int
     * to string name of month.
     * 
     * @author Candace Holcombe-Volke
     */
    public static void printMonthHeader( int month, int year )
    {
        System.out.println();
        System.out.println("\t\t" + getMonthName( month ) + " " + year);
        System.out.println("------------------------------------------------");
        System.out.println("Sun" + "\t" + "Mon" + "\t" + "Tue" + "\t" + "Wed" +    "\t" + "Thu" + "\t" + "Fri"  + "\t" + "Sat");
    }


    /**
     * This method displays the days in the calendar associated with the 
     * appropriate days of the week. It invokes method getNumDaysInMonth. 
     * 
     * @param variabe daysInMonth is equal to the total number of days in 
     * the int month variable. 
     * @param dayNum is equal to the return value of getStartDay() using the 
     * month and year arguments; is the number of the day of the 1st (1, Sun)
     * @param variable spacesAtBeginning skips the appropriate number of days 
     * of the first week of the month so that the 1st starts on the correct day
     * @param label is the variable to output the correct date on the correct
     * calendar space
     * @param calendarSpace is the physical location on the calendar, used to 
     * enter to next week after Saturday
     *
     * precondition: daysInMonth, dayNum, spacesAtBeginning, label and 
     *  calendarSpace are integer variables. 
     * precondition: days in month are less than 32
     * precondition: spacesAtBeginning are less than 8
     * precondition: dayNum is less than 8
     * 
     * postcondition: method transfers to getNumDaysInMonth for input
     * postcondition: calendarSpace is increased to dayNum + 
     *   label
     * postcondition: label is increased to total num of days in month
     * postcondition: spacesAtBeginning is reduced to 0
     */
    public static void printMonthBody( int month, int year )
    {
        int daysInMonth = getNumDaysInMonth( month, year ); // num days in mon
        int dayNum = getStartDay(month, year);  // 1 for Sun, 2 for Mon, etc.
        // Number of blank days before the 1st of the month
        int spacesAtBeginning = getStartDay(month, year) + 1; 
        int label = 1;  // Number label for each day of the month


        // Move 1st of the month to the correct day column
        for( ; spacesAtBeginning < 8 && spacesAtBeginning > 1; 
            spacesAtBeginning--)
        {
            // Tabs starting location to correct day
            System.out.print( "\t");
        }
        // Loops until label is printed for each day of the month
        for( ; label <= daysInMonth; label++ )
        {
            // Location on calendar, prints the label in grid format by
            // adding starting date plus date label
            int calendarSpace = ((dayNum + label) ); 

            // Enters label to a new line after Saturday
            if(calendarSpace % 7 == 0)
            {
                System.out.println(label + "\t");
            }
            else
            {
                // prints label and moves to next day on same line
                System.out.print( label + "\t");
            }
        }
    }

 


    /**
     * Returns a String for the name of the month that matches the numeric 
     * user input for int month (e.g. returns March for m=3)
     *
     * @param monthName is the name that matches with the int month 
     *
     * precondition: monthName is a String
     * 
     * postcondition: returns a String value monthName
     * 
     * @author Candace Holcombe-Volke
     *
     */
   public static String getMonthName( int month )
    {
        String monthName = "  ";
        if( 1 <= month && month <= 12)
        {
            if ( month == 1 ) 
            {
                monthName = "January";
            }
               
            else if(month == 2 )
            {
                monthName = "February";
            }
            else if( month == 3)
            {
                monthName = "March";
            }   
            else if( month == 4 )
            {
                monthName = "April";
            }
            else if( month == 5)
            {
                monthName = "May";
            }
            else if( month == 6 )
            {
                monthName = "June";                
            }
            else if( month == 7 )
            {
                monthName = "July";
            }
            else if( month == 8 )
            {
                monthName = "August";
            }
            else if( month == 9)
            {
                monthName = "September";
            }
            else if( month == 10)
            {
                monthName = "October";
            }
            else if (month == 11)
            {    
                monthName = "November";
             }
            else if( month == 12 )
            {
                monthName = "Decemeber";
            }             
        }
    return monthName;
    }






    /****
        The method getStartDay() implements Zeller's Algorithm for 
        determining the
        day of the week the first day of a month is. The method 
        adjusts Zeller's numbering scheme for day of week ( 0=Saturday, 
        ..., 6=Friday ) to conform to a day of week number that corresponds to 
        ISO conventions (i.e., 1=Monday, ..., 7=Sunday)
      
      Pre-Conditions: The month value, m,  is 1-12
                      The year value, y, is the full year (e.g., 2012)
                      
      Post-Conditions: A value of 1-7 is returned, representing the 
      first day of the month: 1 = Monday, ..., 7 = Sunday
    ****/
    public static int getStartDay( int month,  int year )
    {
        final int day = 1; // Must be set to day 1 for this to work.  JRD.


        // Adjust month number & year to fit Zeller's numbering system
        if ( month < 3 ) 
        {
            month = month + 12;
            year = year - 1;
        }
        
        int yearInCent = year % 100;  // k Calculate year within century
        int century = year / 100;  // j Calculate century term int 
        int firstDay  = 0;     // h Day number of first day in month 'm'
        
        firstDay = (day + (13 * (month + 1) / 5) + yearInCent +
            (yearInCent / 4) + (century / 4) + (5 * century)) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ((firstDay + 5) % 7) + 1;     
        
        return dayNum;
    }





    /**
     * Returns the number of days in a specified month and year. Leap years
     * are accounted for. 
     * 
     * @param daysInMonth is the number of days in the specified month
     *
     * precondition: accepts integer year passed from main()
     *
     * postcondition: returns daysInMonth as integer
     * postcondition: invokes isLeapYear() with year argument
     *
     * @author Candace Holcombe-Volke
     */
    public static int getNumDaysInMonth( int month, int year)
    {
        int daysInMonth;

        // Assign variable for months with 31 days
        if( month == 1 || month == 3 || month ==5 || month == 7 || 
            month == 8 || month == 10 || month == 12)
        {
            daysInMonth = 31;
        }

        // Assign variable for months with 30 days
        else if( month == 4 || month == 6 || month == 9 || month == 11)
        {
            daysInMonth = 30; 
        }

        // Assign variable for February
        else
        {
            // Go to isLeapYear() for boolean 
            // Assign variable for leap years
             if(isLeapYear(year) == true)
            {
                daysInMonth = 29;
            }
            // Assign variable for non-leap years
            else
            {
                daysInMonth = 28;
            }
        }
        return daysInMonth; 
    }
     


    /** Returns true if the specified year is a leap year and returns false 
     * otherwise. 
     *
     * @param result stores the boolean determining if it is a leap year
     *
     * precondition: called in getNumDaysInMonth with year argument
     * 
     * postcondition: result = boolean for whether it is a leap year
     *
     * @author Candace Holcombe-Volke 
     */
    public static boolean isLeapYear( int year )
    {
        boolean result = year % 4 == 0; 
        return result;
    }  
}