package com.yehevah.oauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yehevah.oauth2.model.OAuthUser;

public interface OauthUserRepository extends JpaRepository<OAuthUser, Integer> {
    
    OAuthUser findByOAuthTypeAndOAuthId(String oAuthType, String oAuthId);

}
