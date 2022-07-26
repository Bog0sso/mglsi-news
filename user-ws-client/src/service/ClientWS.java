package service;

import java.util.List;
import java.util.Scanner;

import com.utilisateur.service.SQLException_Exception;
import com.utilisateur.service.Utilisateur;
import com.utilisateur.service.UtilisateurServiceService;
import com.utilisateur.service.UtilisateurWS;


public class ClientWS {
    static Scanner sc = new Scanner(System.in);
    static UtilisateurWS stub = new UtilisateurServiceService().getUtilisateurWSPort();

    public static void main(String[] args) throws SQLException_Exception  {
        affiche();

    }

    public static void affiche() throws SQLException_Exception {
        System.out.println();
        System.out.println("Que souhaitez vous faire?");
        System.out.println("1. Ajouter un(e) utilisateur(e).");
        System.out.println("2. Lister tous les utilisateurs.");
        System.out.println("3. Modifier un utilisateur.");
        System.out.println("4. Supprimer un utilisateur.");
        System.out.println("5. S'authentifier");
        System.out.println("0. Quitter le programme.");
        System.out.println();
        while (choix() != 0) {
            affiche();
        }
        
    }

    public static int choix() throws SQLException_Exception {
        System.out.println("Veuillez effectuer votre choix : ");
        int choix = sc.nextInt();
        if (choix == 1) {
            // créer
            System.out.println("Entrez le login:");
            String login = sc.next();
            System.out.println("Entrez le password:");
            String password = sc.next();
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setLogin(login);
            utilisateur.setPassword(password);
            stub.addUtilisateur(login, password);
            System.out.println("------------------------");
            System.out.println("L'utilisateur(e) "+login +" " + password+ " a bien été ajouté à la base de donnée.");
            System.out.println("------------------------");

        } else if (choix == 2) {
            // lister
            List<Utilisateur> listeUtilisateurs = stub.getAllUtilisateurs();
            for (Utilisateur utilisateur : listeUtilisateurs) {
                System.out.println("------------------------");
                System.out.println(utilisateur.getId());
                System.out.println(utilisateur.getLogin());
                System.out.println(utilisateur.getPassword());
                System.out.println("------------------------");
            }
        } else if (choix == 3) {
            //modifier
            System.out.println("Entrez l'identifiant:");
            int id = sc.nextInt();
            System.out.println("Entrez le login:");
            String login = sc.next();
            System.out.println("Entrez le password:");
            String password = sc.next();
            stub.updateUtilisateur(id, login, password);
            System.out.println("------------------------");
            System.out.println("L'utilisateur(e) "+login +" " + password+ " a bien été modifié dans la base de donnée.");
            System.out.println("------------------------");
        } else if (choix == 4) {
            // supprimer
            System.out.println("Entrez l'identifiant de l'utilisateur à supprimer:");
            int _id = sc.nextInt();
            stub.deleteUtilisateur(_id);
            System.out.println("L'utilisateur avec l'id "+_id+ " a bien été supprimé.");


        }else if(choix ==5){
            System.out.println("Entrez le login:");
            String login = sc.next();
            System.out.println("Entrez le password:");
            String password = sc.next();
            System.out.println("\nAuthenticated: " + stub.authentifier(login, password));

        }
        else if (choix == 0) {
            // exit programm
            System.exit(0);
        }
        return choix;

    }
}
