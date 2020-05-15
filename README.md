# L'Antre des dragons

[![CircleCI](https://circleci.com/gh/jsmadja/antre-des-dragons.svg?style=svg)](https://circleci.com/gh/jsmadja/antre-des-dragons)

# Todo
- [X] Pages
- [X] Réaction amicale
- [X] Sorts manquants
- [X] Potions et onguents de départ
- [X] Gérer la tabatière
- [X] Gérer la sucette
- [X] Gestion Fight : instantKillWithStrikesInARow
- [X] Gestion Fight : requiredStrikesToHitInvisible
- [X] Gestion Fight : useWeaponEveryNStrike
- [X] Gestion Fight : invisibleRequiredMinimumHitRoll
- [X] Gestion Fight : maxStrikes
- [X] Dormir
- [ ] Gestion d'objets à chaque chapitre (nosferax snuff est mortel)
- [ ] Gestion d'objets pendant les combats (nosferax lollipop)
- [ ] Webservice
- [ ] Web UI
- [ ] Gérer le respawn (combat déjà fait, garder certains items? comme la cassette de Minotaure?)
- [ ] Où utiliser NIP ?
- [ ] Devoir se soigner avant de quitter le village (Trouver les chapitres qui font sortir du village)

# Deploy

- mvn clean package
- docker build -t jsmadja/antre-des-dragons-api .
- docker run -p 8080:8080 jsmadja/antre-des-dragons-api
- docker push jsmadja/antre-des-dragons-api

# Deploy AWS
- mvn clean package
- aws s3 cp target/antredesdragons-1.0-SNAPSHOT.jar  s3://antre-des-dragons
- aws elasticbeanstalk create-application-version --application-name antre-des-dragons --version-label snapshot --source-bundle S3Bucket="antre-des-dragons",S3Key="antredesdragons-1.0-SNAPSHOT.jar"
- aws elasticbeanstalk update-environment --application-name antre-des-dragons --environment-name AntreDesDragons-env --version-label snapshot
