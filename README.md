thunder collection:

{
    "client": "Thunder Client",
    "collectionName": "hamburgueria-quarkus",
    "dateExported": "2023-08-27T21:48:37.521Z",
    "version": "1.1",
    "folders": [],
    "requests": [
        {
            "_id": "c57d9221-2b9a-40e2-ba88-af0ee65fd26a",
            "colId": "a9937e71-7bd1-4265-9b2e-3ee140d958e1",
            "containerId": "",
            "name": "localhost:8080/cliente",
            "url": "localhost:8080/cliente?email=teste@teste.com&cpf=4321",
            "method": "GET",
            "sortNum": 10000,
            "created": "2023-08-27T17:29:10.079Z",
            "modified": "2023-08-27T20:18:45.351Z",
            "headers": [],
            "params": [
                {
                    "name": "email",
                    "value": "teste@teste.com",
                    "isPath": false
                },
                {
                    "name": "cpf",
                    "value": "4321",
                    "isPath": false
                }
            ],
            "tests": []
        },
        {
            "_id": "4ad1654e-9085-4358-98df-108541ead5f1",
            "colId": "a9937e71-7bd1-4265-9b2e-3ee140d958e1",
            "containerId": "",
            "name": "localhost:8080/cliente",
            "url": "localhost:8080/cliente",
            "method": "POST",
            "sortNum": 30000,
            "created": "2023-08-27T17:29:31.318Z",
            "modified": "2023-08-27T19:57:02.605Z",
            "headers": [],
            "params": [],
            "body": {
                "type": "json",
                "raw": "[\n  {\n    \"id\": 1,\n    \"email\": \"teste@teste.com\",\n    \"nome\": \"teste123\",\n    \"senha\": \"teste\",\n    \"telefone\": \"1234\",\n    \"cpf\": \"1234\"\n  }\n]",
                "form": []
            },
            "tests": []
        },
        {
            "_id": "2248217b-b1fb-4ec8-b6a4-5b192e7ebe09",
            "colId": "a9937e71-7bd1-4265-9b2e-3ee140d958e1",
            "containerId": "",
            "name": "cpf",
            "url": "localhost:8080/cliente?cpf=4321",
            "method": "GET",
            "sortNum": 40000,
            "created": "2023-08-27T17:33:42.640Z",
            "modified": "2023-08-27T19:48:59.918Z",
            "headers": [],
            "params": [
                {
                    "name": "cpf",
                    "value": "4321",
                    "isPath": false
                }
            ],
            "tests": []
        },
        {
            "_id": "0258314a-81ee-4393-8df9-00a92ed22b95",
            "colId": "a9937e71-7bd1-4265-9b2e-3ee140d958e1",
            "containerId": "",
            "name": "get pedido",
            "url": "localhost:8080/pedido/relatorio?data=2023-08-28",
            "method": "GET",
            "sortNum": 50000,
            "created": "2023-08-27T19:03:57.933Z",
            "modified": "2023-08-27T21:17:04.048Z",
            "headers": [],
            "params": [
                {
                    "name": "data",
                    "value": "2023-08-28",
                    "isPath": false
                }
            ],
            "tests": []
        },
        {
            "_id": "fe2c9d0f-c873-46c9-b7bc-d4770bfc5afe",
            "colId": "a9937e71-7bd1-4265-9b2e-3ee140d958e1",
            "containerId": "",
            "name": "get pedido Copy",
            "url": "localhost:8080/pedido",
            "method": "POST",
            "sortNum": 60000,
            "created": "2023-08-27T19:43:21.362Z",
            "modified": "2023-08-27T20:00:37.835Z",
            "headers": [],
            "params": [],
            "body": {
                "type": "json",
                "raw": "[\n  {\n    \"id\": 1,\n    \"cliente\": {\n      \"id\": 1,\n      \"cpf\": \"1234\",\n      \"email\": \"teste@teste.com\",\n      \"nome\": \"teste123\",\n      \"senha\": \"teste\",\n      \"telefone\": \"1234\"\n    },\n    \"data\": \"2023-08-27\",\n    \"produtosPedido\": [\n      {\n        \"id\": 1,\n        \"nome\": \"Hambúrguer de Risoto de Camarão\",\n        \"preco\": 35.0\n      },\n      {\n        \"id\": 2,\n        \"nome\": \"Hambúrguer de Macarrão à Bolonhesa\",\n        \"preco\": 20.0\n      },\n      {\n        \"id\": 3,\n        \"nome\": \"Hambúrguer de Fettuccine ao Molho Alfredo\",\n        \"preco\": 30.0\n      }\n    ],\n    \"status\": \"ENTREGUE\"\n  }\n]",
                "form": []
            },
            "tests": []
        }
    ]
}
