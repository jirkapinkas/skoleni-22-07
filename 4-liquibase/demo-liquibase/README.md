Pred spustenim aplikace je nutne zavolat:

    # spusti postgres
    docker compose up -d
    # vytvori schema "mydb"
    docker exec -it demo-liquibase-db-1 createdb mydb -U postgres

Spring Boot pri startu automaticky aplikuje vsechny changesety, ktere jsou definovane nebo referencovane v souboru `db.changelog-master.yaml`

Rollback posledniho changesetu (tohle vyzaduje konfiguraci v pom.xml): 

    mvn liquibase:rollback -Dliquibase.rollbackCount=1

NEBO:

    mvn liquibase:rollback -Dliquibase.rollbackCount=1 -Dliquibase.url=jdbc:postgresql://localhost:5432/mydb -Dliquibase.changeLogFile=src/main/resources/db/changelog/db.changelog-master.yaml -Dliquibase.username=postgres -Dliquibase.password=admin

NEBO:

    mvn liquibase:rollback -Dliquibase.rollbackCount=1 -Dliquibase.propertyFile=liquibase.properties
