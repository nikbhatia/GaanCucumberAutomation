$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/gaana/features/Playlist/CreatePlaylist.feature");
formatter.feature({
  "name": "Test Scenarios for creating playlist",
  "description": "  Author: nikhil.bhatia@gaana.com",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify user is able to create playlist",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Gaana"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User login to the application",
  "keyword": "Given "
});
formatter.match({
  "location": "PlaylistStepDef.loginToGaana()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [rahul] but found [nikhil]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:453)\r\n\tat org.testng.Assert.assertEquals(Assert.java:463)\r\n\tat com.gaana.stepdefinitions.Playlist.PlaylistStepDef.loginToGaana(PlaylistStepDef.java:23)\r\n\tat ✽.User login to the application(file:src/test/java/com/gaana/features/Playlist/CreatePlaylist.feature:7)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});