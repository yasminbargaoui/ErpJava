package tn.esprit;


import tn.esprit.models.Departement;
import tn.esprit.models.Internship;
import tn.esprit.services.ServiceDepartement;
import tn.esprit.services.ServiceInternship;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
       // Departement d = new Departement(30,"jjjjj","departementIT");
        //Departement d1 = new Departement(6 ,30,"fa","departementmath");

       // ServiceDepartement sd = new ServiceDepartement();
        //sd.add(d);
      //  sd.update(d1);
        //  sd.delete(201);
      //  System.out.println(sd.getAll());



        Date satrtdate = new Date(2024 - 1900, 10-1, 15);
       Internship I = new Internship(5,"aaa","bbbbbbb","lllll","presentiel ","0","12mois",satrtdate);
        ServiceInternship sd = new ServiceInternship();
      sd.add(I);
        System.out.println(sd.getAll());
    }
}