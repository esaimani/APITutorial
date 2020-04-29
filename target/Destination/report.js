$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CreateNewUser.feature");
formatter.feature({
  "line": 2,
  "name": "Create New IRCTC User",
  "description": "",
  "id": "create-new-irctc-user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@IRCTC"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "As a user I want to create new user id",
  "description": "",
  "id": "create-new-irctc-user;as-a-user-i-want-to-create-new-user-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Irctc URL should be opened",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Click on Register Link",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Enter the all mandatory Informations",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User clicks on Register Button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User Created Successfully message shoud displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateNewRegisterSteps.irctcURLShouldBeOpened()"
});
formatter.result({
  "duration": 12694229819,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewRegisterSteps.clickOnRegisterLink()"
});
formatter.result({
  "duration": 50566,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewRegisterSteps.enterTheAllMandatoryInformations()"
});
formatter.result({
  "duration": 12618,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewRegisterSteps.userClicksOnRegisterButton()"
});
formatter.result({
  "duration": 12839,
  "status": "passed"
});
formatter.match({
  "location": "CreateNewRegisterSteps.userCreatedSuccessfullyMessageShoudDisplayed()"
});
formatter.result({
  "duration": 22401,
  "status": "passed"
});
});