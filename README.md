# Airports REST API
Simple REST API that returns information about airports.

## Table of Contents
* [General info](#general-info)
* [Authorization](#authorization)
* [Technologies Used](#technologies-used)
* [Setup](#setup)
* [Endpoints](#endpoints)


## General Info
This REST API is a part of Flight Search Engine project. \
I've created this project to get information about distance between two airports, I'm using it in
[random-flight-generator](https://github.com/bladeours/random-flights-generator) project. However, this API will also
show information about country or city of airport. It uses mongoDB database to store data.


## Technologies Used
* Spring
* Java 17
* MongoDB

## Authorization
// TODO

## Setup

### install on local machine

#### install mongoDB
* check official [mongoDB documentation](https://www.mongodb.com/docs/manual/installation/)

#### import collection
* [create database](https://www.mongodb.com/basics/create-database) with name `airport`
* on Windows download [Database Tools](https://www.mongodb.com/try/download/database-tools)
* on linux install `mongo-tools`
* import json file `mongoimport --uri mongodb+srv://<USERNAME>:<PASSWORD>@<CLUSTER_NAME>/airport --collection airport --type json --file airport.json --jsonArray`

#### run API
**this app requires Java 17**
* `java -jar airportApi.jar`

### run with Docker

## docker-compose

* `git clone https://github.com/bladeours/airport-api.git`
* `docker-compose -d` 

App runs on 8081 port. I needed to use `fvilers/mongo-seed` image because 
it's the best way to import data to mongoDB in container. `mongo` container 
starts, then `mongo-seed` import data to `mongo` and shutdowns.

## endpoints

### Airport

#### Airport by code
GET: `/airport/{code}` \
Return:
* code
* city
* country
* longitude
* latitude

Here is sample output:
\
`curl localhost:8081/airport/WAW`
```
{
    "code": "WAW",
    "city": "Warsaw",
    "country": "Poland",
    "longitude": "20.96710014",
    "latitude": "52.16569901"
}
```
#### All airports

GET: `/airports` \
return all airports

### Distance

#### Distance between airports

GET: `/distance/{departure}/{arrival}` \
return distance between two airports in km \
`localhost:8081/distance/waw/aby`
```

{
    "departure": {
        "code": "WAW",
        "city": "Warsaw",
        "country": "Poland",
        "longitude": "20.96710014",
        "latitude": "52.16569901"
    },
    "arrival": {
        "code": "ABY",
        "city": "Albany, GA",
        "country": "USA",
        "longitude": "-84.19450378",
        "latitude": "31.53549957"
    },
    "distance_km": 8223
}
```

