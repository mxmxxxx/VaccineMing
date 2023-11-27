package org.example;
import java.util.ArrayList;
import java.util.List;
public class Patient {
    private String name;
    private List<Vaccine> vaccines;

    private List<Appointment> appointmentsforpanel;
    // Constructor
    public Patient(String name) {
        this.name = name;
        this.vaccines = new ArrayList<>();
        this.appointmentsforpanel = new ArrayList<>();
    }

    public void addVaccine(Vaccine vaccine) {
        vaccines.add(vaccine);
    }

    public void displayAppointments() {
        System.out.println("Appointments for " + name + ":");
        for (Vaccine vaccine : vaccines) {
            for (Appointment appointment : vaccine.getAppointments()) {
                if (appointment.getPatientName().equals(this.name)) {
                    appointmentsforpanel.add(appointment);
                    System.out.println("Vaccine: " + vaccine.getVacName() +
                            ", Dose: " + appointment.getDoseNumber() +
                            ", Date: " + appointment.getDate() +
                            ", Location: " + vaccine.getLocation() +
                            ", Medic: " + appointment.getMedic());
                }
            }
        }
    }

    public String getAppointmentsDisplay() {
        String display = "<html>Patient: " + name + "<br>";
        for (Vaccine vaccine : vaccines) {
            for (Appointment appointment : vaccine.getAppointments()) {
                if (appointment.getPatientName().equals(this.name)) {
                    appointmentsforpanel.add(appointment);
                    display += "Vacccine: " + vaccine.getVacName() +
                            ", Dose: " + appointment.getDoseNumber() +
                            ", Date: " + appointment.getDate() +
                            ", Location: " + vaccine.getLocation() +
                            ", Medic: " + appointment.getMedic() + "<br>";
                }
            }
        }
        return display + "</html>";
    }


}
