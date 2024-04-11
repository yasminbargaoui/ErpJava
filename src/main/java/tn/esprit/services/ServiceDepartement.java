package tn.esprit.services;

import tn.esprit.interfaces.IServiceDepartement;
import tn.esprit.models.Departement;
import tn.esprit.utils.MyDataBase;
import java.sql.*;
import java.util.ArrayList;

public class ServiceDepartement implements IServiceDepartement<Departement>{

    private Connection cnx ;

    public ServiceDepartement(){
        cnx = MyDataBase.getInstance().getCnx();
    }
    @Override
    public void add(Departement departement) {
        //1-req sql INSERT
        //2-executer req
        String qry ="INSERT INTO `departement`(`id`, `headmaster_id`, `name`, `description`) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm =cnx.prepareStatement(qry);

            pstm.setInt(1,departement.getId());
            pstm.setInt(2,departement.getHeadmaster_id());
            pstm.setString(3,departement.getName());
            pstm.setString(4,departement.getDescription());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ArrayList<Departement> getAll() {
        //1-req SELECT
        //2-recuperation de la base de donné remplissage dans Array
        //3-retour du tableau done
        ArrayList<Departement> departements = new ArrayList<>();
        String qry ="SELECT * FROM `departement`";
        try {
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()){
                Departement d = new Departement();
               d.setId(rs.getInt(1));
               d.setName(rs.getString("name"));
                d.setDescription(rs.getString("description"));
                d.setHeadmaster_id(rs.getInt(2));

              departements.add(d);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return departements;
    }

    @Override
    public void update(Departement departement) {
// Requête SQL pour la mise à jour d'un département
        String query = "UPDATE departement SET headmaster_id = ?, name = ?, description = ? WHERE id = ?";

        try {
            PreparedStatement pstm = cnx.prepareStatement(query);

            // Paramètres pour la requête préparée
            pstm.setInt(1, departement.getHeadmaster_id());
            pstm.setString(2, departement.getName());
            pstm.setString(3, departement.getDescription());
            pstm.setInt(4, departement.getId());

            // Exécution de la mise à jour
            pstm.executeUpdate();

            System.out.println("Département mis à jour avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du département : " + e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        // Requête SQL pour supprimer un département
        String query = "DELETE FROM departement WHERE id = ?";

        try {
            PreparedStatement pstm = cnx.prepareStatement(query);

            // Paramètre pour la requête préparée
            pstm.setInt(1,id);

            // Exécution de la suppression
            int rowsAffected = pstm.executeUpdate();

            // Vérification si une ligne a été affectée (département supprimé)
            if (rowsAffected > 0) {
                System.out.println("Département supprimé avec succès !");
                return true;
            } else {
                System.out.println("Le département n'existe pas ou n'a pas pu être supprimé.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du département : " + e.getMessage());
            return false;
        }
    }
}