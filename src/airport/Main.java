package airport;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VolDAO dao = new VolDAO();

        while (true) {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Afficher tous les vols");
            System.out.println("2. Ajouter un vol");
            System.out.println("3. Modifier la destination");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            int choix = sc.nextInt();
            sc.nextLine(); // éviter les bugs de scanner

            if (choix == 1) {
                for (Vol v : dao.getAllVols()) {
                    System.out.println(v);
                }

            } else if (choix == 2) {
                System.out.print("Numéro du vol : ");
                String num = sc.nextLine();
                System.out.print("Ville de départ : ");
                String dep = sc.nextLine();
                System.out.print("Ville d’arrivée : ");
                String arr = sc.nextLine();

                Vol v = new Vol(num, dep, arr);
                dao.ajouterVol(v);

            } else if (choix == 3) {
                System.out.print("Numéro du vol : ");
                String num = sc.nextLine();
                System.out.print("Nouvelle destination : ");
                String arr = sc.nextLine();

                dao.modifierDestination(num, arr);

            } else if (choix == 4) {
                System.out.println("Fin du programme 👋");
                break;

            } else {
                System.out.println("Choix invalide !");
            }
        }

        sc.close();
    }
}
