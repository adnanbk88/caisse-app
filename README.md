# Application console de caisse
application de gestion de caisse en java
# Comment l'utilise
après avoir exécuté l'application, une liste de commandes apparaîtra avec leur description

![](/images/cap1.gif)

pour quitter le programme taper **exit** 

### les autres commandes :

#### Gestion de stoke 
* Afficher tous les articles : art all 
* Afficher un article : art show       
* Ajouter un article : art add
* Supprimer un article : art delete    

#### Gestion des commandes     

* Afficher tous les commandes: cart all
* Ajouter une commande : cart add      
* Recevoire le cash : get cash

#### Historique des commandes  

* historique : hs all

![](/images/cap2.gif)

# Construction d'application
pour créer cette application on a utiliser maven pour gérer les biblioteque comme :

* Java JDBC (connexion à db)
* de.vandermeer (affichage des tableaux)
* toutes les bibliothèques sont enregistrées dans le fichier pom.xml

## structure de projet :

![](/images/cap2.png)

* la class **App** pour démarrer l'application
* la class **DB_connection** pour connecter à la bd
* la class **CommnadHandler** pour pour exécuter les commandes tapées

![](/images/cap3.png)

dans la classe CommandHandler, chaque commande est comparée dans une instruction switch pour exécuter sa fonction équivalente:

![](/images/cap4.png)

les méthodes sont déclarées dans le dossier **controllers** par exemple la méthode **create** dans la class **ArticlesController**

![](/images/cap5.png)

la méthode **create** appelle un objet Article depuis le dossier **models**, lit les données de la console puis imprime le résultat

### la class **Aricle** :

![](/images/cap6.png)

# Commentaires ou problèmes:
Nous apprécions vraiment vos commentaires. Si vous souhaitez voir des améliorations dans l'application, vous pouvez envoyer un e-mail aux :

* akramchawki01@gmail.com
* zakaria.lagouader@gmail.com
* Zyadnih@gmail.com
