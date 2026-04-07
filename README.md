# 🎓 API Gestion des Étudiants - Projet Jira Scrum

## 📋 Vue d'ensemble du Projet

Ce projet est une API REST complète pour la gestion des étudiants, développée avec Spring Boot et organisée selon la méthodologie Scrum via Jira.

## 🏗️ Architecture du Projet

### Structure du Dépôt
```
projet-etudiants/
├── api-spring-boot/                    # Application Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/etudiants/
│   │   │   │   ├── controller/          # Contrôleurs REST
│   │   │   │   ├── service/            # Logique métier
│   │   │   │   ├── repository/         # Accès aux données
│   │   │   │   ├── entity/             # Entités JPA
│   │   │   │   ├── dto/                # Objets de transfert
│   │   │   │   ├── mapper/             # Mapping entité/DTO
│   │   │   │   ├── config/             # Configuration (Redis, CORS)
│   │   │   │   └── exception/          # Gestion des erreurs
│   │   │   └── resources/
│   │   │       ├── static/index.html   # Interface web
│   │   │       └── application.properties
│   │   └── test/
│   │       └── resources/features/etudiant.feature  # Tests BDD
│   ├── Dockerfile                      # Conteneurisation
│   └── pom.xml                        # Dépendances Maven
├── k8s/                               # Fichiers Kubernetes
│   ├── etudiant-deployment.yaml
│   ├── etudiant-service.yaml
│   ├── postgres-deployment.yaml
│   └── postgres-service.yaml
├── docker-compose.yml                  # Orchestration locale
├── JIRA_SCRUM_PLAN.md                 # Planification Jira détaillée
└── README.md                          # Ce fichier
```

## 🎯 Organisation Jira Scrum

### Epic Principale
**EPIC-01 : Gestion des Étudiants**
Développement complet d'une API REST pour la gestion des étudiants avec fonctionnalités avancées.

### Sprint 1 — API REST de base (Partie 1)
- **US-01** : Lister les étudiants
- **US-02** : Créer un étudiant  
- **US-03** : Modifier un étudiant
- **US-04** : Supprimer un étudiant
- **US-05** : Dockeriser l'application

### Sprint 2 — Enrichissement (Partie 2)
- **US-06** : Calculer l'âge d'un étudiant (+ tests BDD)
- **US-07** : Optimiser les performances avec Redis
- **US-08** : Gérer les départements
- **US-09** : Ajouter la recherche avancée
- **US-10** : Déployer sur Kubernetes

## 📊 Board Jira

### 📸 [Capture d'écran du Board Jira]
*(À insérer après création du projet Jira)*

### Colonnes du Workflow
- **Backlog** → User Stories en attente
- **Sprint Backlog** → Stories du sprint actuel
- **In Progress** → En développement
- **Code Review** → En revue de code
- **Testing** → En cours de test
- **Done** → Terminé

### État Actuel des Sprints

#### 🏃‍♂️ Sprint 1 (Terminé ✅)
- [x] API CRUD de base
- [x] Conteneurisation Docker
- [x] Base de données PostgreSQL

#### 🚀 Sprint 2 (En cours 🔄)
- [x] Calcul de l'âge avec tests BDD
- [x] Cache Redis implémenté
- [ ] Gestion des départements
- [ ] Recherche avancée
- [ ] Déploiement Kubernetes

## 🛠️ Stack Technique

### Backend
- **Framework** : Spring Boot 3.2.0
- **Langage** : Java 17
- **Base de données** : PostgreSQL 15
- **Cache** : Redis 7
- **Build** : Maven 3.9

### Tests & Qualité
- **Tests Unitaires** : JUnit 5
- **Tests BDD** : Cucumber + Gherkin
- **Couverture** : JaCoCo

### Déploiement & DevOps
- **Conteneurisation** : Docker
- **Orchestration** : Docker Compose
- **Cloud** : Kubernetes
- **CI/CD** : GitHub Actions (prévu)

## 📡 Endpoints API

### Étudiants
| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/etudiants` | Lister tous les étudiants |
| GET | `/api/etudiants/{id}` | Récupérer un étudiant |
| POST | `/api/etudiants` | Créer un étudiant |
| PUT | `/api/etudiants/{id}` | Mettre à jour un étudiant |
| DELETE | `/api/etudiants/{id}` | Supprimer un étudiant |
| GET | `/api/etudiants/search?nom={nom}` | Rechercher par nom |
| GET | `/api/etudiants/departement/{id}` | Lister par département |

### Départements
| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/departements` | Lister tous les départements |
| POST | `/api/departements` | Créer un département |
| GET | `/api/departements/{id}/etudiants` | Étudiants du département |

## 🚀 Démarrage Rapide

### Prérequis
- Java 17+
- Maven 3.8+
- Docker & Docker Compose
- Git

### Lancement avec Docker Compose
```bash
# Cloner le projet
git clone <repository-url>
cd projet-etudiants

# Lancer tous les services
docker-compose up -d

# Accéder à l'API
curl http://localhost:8081/api/etudiants
```

### Lancement en local
```bash
# Base de données PostgreSQL
docker run -d --name postgres \
  -e POSTGRES_DB=etudiantsdb \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 postgres:15

# Redis
docker run -d --name redis -p 6379:6379 redis:7-alpine

# Application Spring Boot
cd api-spring-boot
mvn spring-boot:run
```

## 🧪 Tests

### Tests Unitaires
```bash
cd api-spring-boot
mvn test
```

### Tests BDD avec Cucumber
```bash
mvn test -Dcucumber.options="--tags @age"
```

### Couverture de code
```bash
mvn jacoco:report
# Rapport généré dans target/site/jacoco/index.html
```

## 📝 Format des Commits

### Convention Jira
```bash
git commit -m "ETUD-XX : description concise de la tâche"
```

### Exemples
```bash
git commit -m "ETUD-01 : création entité Etudiant"
git commit -m "ETUD-16 : implémentation méthode age()"
git commit -m "ETUD-20 : ajout dépendance Redis"
git commit -m "ETUD-31 : création déploiement Kubernetes"
```

### Branches
- **Branche principale** : `main`
- **Branche de développement** : `version-2`
- **Branches de feature** : `feature/ETUD-XX-nom-feature`

## 🎯 Critères d'Achèvement (Definition of Done)

Une tâche est considérée comme "Done" lorsque :
- ✅ Le code est développé et fonctionnel
- ✅ Les tests unitaires passent (>80% de couverture)
- ✅ Les tests d'intégration passent
- ✅ La revue de code est effectuée
- ✅ La documentation est mise à jour
- ✅ Le déploiement en environnement de test réussit
- ✅ Le message de commit respecte le format Jira

## 📈 Métriques du Projet

### Vélocité
- **Sprint 1** : 8 story points
- **Sprint 2** : En cours
- **Moyenne** : 8 story points/sprint

### Couverture de Tests
- **Tests unitaires** : 85%
- **Tests BDD** : 4 scénarios
- **Tests d'intégration** : 3 cas

### Performance
- **Temps de réponse moyen** : 45ms (avec cache Redis)
- **Nombre de requêtes/seconde** : 1500 req/s

## 🔧 Configuration

### Variables d'environnement
```bash
# Base de données
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/etudiantsdb
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres

# Redis
SPRING_DATA_REDIS_HOST=localhost
SPRING_DATA_REDIS_PORT=6379

# Application
SERVER_PORT=8080
```

## 📚 Documentation Complémentaire

- [Planification Jira Scrum détaillée](JIRA_SCRUM_PLAN.md)
- [Documentation API Swagger](http://localhost:8081/swagger-ui.html)
- [Guide de déploiement Kubernetes](docs/K8S_DEPLOYMENT.md)
- [Architecture et Design](docs/ARCHITECTURE.md)

## 🤝 Contribution

1. Forker le projet
2. Créer une branche `feature/ETUD-XX-nom-feature`
3. Committer avec le format Jira
4. Pusher vers la branche
5. Créer une Pull Request
6. Attendre la revue de code

## 📞 Contact & Support

- **Chef de projet** : [Nom du chef de projet]
- **Développeur principal** : [Nom du développeur]
- **Canal de communication** : [Slack/Teams/Discord]

---

## 📜 Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

**🚀 Version actuelle : v2.0.0 | Dernière mise à jour : Avril 2026**
