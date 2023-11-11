> http://localhost:8080/user/sign-up

Body:

```json
{ 
  "name": "Nombre Prueba",
  "email": "goviedo@gmx.com",
  "password": "Ciglome1",
  "phones": [{
    "number": 1,
    "cityCode": 56,
    "contryCode": "CL"
  }]
}
```

Headers:

```
Accept: application/json
Content-Type: application/json
```

