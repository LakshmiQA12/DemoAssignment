$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/com/bbc/features/RegisterBBC.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Lakshmi"
    },
    {
      "line": 2,
      "value": "#Summary : Register New User to sign in BBC"
    }
  ],
  "line": 4,
  "name": "Comment BBC News articles Feature",
  "description": "",
  "id": "comment-bbc-news-articles-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1733357,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "User launches BBC Site",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": ":  User is navigated to BBC News Articles Comments Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": ": User clicks on Comments",
  "keyword": "Then "
});
formatter.match({
  "location": "BackgroundAction.user_is_navigated_to_BBC_News_Articles_Comments_Page()"
});
formatter.result({
  "duration": 16930695885,
  "status": "passed"
});
formatter.match({
  "location": "BackgroundAction.user_clicks_on_Comments()"
});
formatter.result({
  "duration": 1573183491,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "User navigates to  BBC News Articles Comments Section and doing the Registration process",
  "description": "",
  "id": "comment-bbc-news-articles-feature;user-navigates-to--bbc-news-articles-comments-section-and-doing-the-registration-process",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": ": User clicks Register in BBC News Articles Comments Page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": ": User is in Registration Page",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": ": User clicks the appropriate age selection",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": ":  User starts the Registration process",
  "rows": [
    {
      "cells": [
        "Day",
        "Month",
        "Year",
        "Email",
        "Password",
        "Postcode",
        "Gender"
      ],
      "line": 16
    },
    {
      "cells": [
        "12",
        "02",
        "1988",
        "lifestyle1286@gmail.com",
        "Igateseetha@0",
        "TW18 2DZ",
        "Female"
      ],
      "line": 17
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "RegisterBBCStepDefn.user_clicks_Register_in_BBC_News_Articles_Comments_Page()"
});
formatter.result({
  "duration": 22411814001,
  "status": "passed"
});
formatter.match({
  "location": "RegisterBBCStepDefn.user_is_in_Registration_Page()"
});
formatter.result({
  "duration": 19814976,
  "status": "passed"
});
formatter.match({
  "location": "RegisterBBCStepDefn.user_clicks_the_appropriate_age_selection()"
});
formatter.result({
  "duration": 4092722856,
  "status": "passed"
});
formatter.match({
  "location": "RegisterBBCStepDefn.user_starts_the_Registration_process(DataTable)"
});
formatter.result({
  "duration": 49966504117,
  "status": "passed"
});
formatter.write("Finished Scenario");
formatter.after({
  "duration": 1799489592,
  "status": "passed"
});
});