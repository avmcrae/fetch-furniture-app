### Running the App
To run the app locally:

In the client directory, run `yarn start`
In the backend directory, run `./gradle bootRun`

The client application will start at: http://localhost:3000


### Design/Architecture Decisions

#### Back end stack 
    Use of Java/Spring Boot
    - This was mostly for the sake of time as that is the stack that I've been working in most recently. However, in a true greenfield project, would probably consider a more modern framework and language.

#### Front end stack
    React, redux
    - Similarly, create react app was used just to spin something up quickly. Due to this, there are some extraneous things in the package.json, webpack configuration, etc. that could be cleaned up/removed.

    - For the sake of time, skipped implementing react router and am currently re-rendering the product detail page based on the redux state. However, in the long term this would probably be better as its own page (with the header pulled out into a reusable component, SearchHeader

    - Started with a bit of responsive design but didn't get too far, would have liked to expand the width of the elements to fill the phone scren width.

#### Error Handling
    - Right now if a downstream api fails, the app will log an error but still return the other results. The idea is that since we are querying multiple apis, we could still show the user some products. However, in the future, we may want to at least alert the user to the fact that they are not seeing all results and/or throw an error depending on the use case.
    
#### Testing
    - This is a big gap right now, particularly in the front end.. got a bit caught up in the exercise and ran out of time. Planned to use jest and enzyme react testing library, specific areas of focus would have been user interactions (any click actions, as well as that the correct data is rendering after the furniture api call).
    - Back end: some coverage, can be improved at the http client level. Also had hoped to add a rest assured test that would test at the integration level for the endpoint, add coverage for status code, json serialization, etc. 