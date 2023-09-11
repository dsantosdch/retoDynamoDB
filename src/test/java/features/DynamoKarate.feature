Feature: Retrieve content from a DynamoDB table

  Background:
    * def listTableClass = Java.type('aws.ListTable')
    * def checkTableExistClass = Java.type('aws.CheckTableExist')
    * def getItemClass = Java.type('aws.GetItem')
    #* def twoKeysClass = Java.type('aws.TwoKeys')
    * def table_name = 'Animal'
    * def key = 'AnimalName'
    * def keyVal = 'Dog'
    #* def sortKey = 'MovieDirector'
    #* def sortKeyVal = 'Peter Sohn'

    @ListAllTables
    Scenario: List tables from DynamoDB
      Given def list_all_tables = listTableClass.listAllTables()
      * print list_all_tables

    @CheckIfTableExist
    Scenario: Check if the table exist
      * def table_exist = checkTableExistClass.doesTableExist(table_name)
      When assert table_exist == true

    @GetItem
    Scenario: Get item from a DynamoDB table
      * def get_item = getItemClass.getDynamoDBItem(table_name, key, keyVal)
      * print get_item

      Then match get_item != null


    @CheckWrongKey
    Scenario: Get item with a wrong key value
      * def get_item = getItemClass.getDynamoDBItem(table_name, key, 'This movie does not exist')
      * print get_item
      Then assert get_item != null


    #@TableWithTwoKeys
    #Scenario: Get items from a table with partition key and sort key
    #* def two_keys = twoKeysClass.TwoDynamoDBKeys()
    #* print two_keys