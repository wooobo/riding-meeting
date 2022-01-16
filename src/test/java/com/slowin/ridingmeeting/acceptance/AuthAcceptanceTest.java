package com.slowin.ridingmeeting.acceptance;

import static org.assertj.core.api.Assertions.assertThat;

import com.slowin.ridingmeeting.AcceptanceTest;
import com.slowin.ridingmeeting.dto.TokenRequest;
import com.slowin.ridingmeeting.dto.TokenResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class AuthAcceptanceTest extends AcceptanceTest {

    private static final String EMAIL = "email@email.com";
    private static final String PASSWORD = "password";
    private static final Integer AGE = 20;

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @DisplayName("Bearer Auth 로그인 성공")
    @Test
    void loginWithBearerAuth() {
        // given
        회원_등록되어_있음(EMAIL, PASSWORD, AGE);

        // when
        ExtractableResponse<Response> response = 로그인_요청(EMAIL, PASSWORD);

        // then
        로그인_됨(response);
    }

    private void 회원_등록되어_있음(String email, String password, Integer age) {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        params.put("age", age + "");

        RestAssured.given().log().all().
            contentType(MediaType.APPLICATION_JSON_VALUE).
            body(params).
            when().
            post("/members").
            then().
            log().all().
            extract();
    }

    private ExtractableResponse<Response> 로그인_요청(String email, String password) {
        TokenRequest tokenRequest = new TokenRequest(email, password);

        return RestAssured
            .given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(tokenRequest)
            .when().post("/login/token")
            .then().log().all()
            .extract();
    }

    public static void 로그인_됨(ExtractableResponse<Response> response) {
        TokenResponse tokenResponse = response.as(TokenResponse.class);
        assertThat(tokenResponse.getAccessToken()).isNotNull();
    }
}
