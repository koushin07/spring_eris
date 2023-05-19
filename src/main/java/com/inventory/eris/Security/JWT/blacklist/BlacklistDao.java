package com.inventory.eris.Security.JWT.blacklist;

public interface BlacklistDao {

    Boolean isAccessTokenBlackListed(String accessToken);

    Boolean isRefreshTokenBlackListed(String refreshToken);

    void blackListToken(String accessToken);

    void blackListRefreshToken(String refreshToken, String accesstoken);
}
