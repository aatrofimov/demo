��� ������� ���������� ���������� ��������������� ��������� ������� 
startDb.cmd, prepareDb.cmd � runserver.cmd, ���� ��������� ������� ��������� �������:
mvn exec:exec -Pdb-server
mvn -Pdb-create liquibase:update -Dliquibase.dropFirst=true
mvn -Pdb-test-migrate liquibase:update
mvn spring-boot:run


API
GET:
/info/history - ��������� ���������� � ������� (������� ���������� � ���������� ���������)

/info/resources - ���������� � ��������� ��������

/info/transactions - ��� ����������� ����������

/info/accounts - ���������� ����� �� ������� �����

/info/units - ���� ������ ��������� ��� ���������� � ���������

/info/dealtypes - ���� ���������

/info/materials - ������������ ���������

/info/products - ������������ ���������

/test/start/{count} - ������ ������, count - ���������� �������

/test/stop - ��������� ������

POST:
/purchase				������������ ����������. materialId - 10, 11, 12
{
	"materialId": 10,
	"value": 10
}

/buy                    ������� ���������. productId - 30, 31, 32

{
    "productId": 32,
    "value": 10
}