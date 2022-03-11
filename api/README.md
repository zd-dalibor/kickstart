# API

API module contains all logic to expose functionality through REST API endpoints.

Logic is separated by domains:

- com.cmc.kickstart.api.account (contains account related logic)
- com.cmc.kickstart.api.customer (contains customer related logic)
- com.cmc.kickstart.api.queue (contains queue related logic)

Domain packages should not share logic between each other. For example code from **account** domain should not call
services and repositories from **customer** domain and vice versa. If **customer** need to access account data a new
account repository should be created in **customer** domain. All shared logic should go outside domain packages
inside shared libraries (e.g **core** module). This will make easy splitting api project into separate microservices
in the feature.
