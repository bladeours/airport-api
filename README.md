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
// TODO

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

