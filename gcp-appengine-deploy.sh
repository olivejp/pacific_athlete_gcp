#bin!/bin/bash

## Upgrade de la version
sh gcp-upgrade-version.sh

## Récupération de la version dans une variable
VERSION_FILE="gcp-version.txt"
version=$(cat "$VERSION_FILE")

## Appel Maven pour
## - Nettoyer le projet
## - Packager
## - Déployer sur AppEngine
mvn clean package appengine:deploy -DskipTests -Dapp.deploy.projectId=fitness-449702 -Dapp.deploy.version="$version" -Dapp.deploy.promote=True -e -X
