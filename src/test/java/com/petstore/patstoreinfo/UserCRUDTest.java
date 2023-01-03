package com.petstore.patstoreinfo;

import com.petstore.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class UserCRUDTest extends TestBase {
    static int id = 8;
    static String username = "Parvati";
    static String firstName = "Krish";
    static String lastName = "Patel";

    static String email = "krish@gmail.com";
    static String password = "krish123";
    static String phone = "07896584758";
    static int userStatus = 0;
    @Steps
    UserPojoWithArraySteps userPojoWithArraySteps;
    @Steps
    UserSteps userSteps;

    @Title("This method will create  a user")
    @Test
    public void test001() {
        ValidatableResponse response = userSteps.createUser(id, username, firstName, lastName, email, password, phone, userStatus);
        response.log().all().statusCode(200);
    }

    @Title("This method will verify that user is created")
    @Test
    public void test002() {
        ValidatableResponse response = userSteps.getUserByUserName(username).statusCode(200);
        HashMap<String, Object> newUser = response.extract().path("");
        Assert.assertThat(newUser, hasValue(username));

    }

    @Title("This method will update a user and verify that user is created")
    @Test
    public void test003() {
        //username="Shankar"+username;
        lastName = lastName + "_add";
        ValidatableResponse response = userSteps.updateUserByUserName(id, username, firstName, lastName, email, password, phone, userStatus).statusCode(200);
        HashMap<String, Object> updatedUser = response.extract().path("");
        System.out.println(updatedUser);
        //  String updatedUserName= (String) updatedUser.get("id");
        //   System.out.println(updatedUserName);
        //  Assert.assertEquals( updatedUserName,username);
        // Assert.assertThat(updatedUser.hasValue(username));
        // Assert.assertTrue(updatedUser.containsValue("200"));
        Integer newId = new Integer(id);
        String id = newId.toString();
        Assert.assertTrue(updatedUser.containsValue(id));
    }

    @Title("This method will delete user")
    @Test
    public void test004() {
        ValidatableResponse response = userSteps.deleteUserWithUserName(username).statusCode(200);
        response = userSteps.getUserByUserName(username).statusCode(404);
    }
}
