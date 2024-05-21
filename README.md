README del Progetto Pirati!

Introduzione
Benvenuto nel README della nostra Web App! Questo documento sarà  una guida per l'avviamento del nostro progetto collegato a un databse.

Installazione: Segui questi passaggi per installare la nostra Web App sul tuo ambiente:
Clona il repository dal nostro GitHub: git clone 
https://github.com/Difroy/project-work
Eclipse: Apri "File" da menu e seleziona "Open Projects for File System" poi vai su Directory e seleziona la cartella del progetto che hai clonato.

Configurazione del Database: 
La nostra Web App è collegata a un database relazionale realizzato con XAMPP e gestito da phpMyAdmin. Per configurare correttamente il database, segui questi passaggi:
Accedi a phpMyAdmin con i tuoi dati di accesso.
Crea un nuovo database chiamato pirata
Importa il file pirata.sql che trovi nel repository

Utilizzo:
Per utilizzare la nostra Web App, segui questi passaggi.
Apri il progetto clonato e accedi su src/main/resources.
Assicurati di avere il file application.properties con il seguente contenuto: 
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/ecommerce_pirata
spring.datasource.username=root
spring.datasource.password=
spring.jpa.show-sql=true

Questa riga va inserita solo per chi sua Mac
spring.jpa.properties.hibernate.dialect = org.hibernate.MySQLDialect
*Controlla nella console che non ci siano progetti avviati*

Accedi su src/main/java e aprire il package "projectWork", cliccare il tasto destro del mouse su ProjectWorkApplication.java e lasciare il curso su Run As, dopodichè selezionare Java Application.
Quando dalla finestra della console vedi che il programma si è avviato senza errori, potrai andare su Chrome e digitare localhost:8080 per andare sulla pagina principale.

Copyright 2024:
Alessandro Catapano, Elisabetta Palumbo, Froylan Lamus, Noemi Misurelli, Patrizia Solla e Simone Cantella.

Grazie per aver scelto la nostra Web App!

Questo documento è soggetto a modifiche. Si prega di consultare la versione più recente nel repository GitHub.
