# retoDynamoDB


1. En el archivo test/aws/awsConn.java se encuentran los campos para introducir las credenciales del usuario IAM.

2. Dentro del archivo .feature se colocan los nombres de las tablas y su partition key o una tabla que contenga tanto partition key como sort key.

3. Al final del archivo .feature se encuentra el tag llamado @TableWIthTwoKeys. Este es el tag que hace el llamado al método que contiene la partition key y la sort key.