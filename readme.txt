для запуска приложения необходимо последовательно выполнить скрипты 
startDb.cmd, prepareDb.cmd и runserver.cmd, либо выполнить вручную следующие команды:
mvn exec:exec -Pdb-server
mvn -Pdb-create liquibase:update -Dliquibase.dropFirst=true
mvn -Pdb-test-migrate liquibase:update
mvn spring-boot:run


API
GET:
/info/history - Получение информации о сделках (покупка материалов и реализация продукции)

/info/resources - Информация о доступных ресурсах

/info/transactions - Все совершенные транзакции

/info/accounts - Количество денег на текущем счете

/info/units - типы единиц измерения для материалов и продукции

/info/dealtypes - типы договоров

/info/materials - используемые материалы

/info/products - производимая продукция

/test/start/{count} - запуск тестов, count - количество потоков

/test/stop - остановка тестов

POST:
/purchase				приобретение материалов. materialId - 10, 11, 12
{
	"materialId": 10,
	"value": 10
}

/buy                    продажа продукции. productId - 30, 31, 32

{
    "productId": 32,
    "value": 10
}