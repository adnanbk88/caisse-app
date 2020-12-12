# Cashbox console application
cash management application in java

# How to use it
after running the application, a list of commands will appear with their description

![](/images/cap1.gif)

to quit the program type **exit** 

### Other commands :

#### Stoke management 
* Show all articles : art all 
* Show one article : art show       
* Add an article : art add
* Delete an article : art delete    

#### Orders management     

* Show all orders: cart all
* Add an order : cart add      
* Get cash : get cash

#### Orders history 

* Orders history : hs all

![](/images/cap2.gif)

# How it's made
To create this application we've use maven to manage the application's dependencies like:

* Java JDBC (connection to DB)
* de.vandermeer (to display the tables)
* all dependencies are saved in the pom.xml file

## Project structure :

![](/images/cap2.png)

* the **App** class to start the application
* the **DB_connection** class to connect to the DB
* the **CommnadHandler** class to execute the typed commands

![](/images/cap3.png)

In the CommandHandler class, each command is compared in a switch statement to perform its equivalent method:

![](/images/cap4.png)

The methods are declared in the **controllers** folder for example the **create** method in the **ArticlesController** class

![](/images/cap5.png)

The **create** method calls an Article object from the **models** folder, reads the data from the console and then prints the result

### The **Aricle** class :

![](/images/cap6.png)

# Comments or issues:
We really appreciate your feedback. If you want to see any improvements in the app, you can send an email to:

* akramchawki01@gmail.com
* zakaria.lagouader@gmail.com
* Zyadnih@gmail.com
