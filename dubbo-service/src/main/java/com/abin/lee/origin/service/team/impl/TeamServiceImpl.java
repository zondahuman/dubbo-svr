package com.abin.lee.origin.service.team.impl;

import com.abin.lee.origin.service.team.TeamService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-16 上午1:14
 */
@Service(value = "teamService")
public class TeamServiceImpl implements TeamService {

    @Override
    public String get(String param) {
        return "hello "+param;
    }
}
