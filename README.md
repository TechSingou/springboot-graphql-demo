# springboot-graphql-demo

Un Simple api graphql de gestion d'une catalogue de produit developpé avec spring boot, MYSQL intégré avec docker

L'api comporte 07 endpoints qui permettent :
- Lister les produits de la catalogue
- Lister les categories
- Rechercher un produit via son ID
- Mettre à jour un produit
- Supprimer un produit via son ID
- Ajouter un produit
- Rechercher une category via son ID

Envie de tester le projet dans un environnement isolé?

- ==> Cloner le repo
git clone https://github.com/TechSingou/springboot-graphql-demo.git
- ==> Se déplacer sans le repertoire du projet
cd /springboot-graphql-demo
- ==> Démarrer l'application
docker-compose up
- ==> Ouvrer votre navigateur et acceder à:
http://localhost:8080/graphiql

Amusez-vous !!! :)

NB : Merci de ne pas oublier d'installer Docker sur votre machine en premier lieu .