[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/hAE1BRhd)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19420634)

# 🎮 Application Web de Gestion de Tournois E-Sport

Cette application web permet de gérer des tournois e-sport en ligne via une interface d’administration complète. Elle est développée avec **Spring Boot**, **Thymeleaf** et **MySQL**.

---

## ✨ Fonctionnalités Admin

- Connexion/Déconnexion de l’administrateur
- Inscription et gestion des utilisateurs
- Opérations CRUD sur :
  - **Utilisateurs** (recherche par email)
  - **Joueurs** (recherche par nom, filtre par nationalité)
  - **Jeux** (recherche par nom, filtre par plateforme)
  - **Équipes** (recherche par nom, filtre par pays)
  - **Matchs** (filtre par tournoi)
  - **Tournois** (recherche par nom, filtre par jeu)
- Upload d’image pour :
  - Joueurs
  - Équipes
  - Jeux
  - Tournois
- Tableau de bord administrateur
- Page 404 personnalisée

---

🧑‍💻 Fonctionnalités côté utilisateur
Page d’accueil dynamique pour les utilisateurs (/index)

Affichage des équipes dans un carrousel avec logo et nom

Affichage dynamique des joueurs  avec photo, nom et réseaux sociaux

Page des équipes (/team)

Liste de toutes les équipes enregistrées

Cartes de taille uniforme avec image, nom et bouton d'information

Page des matchs (/match)

Affichage de tous les matchs triés par date croissante

Affichage dynamique avec logos des équipes, noms, score ou heure et lien vers le stream

Page détails tournoi (/tournament/details)

Affiche tous les matchs d’un tournoi spécifique triés par date

Affiche toutes les équipes du tournoi sous forme de cartes responsives

---


## 🛠️ Technologies utilisées

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap

---

## 👤 Identifiants par défaut (Admin)

- **Nom d'utilisateur :** `admin`
- **Mot de passe :** `admin`

> Tu peux modifier cela directement dans la base de données.

---

## 🗂️ Structure du projet

```
src/
 ├─ main/
 │   ├─ java/com/esport/tournamentapp
 │   │   ├─ controller/
 │   │   ├─ model/
 │   │   ├─ repository/
 │   │   ├─ config/
 │   ├─ resources/
 │   │   ├─ templates/admin/
 │   │   ├─ static/images/
 │   │   └─ application.properties
```

---

## ⚙️ Instructions d'installation

### 1. Cloner le projet

```bash
git clone https://github.com/iir-24-25/projet-devops-g5-xg5_g5.git
cd projet-devops-g5-xg5_g5
```

### 2. Créer la base de données

Créer une base MySQL nommée `esport_db` et importer le dump SQL situé dans le dossier DataBase.

Sinon, la base sera générée automatiquement par JPA. Ajoute manuellement l’admin par défaut :

```sql
INSERT INTO admins (username, password) VALUES ('admin', 'admin');
```

### 3. Configurer `application.properties`

Dans `src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/esportdb
spring.datasource.username=root
spring.datasource.password=ton_mot_de_passe

spring.jpa.hibernate.ddl-auto=update
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
```

### 4. Lancer l’application

Depuis l’IDE ou via la ligne de commande :

```bash
./mvnw spring-boot:run
```

Ou compiler et exécuter le JAR :

```bash
./mvnw clean package
java -jar target/tournamentapp-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Accès à l’application

Ouvrir un navigateur à l’adresse suivante :

```
http://localhost:8080/login
```

---

## 📁 Dossier d’upload des images

Les images seront enregistrées ici :

```
/uploads/images/
```

Ce dossier est créé automatiquement s’il n’existe pas.

---

## 🔐 Sécurité

- L’interface admin est protégée par une authentification session.
- Le contrôle d'accès est géré via un **interceptor personnalisé** dans `config/AdminInterceptor.java`.
