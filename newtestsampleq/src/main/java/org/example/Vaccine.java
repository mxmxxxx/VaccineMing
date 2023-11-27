package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Vaccine {
    private String vacName;
    private Integer numOfDose;
    private String location;
    private String[] medics;
    private List<Appointment> appointments;

    public Vaccine(String vacName, Integer numOfDose, String[] medics, String location) {
        this.vacName = vacName;
        this.numOfDose = numOfDose;
        this.location = location;
        this.medics = medics;
        this.appointments = new ArrayList<>();
    }


    public void addAppointment(LocalDate date, int doseNumber, String patientName, String location) {
        if (doseNumber <= numOfDose && location.equals(this.location) && isDateIntervalValid(date, doseNumber)) {
            String medic = medics[doseNumber - 1];
            appointments.add(new Appointment(date, medic, doseNumber, patientName, location));
        } else {
            System.out.println(patientName + location + this.vacName + doseNumber + "Invalid dose number, location, or date for this vaccine.");
        }
    }


    public boolean isDateIntervalValid(LocalDate newDate, int doseNumber) {
        for (Appointment appointment : appointments) {
            if (appointment.getDoseNumber() == doseNumber - 1) {
                long daysBetween = ChronoUnit.DAYS.between(appointment.getDate(), newDate);
                return daysBetween >= 4;
            }
        }
        return true;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public String getVacName() {
        return vacName;
    }

    public Integer getNumOfDose() {
        return numOfDose;
    }

    public String getLocation() {
        return location;
    }

    public String[] getMedics() {
        return medics;
    }
}
