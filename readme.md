
# News Website Microservice 

| Service | Stack |
|--|--|
| News | Java |
| Ads  | Node |
| Weather  | Python |
| Time  | Go |

<hr>

- [Git](#git)
    - [Some Git rules](#some-git-rules)
    - [Writing good commit messages](#writing-good-commit-messages)
- [Documentation](#documentation)
- [Environments](#environments)
    - [Consistent dev environments](#consistent-dev-environments)
    - [Consistent dependencies](#consistent-dependencies)
- [Testing](#testing)
- [Structure and Naming](#structure-and-naming)
- [Logging](#logging)
- [API](#api)
    - [API design](#api-design)
    - [API documentation](#api-documentation)

<a name="git"></a>
## 1. Git
<a name="some-git-rules"></a>

### 1.1 Some Git rules
There are a set of rules to keep in mind:
* Perform work in a feature/bugfix branch.
* Branch out from `develop`
* Never push into `develop` or `master` branch. Make a Pull Request.
* Update your local `develop` branch and do an interactive rebase before pushing your feature and making a Pull Request.
* Resolve potential conflicts while rebasing and before making a Pull Request.
* Delete local and remote feature branches after merging.
* Before making a Pull Request, make sure your feature branch builds successfully and passes all tests (including code style checks).
* Use .gitignore for all modules required
* commit only the relevant files  
<a name="git-workflow"></a>
### 1.2 Writing good commit messages

Having a good guideline for creating commits and sticking to it makes working with Git and collaborating with others a lot easier. Here are some rules of thumb ([source](https://chris.beams.io/posts/git-commit/#seven-rules)):

 * Separate the subject from the body with a newline between the two.
 * Limit the subject line to 50 characters and Wrap the body at 72 characters.
 * Capitalize the subject line.
 * Do not end the subject line with a period.
 * Use [imperative mood](https://en.wikipedia.org/wiki/Imperative_mood) in the subject line.
 * Use the body to explain **what** and **why** as opposed to **how**.

 <a name="documentation"></a>
## 2. Documentation


* Keep `README.md` updated as a project evolves.
* Create specs for the API's that you create, OPENAPI,Swagger 
* Comment your code. Try to make it as clear as possible what you are intending with each major section.
* If there is an open discussion on github or stackoverflow about the code or approach you're using, include the link in your comment. 
* Don't use comments as an excuse for a bad code. Keep your code clean.
* Don't use clean code as an excuse to not comment at all.
* Keep comments relevant as your code evolves.

<a name="environments"></a>
## 3. Environments


* Define separate `development`, `test` and `production` environments if needed.
* Load your deployment specific configurations from environment variables and never add them to the codebase as constants
* Use Docker image if you can.
## 4. Testing
* Have a `test` mode environment if needed.
* Write testable code, avoid side effects, extract side effects, write pure functions
* Use a static type checker 
* Run tests locally before making any pull requests to `develop`.
* Document your tests including instructions in the relevant section of your `README.md` file.
## 5. Logging


* Avoid client-side console logs in production
* Produce readable production logging. Ideally use logging libraries to be used in production mode
<a name="api"></a>
## 6. API
<a name="api-design"></a>

### 6.1 API design

We try to enforce development of sanely constructed RESTful interfaces, which team members and clients can consume simply and consistently.  
 Lack of consistency and simplicity can massively increase integration and maintenance costs. Which is why `API design` is included in this document.


* We mostly follow resource-oriented design. It has three main factors: resources, collection, and URLs.
* use kebab-case for URLs.
* use camelCase for parameters in the query string or resource fields.
* use plural kebab-case for resource names in URLs.
* Always use a plural nouns for naming a url pointing to a collection: `/users`.
* In the source code convert plurals to variables and properties with a List suffix.
* Always use a singular concept that starts with a collection and ends to an identifier:
    ```
    /students/245743
    /airports/kjfk
    ```
* Avoid URLs like this: 
    ```
    GET /blogs/:blogId/posts/:postId/summary
    ```

* Keep verbs out of your resource URLs.

* Use verbs for non-resources. In this case, your API doesn't return any resources. Instead, you execute an operation and return the result. These **are not** CRUD (create, retrieve, update, and delete) operations:

    ```
    /translate?text=Hallo
    ```

* The request body or response type is JSON then please follow `camelCase` for `JSON` property names to maintain the consistency.
* Even though a resource is a singular concept that is similar to an object instance or database record, you should not use your `table_name` for a resource name and `column_name` resource property.
* Explain the CRUD functionalities using HTTP methods:
* Response messages must be self-descriptive. A good error message response might look something like this:
    ```json
    {
        "code": 1234,
        "message" : "Something bad happened",
        "description" : "More details"
    }
    ```
    or for validation errors:
    ```json
    {
        "code" : 2314,
        "message" : "Validation Failed",
        "errors" : [
            {
                "code" : 1233,
                "field" : "email",
                "message" : "Invalid email"
            },
            {
                "code" : 1234,
                "field" : "password",
                "message" : "No password provided"
            }
          ]
    }
    ```

    _Note: Keep security exception messages as generic as possible. For instance, Instead of saying ‘incorrect password’, you can reply back saying ‘invalid username or password’ so that we don’t unknowingly inform user that username was indeed correct and only the password was incorrect._

* Use these status codes to send with your response to describe whether **everything worked**,
The **client app did something wrong** or The **API did something wrong**.
    
    _Which ones:_
    > `200 OK` response represents success for `GET`, `PUT` or `POST` requests.

    > `201 Created` for when a new instance is created. Creating a new instance, using `POST` method returns `201` status code.

    > `204 No Content` response represents success but there is no content to be sent in the response. Use it when `DELETE` operation succeeds.

    > `304 Not Modified` response is to minimize information transfer when the recipient already has cached representations.

    > `400 Bad Request` for when the request was not processed, as the server could not understand what the client is asking for.

    > `401 Unauthorized` for when the request lacks valid credentials and it should re-request with the required credentials.

    > `403 Forbidden` means the server understood the request but refuses to authorize it.

    > `404 Not Found` indicates that the requested resource was not found. 

    > `500 Internal Server Error` indicates that the request is valid, but the server could not fulfill it due to some unexpected condition.

 

<a name="api-documentation"></a>
### 6.2 API documentation
* Use API design tools, There are lots of open source tools for good documentation such as [Swagger](https://swagger.io/).


