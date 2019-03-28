
# Selenium-Cucumber-Docker-SeleniumGrid-Example

### Purpose
This example project was developed by Ben I'Anson @ E.V.A Professional Services Ltd
to demonstrate how to: 

* Implement Cucumber-JVM as a BDD test framework using Selenium WebDriver for browser based UI tests.


* Utilise Docker to spin up a on demand Selenium Grid network to perform cross browser tests in parallel. 

### Key Features
* __Parallel Execution:__ Both [local](https://cucumber.io/blog/announcing-cucumber-jvm-4-0-0/) and [cross-browser](https://github.com/SeleniumHQ/docker-selenium/wiki/Getting-Started-with-Docker-Compose) tests can be executed in parallel.


* __One Click Selenium Grid:__ With a single command, [Docker Compose](https://docs.docker.com/compose/overview/) is utilised to create an isolated Selenium Grid environment.


* __Dependency Injection:__ State is shared across cucumber step definitions via [PicoContainer](http://picocontainer.com/injection.html).


* __Various Gherkin Examples:__ Functionality such as Data Tables, Background Steps and Tagging are woven into Features files.


* __Various Selenium UI Tests:__ Common web page interactions plus AJAX and HTTP request methods are included.


* __Embedded Bug Screenshots:__ A screenshot is taken of failing tests and provided in the Cucumber HTML report.


* __Page Factory Design:__ The Page Object Model design pattern is extended to allow lazy initialisation of web elements via [Page Factory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory).


* __Mavenised Execution:__ Framework is invoked via [Maven](https://maven.apache.org/) which allows externalised test configuration via system properties parameters.



### Prerequisites
In order to utilise this project you need to have the following installed locally:


* ChromeDriver + GeckoDriver (both must be accessible from the system PATH)
* Chrome + Firefox
* Maven
* Java 8
* Docker
* Docker-Compose

### Usage
This project can either be run locally or via Docker.

#### Local usage:
__Setup__

There are 3 different system properties to consider before triggering a test build - However, only `Dbrowser` is mandatory.

_Dbrowser_

There are a number of different browser options:


`-Dbrowser=chrome`

`-Dbrowser=firefox`

`-Dbrowser=headless-chrome`

`-Dbrowser=headless-firefox`


_Dparallel_

Tests can be executed in parallel by providing the following property:


`-Dparallel=both`

_Dcucumber.options_

Specific groups of Cucumber features/scenarios can be executed by providing the tag name within this property - For example: 


`-Dcucumber.options="--tags @google-links"`

__Execution__

For a basic test run, navigate to `selenium-cucumber-docker-seleniumgrid` directory and run:

`mvn clean test -Dbrowser=chrome`

For an accelerated test run, execute the below:

`mvn clean test -Dbrowser=headless-chrome -Dparallel=both`

Results of test runs can be located within the following report `target/cucumber/index.html`
#### Docker:
__Execution__

To execute all tests in parallel across different browsers, navigate to `selenium-cucumber-docker-seleniumgrid` directory and run:

`docker-compose up`

Once all tests are complete, tear down your dockerized Selenium Grid network by running:

`docker-compose down`

Results of test runs can be located within `docker-chrome-target/cucumber/index.html` and `docker-firefox-target/cucumber/index.html` accordingly.

__What does docker-compose up actually do?__

See [here](https://docs.docker.com/compose/overview/) for the official overview of Docker Compose, but in terms of this project it:

1. Starts a Selenium Grid hub container.
2. Only when the hub is up (see [depends_on](https://docs.docker.com/compose/compose-file/)), starts both Chrome and Firefox node containers then connects them to the hub container via the `HUB_HOST` system variable.
3. Only when the nodes are online, starts both Chrome and Firefox Maven containers which mount the current project directory as their working directory. 
4. The Maven build then runs in the container and utilises the dockerized Selenium Grid network to execute tests.
5. Upon completion of tests, the Maven containers stop with an associated exit code (dependant on result of test build).

__What does docker-compose down actually do?__

Stops/removes containers, networks, volumes, and images created by `docker-compose up`.
