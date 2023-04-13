package client.InterfaceGraphique;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import server.models.Course;

import java.util.ArrayList;

public class Controleur{
    private Modele modele;
    private Vue vue;
    public TableView<Course> table;

    public Controleur(Modele m,TableView<Course> table){
            this.table = table;
            this.modele = m;
    }


    /**
     * Prend en argument la session reçu depuis la classe vue, met les cours dans la table et les renvois à vue.
     * @param session ; session à charger
     * @throws NullPointerException
     */
    public void charger(String session) throws NullPointerException{
        ArrayList<Course> tableCours = modele.charger(session);
        ObservableList<Course> tableCoursInfo =  FXCollections.observableArrayList();
            for (int i = 0;i<tableCours.size();i++){
               tableCoursInfo.add(new Course(modele.charger(session).get(i).getName(),
                       modele.charger(session).get(i).getCode(), session));
            }
        this.table.setItems(tableCoursInfo);
    }

    /**
     *
     * @param prenom  informations relatives de l'élève
     * @param nom
     * @param email
     * @param matricule
     * @param coursSelectionne
     * @throws Exception
     */
    public void inscrire(String prenom, String nom,String email,String matricule,Course coursSelectionne) throws Exception {
        modele.inscription(prenom,nom,email,matricule,coursSelectionne);

    }


}
