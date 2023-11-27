package org.example;

import java.time.LocalDate;

public class Appointment {
    private LocalDate date;
    private String medic;
    private int doseNumber;
    private String patientName;

    private String location;

    public Appointment(LocalDate date, String medic, int doseNumber, String patientName, String location) {
        this.date = date;
        this.medic = medic;
        this.doseNumber = doseNumber;
        this.patientName = patientName;
        this.location = location;
    }




        // getter
    public LocalDate getDate() {
        return date;
    }

    public String getMedic() {
        return medic;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getLocation(){return location;}
}
