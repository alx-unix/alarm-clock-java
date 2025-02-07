import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Java Alarm Clock
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filepath = "Pufino - Enlivening (freetouse.com).wav";



        while(alarmTime == null){
            try{
                System.out.println("Enter an alarm time (HH:mm:ss) :");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime,formatter);

                System.out.println("Alarm set for " + alarmTime);
            }
            catch (DateTimeParseException e){
                System.out.println("That is not a correct time slot: don't forget the format should be HH:mm:ss");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filepath, scanner);
        Thread alarmThread = new Thread(alarmClock);

        alarmThread.start();

        scanner.close();

    }
}
