package com.caisse;

import java.sql.SQLException;
import java.util.Scanner;

import com.caisse.controllers.ArticleController;
import com.caisse.controllers.CartController;
import com.caisse.controllers.HistoryController;

public class CommandHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static void start() throws SQLException {
        printWelcome();
        String command = scanner.nextLine();
        while (!command.equals("exit")) {

            read(command);

            command = scanner.nextLine();
        }
        scanner.close();
    }

    public static void read(String command) throws SQLException {
        switch (command) {
            case "art add":
                ArticleController.create();
            break;
            case "art all":
                ArticleController.index();
            break;
            case "art show":
                ArticleController.show();
            break;
            case "art delete":
                ArticleController.delete();
            break;
            case "cart add":
                CartController.addToCart();
            break;
            case "cart all":
                CartController.all();
            break;
            case "get cash":
                CartController.getCash();
            break;
            case "hs all":
                HistoryController.all();
            break;
            case "help":
                showCommands();
            break;
        
            default:
                System.out.println("\nCommande non valide \n");
                System.out.println("* Pour voir toutes les commandes : help");
                System.out.println("* Pour quitter le programme : exit");
            break;
        }
    }

    public static void printWelcome() {
        System.out.println("\n##############################");
        System.out.println("##     Gestion de Caisse    ##");
        System.out.println("############################## \n");
        System.out.println("* Pour voir toutes les commandes : help");
        System.out.println("* Pour quitter le programme : exit");
    }

    public static void showCommands() {
        System.out.println("\navailable commands : \n");
        System.out.println("\n###### Gestion de stoke ###### \n");
        System.out.println("* Afficher tous les articles : art all");
        System.out.println("* Afficher un article : art show");
        System.out.println("* Ajouter un article : art add");
        System.out.println("* Supprimer un article : art delete");
        System.out.println("\n###### Gestion des commondes ###### \n");
        System.out.println("* Afficher tous les commondes: cart all");
        System.out.println("* Ajouter une commonde : cart add");
        System.out.println("* Recevoire le cash : get cash");
        System.out.println("\n###### Historique des commondes ###### \n");
        System.out.println("* historique : hs all");
    }
}
