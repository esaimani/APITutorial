$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/Letcode.feature");
formatter.feature({
  "name": "Test the Letcode Site Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate Frames Concept",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Frame"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Launch the \"\u003curl\u003e\" Letcode website",
  "keyword": "Given "
});
formatter.match({
  "location": "org.steps.Letcode.launchTheLetcodeWebsite(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to workspace",
  "keyword": "And "
});
formatter.match({
  "location": "org.steps.Letcode.navigateToWorkspace()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to Frame Blog",
  "keyword": "And "
});
formatter.match({
  "location": "org.steps.Letcode.navigateToFrameBlog()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});