### Running the App





### Design/Architecture Decisions

#### Back end stack 
    Use of Java/Spring Boot
    - This was mostly for the sake of time as that is the stack that I've been working in most recently. However, in a true greenfield project, would probably consider a more modern framework and language.

#### Front end stack
    Similarly, create react app was used just to spin something up quickly. Due to this, there are some extraneous things in the package.json, webpack configuration, etc. that could be cleaned up/removed.

#### Error Handling
    - Right now if a downstream api fails, the app will log an error but still return the other results. The idea is that since we are querying multiple apis, we could still show the user some products. However, in the future, we may want to at least alert the user to the fact that they are not seeing all results and/or throw an error depending on the use case.