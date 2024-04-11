package tn.esprit.services;

import tn.esprit.interfaces.IServiceInternship;
import tn.esprit.models.Departement;
import tn.esprit.models.Internship;
import tn.esprit.utils.MyDataBase;
import java.sql.*;
import java.util.ArrayList;
public class ServiceInternship implements IServiceInternship<Internship> {
    private Connection cnx;

    public ServiceInternship() {
        cnx = MyDataBase.getInstance().getCnx();
    }

    @Override
    public void add(Internship internship) {
        //1-req sql INSERT
        //2-executer req
        String qry = "INSERT INTO `internship` (`id`, `departement_id`, `title`, `description`, `technology`, `typeinternship`, `state`, `startdate`, `period`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);

            pstm.setInt(1, internship.getId());
            pstm.setInt(2, internship.getDepartement_id());
            pstm.setString(3, internship.getTitle());
            pstm.setString(4, internship.getDescription());
            pstm.setString(5, internship.getTechnology());
            pstm.setString(6, internship.getTypeinternship());
            pstm.setString(7, internship.getState());
            pstm.setDate(8, internship.getStartdate());
            pstm.setString(9, internship.getPeriod());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ArrayList<Internship> getAll() {
        //1-req SELECT
        //2-recuperation de la base de donné remplissage dans Array
        //3-retour du tableau done
        ArrayList<Internship> internships = new ArrayList<>();
        String qry = "SELECT * FROM `internship`";
        try {
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()) {
                Internship i = new Internship();
                i.setId(rs.getInt(1));
                i.setDepartement_id(rs.getInt(2));
                i.setTitle(rs.getString("title"));
                i.setDescription(rs.getString("description"));
                i.setTechnology(rs.getString("technology"));
                i.setTypeinternship(rs.getString("typeinternship"));
               // i.setState(rs.getString("state"));
               // i.setStartdate(rs.getDate(""));
                i.setPeriod(rs.getString("period"));

                internships.add(i);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return internships;
    }

    @Override
    public void update(Internship internship) {
        // Requête SQL pour la mise à jour d'un stage
        String query = "UPDATE internship SET departement_id = ?, title = ?, description = ?, technology = ?, typeinternship = ?, state = ?, startdate = ?, period = ? WHERE id = ?";

        try {
            PreparedStatement pstm = cnx.prepareStatement(query);

            // Paramètres pour la requête préparée
            pstm.setInt(1, internship.getDepartement_id());
            pstm.setString(2, internship.getTitle());
            pstm.setString(3, internship.getDescription());
            pstm.setString(4, internship.getTechnology());
            pstm.setString(5, internship.getTypeinternship());
            pstm.setString(6, internship.getState());
            pstm.setDate(7, internship.getStartdate());
            pstm.setString(8, internship.getPeriod());
            pstm.setInt(9, internship.getId());

            // Exécution de la mise à jour
            pstm.executeUpdate();

            System.out.println("Stage mis à jour avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du stage : " + e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        // Requête SQL pour supprimer un stage
        String query = "DELETE FROM internship WHERE id = ?";

        try {
            PreparedStatement pstm = cnx.prepareStatement(query);

            // Paramètre pour la requête préparée
            pstm.setInt(1, id);

            // Exécution de la suppression
            int rowsAffected = pstm.executeUpdate();

            // Vérification si une ligne a été affectée (stage supprimé)
            if (rowsAffected > 0) {
                System.out.println("Stage supprimé avec succès !");
                return true;
            } else {
                System.out.println("Le stage n'existe pas ou n'a pas pu être supprimé.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du stage : " + e.getMessage());
            return false;
        }

    }
}
