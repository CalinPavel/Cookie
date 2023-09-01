
# Tema 4 





## Authors

- [Pavel Calin](https://github.com/CalinPavel)


## API Reference

#### add car to the database

```http
  POST /api/v1/addCar
```

#### get car list and theme status

```http
  GET /cars
```

#### set theme status

```http
  PUT /api/dark-mode
```




## Demo

#### Add Car: /api/addCar

    {
        "name": "BMW",
        "model": "M3"
    }


#### Get car list + theme /api/v1/insertProduct

    Cookie: theme=false; Path=/; Expires=Sat, 31 Aug 2024 12:25:36 GMT;

    JSON response:
    {
        "darkMode": false,
        "currentCars": [
            {
                "id": 1,
                "name": "BMW",
                "model": "M3"
            },
            {
                "id": 2,
                "name": "BMW",
                "model": "M3"
            }
        ]
    }

    Cookie respone: theme=false; Path=/

#### Set theme status

    {
        "darkMode": "true"
    }

    Cookie respone: theme=true; Path=/
