$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/com/bbc/features/SignInAndCommentArticle.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Lakshmi"
    },
    {
      "line": 2,
      "value": "#Summary : Sign In BBC and post comments for the news article"
    }
  ],
  "line": 4,
  "name": "Sign In BBC and Post Comments on news articles Feature",
  "description": "",
  "id": "sign-in-bbc-and-post-comments-on-news-articles-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1238889,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "User navigates to BBC Site",
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
  "duration": 12545283740,
  "status": "passed"
});
formatter.match({
  "location": "BackgroundAction.user_clicks_on_Comments()"
});
formatter.result({
  "duration": 1577250935,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "User navigates to  BBC News Articles Comments Section and doing the Sign In Process",
  "description": "",
  "id": "sign-in-bbc-and-post-comments-on-news-articles-feature;user-navigates-to--bbc-news-articles-comments-section-and-doing-the-sign-in-process",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": ": User clicks Sign In on BBC News Articles Comments Page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": ": User is in SignIn Page and validates Sign In page title",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": ": User doing the Sign in process with Valid Email Id",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 13
    },
    {
      "cells": [
        "softwaretesting1286@gmail.com",
        "Igateseetha@0"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": ": User is posting comments for an article",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": ": SignOut",
  "keyword": "And "
});
formatter.match({
  "location": "SignInCommentArticleStepDefn.user_clicks_Sign_In_on_BBC_News_Articles_Comments_Page()"
});
formatter.result({
  "duration": 22237243581,
  "status": "passed"
});
formatter.match({
  "location": "SignInCommentArticleStepDefn.user_is_in_SignIn_Page_and_validates_Sign_In_page_title()"
});
formatter.result({
  "duration": 10363921,
  "status": "passed"
});
formatter.match({
  "location": "SignInCommentArticleStepDefn.user_doing_the_Sign_in_process_with_Valid_Email_Id(DataTable)"
});
formatter.result({
  "duration": 21591463138,
  "status": "passed"
});
formatter.match({
  "location": "SignInCommentArticleStepDefn.user_is_posting_comments_for_an_article()"
});
formatter.result({
  "duration": 33060476127,
  "status": "passed"
});
formatter.match({
  "location": "SignInCommentArticleStepDefn.signout()"
});
formatter.result({
  "duration": 24751035879,
  "status": "passed"
});
formatter.write("Finished Scenario");
formatter.after({
  "duration": 1560532577,
  "status": "passed"
});
});