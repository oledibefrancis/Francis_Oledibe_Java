## Module Challenge: Record Store API Secured

### Overview

In this challenge, I refactored the provided Record Store API to enforce authentication via OAuth.

### Goals

The goal of this challenge is to reinforce my knowledge of OAuth.

Specifically, I did the following:

1. Created an Authorization Server that facilitated authentication via OAuth.

2. Refactored the Record Store API application to enforce authentication accordingly.

### Instructions

1. Created a new local folder named `M9-Challenge-Francis-Oledibe`.  Add all the code for this challenge to this folder.

2. Used the techniques described in class, created an Authorization Server which will facilitate OAuth authentication for the provided Record Store API application.

3. For the Authorization server, created a few user accounts for testing purposes.

4. Using the techniques described in class, refactored the provided Record Store API starter project such that the controller enforces authentication via OAuth for all Record Store API routes.

5. Using Insomnia, verify the following:

- An unauthenticated client is unable to access any of the API routes.

- An authenticated OAuth client is able to access all routes, including `GET`, `PUT` and `DELETE` operations.


