# {short title of solved problem and solution}

* Status: {proposed | rejected | accepted | deprecated | … | superseded by [ADR-0005](0005-example.md)} <!-- optional -->
* Deciders: {list everyone involved in the decision} <!-- optional -->
* Date: {YYYY-MM-DD when the decision was last updated} <!-- optional -->

Technical Story: {description | ticket/issue URL} <!-- optional -->

## Context and Problem Statement

{Describe the context and problem statement, e.g., in free form using two to three sentences. You may want to articulate the problem in form of a question.}

## Decision Drivers <!-- optional -->

* {driver 1, e.g., a force, facing concern, …}
* {driver 2, e.g., a force, facing concern, …}
* … <!-- numbers of drivers can vary -->

## Considered Options

* {option 1}
* {option 2}
* {option 3}
* … <!-- numbers of options can vary -->

## Decision Outcome

Chosen option: "{option 1}", because {justification. e.g., only option, which meets k.o. criterion decision driver | which resolves force {force} | … | comes out best (see below)}.

### Positive Consequences <!-- optional -->

* {e.g., improvement of quality attribute satisfaction, follow-up decisions required, …}
* …

### Negative Consequences <!-- optional -->

* {e.g., compromising quality attribute, follow-up decisions required, …}
* …

## Pros and Cons of the Options <!-- optional -->

### Rest API (Representational State Transfer Application Programming Interface) 

Une architecture qui permet d’établir une sorte de communication entre deux applications (client - serveur) 
à travers un protocole HTTP en utilisant des opérations (CRUD) telles que POST, DELETE, PUT, GET.
Example : Récupérer toues les utilisateurs : GET http://localhost:8080/api/users

* Good, car :
* C'est une architecture client-serveur où les deux sont des entités indépendantes
* C'est stateless, on ne stocke pas le les données dans le serveur
* C'est cacheable, le client peut stocker les réponses dans un cache pour améliorer la performance de l'API


### Spring JPA 

Spring Data JPA facilite la mise en œuvre de référentiels basés sur JPA. Il traite de la prise en charge améliorée des couches d'accès aux données basées sur JPA. 
Il facilite la création d'applications alimentées par Spring qui utilisent des technologies d'accès aux données.

* Good, car :
* Il prend en charge du mappage d'entités basé sur XML
* Il permet de valider des @Query requêtes annotées au démarrage
* Il permet un audit transparent de la classe de domain

### Lombok

Une bibliothèque qui se connecte automatiquement à votre éditeur ou IDE et crée des outils Java.
Il épice votre code Java comme le précise son site officiel et est publié sous la licence MIT. Le projet Lombok est un outil pour le développeur pragmatique.
Il fournit un ensemble d’annotations utiles pour éliminer une grande quantité de code standard de vos classes Java. 


exemple : @Data récupere toutes les données

* Good, car quelques caractères seulement peuvent remplacer des centaines de lignes de code.
* Le résultat est de classes Java propres, concises et faciles à gérer. 

## Links <!-- optional -->

* {Link type} {Link to ADR} <!-- example: Refined by [ADR-0005](0005-example.md) -->
* … <!-- numbers of links can vary -->
