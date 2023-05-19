package com.inventory.eris.Security.JWT.blacklist;

import org.springframework.stereotype.Service;

@Service

public record BlacklistService(BlacklistDaoImp blacklistDaoImp) {

    public Boolean isAccessTokenBlackListed(String accessToken) {
        return blacklistDaoImp.isAccessTokenBlackListed(accessToken);
    }

    public void blackListToken(String accessToken) {
        blacklistDaoImp.blackListToken(accessToken);
    }
}
