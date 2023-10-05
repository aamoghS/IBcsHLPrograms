import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*; 
class Patient {
    String name;
    int waitTime;

    public Patient(String name, int waitTime) {
        this.name = name;
        this.waitTime = waitTime;
    }
}

public class DoctorClass {
    private static final int EXAM_ROOMS = 4;
    private static Queue<Patient> waitingRoom = new LinkedList<>();
    private static ArrayList<Patient> examRooms = new ArrayList<>(EXAM_ROOMS);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Medical Office Simulation");
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3. Exam Room Status");
            System.out.println("4. Waiting Room Status");
            System.out.println("5. Individual Status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    checkIn(scanner);
                    break;
                case 2:
                    checkOut(scanner);
                    break;
                case 3:
                    displayExamRoomStatus();
                    break;
                case 4:
                    displayWaitingRoomStatus();
                    break;
                case 5:
                    individualStatus(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the simulation.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkIn(Scanner scanner) {
        System.out.print("Enter the name of the patient to check in: ");
        String patientName = scanner.nextLine();

        if (examRooms.size() < EXAM_ROOMS) {
            examRooms.add(new Patient(patientName, 0));
            System.out.println(patientName + " has been assigned to Exam Room " + examRooms.size());
        } else {
            waitingRoom.add(new Patient(patientName, 5));
            System.out.println(patientName + " has been added to the waiting room.");
        }
    }

    private static void checkOut(Scanner scanner) {
        System.out.print("Enter the name of the patient to check out:");
        String patientName = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < examRooms.size(); i++) {
            if (examRooms.get(i).name.equals(patientName)) {
                System.out.println(patientName + " is checking out from Exam Room " + (i + 1));
                examRooms.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(patientName + " is not currently in an exam room.");
        } else {
            if (!waitingRoom.isEmpty()) {
                Patient nextPatient = waitingRoom.poll();
                examRooms.add(nextPatient);
                System.out.println("Next patient in the waiting room, " + nextPatient.name + ", has been assigned to Exam Room " + (examRooms.size()));
            }
        }
    }

    private static void displayExamRoomStatus() {
        for (int i = 0; i < examRooms.size(); i++) {
            System.out.println("Exam Room " + (i + 1) + ": " + examRooms.get(i).name);
        }
    }

    private static void displayWaitingRoomStatus() {
        if (waitingRoom.isEmpty()) {
            System.out.println("The waiting room is empty.");
        } else {
            System.out.println("Waiting Room Status:");
            for (Patient patient : waitingRoom) {
                System.out.println(patient.name + " (Wait Time: " + patient.waitTime + " minutes)");
            }
        }
    }

    private static void individualStatus(Scanner scanner) {
        System.out.print("Enter the name of the patient: ");
        String patientName = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < examRooms.size(); i++) {
            if (examRooms.get(i).name.equals(patientName)) {
                System.out.println(patientName + " is currently in Exam Room " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found) {
            for (Patient patient : waitingRoom) {
                if (patient.name.equals(patientName)) {
                    System.out.println(patientName + " is in the waiting room (Wait Time: " + patient.waitTime + " minutes)");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println(patientName + " is not currently in the office.");
        }
    }
}
