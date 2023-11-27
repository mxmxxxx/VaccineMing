package org.example;
import java.time.LocalDate;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
*/


public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        Vaccine Vaccine_for_John = new Moderna();
        Vaccine Vaccine_for_Alice = new Moderna();

        Patient Alice = new Patient("Alice");
;       Patient john = new Patient("John");

        LocalDate dateOfAppointment = LocalDate.now().plusDays(5);
        Vaccine_for_John.addAppointment(dateOfAppointment, 1, "John","Southhall"); // 为 John 添加预约
        Vaccine_for_John.addAppointment(dateOfAppointment, 2, "John","Southhall");
        Vaccine_for_John.addAppointment(dateOfAppointment.plusDays(10), 2, "John","Southhall");
        Vaccine_for_John.addAppointment(dateOfAppointment.plusDays(16), 3, "John","Southhall");
        Vaccine_for_Alice.addAppointment(dateOfAppointment,1,"Alice", "Southhall");

        Alice.addVaccine(Vaccine_for_Alice);
        Alice.displayAppointments();


        john.addVaccine(Vaccine_for_John);
        john.displayAppointments();

        System.out.println("  ");
        System.out.println(Vaccine_for_John.getAppointments());

        JFrame frame = new JFrame("Appointments");
        frame.setSize(450,400);

        JPanel displayPanel = new JPanel();
        // Create a label for each patient's text

        JLabel displayLabel1 = new JLabel(john.getAppointmentsDisplay());
        JLabel displayLabel2 = new JLabel(Alice.getAppointmentsDisplay());

        displayPanel.add(displayLabel1);
        displayPanel.add(displayLabel2);

        frame.setContentPane(displayPanel);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {// Ends program if close window is clicked
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

    }

}