package com.petstore.constants;

public class EndPoints {
/*************FOR PET****************/
public static final String CREATE_PAT="/pet";
public static final String UPDATE_PAT="/pet";
public static final String GET_PAT_BY_ID="/pet/{petId}";
public static final String UPDATE_PAT_BY_ID="/pet/{petId}";
public static final String DELETE_PAT_BY_ID="/pet/{petId}";

/*************fOR STORE********************************/
public static final String CREATE_STORE="/store/order";
public static final String GET_STORE_BY_ID="/store/order/{orderId}";
public static final String DELETE_STORE_BY_ID="/store/order/{orderId}";

/*****************FOR USER********************************/

public static final String CREATE_USER="/user";
public static final String GET_USER_BY_USERNAME="/user/{username}";
public static final String UPDATE_USER_BY_USERNAME="/user/{username}";
public static final String DELETE_USER_BY_USERNAME="/user/{username}";

}
