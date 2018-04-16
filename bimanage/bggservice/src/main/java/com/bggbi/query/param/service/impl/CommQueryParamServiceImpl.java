package com.bggbi.query.param.service.impl;

import com.bggbi.query.param.service.CommQueryParamService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("CommQueryParamService")
@Scope("singleton")
public class CommQueryParamServiceImpl implements CommQueryParamService {
    @Override
    public String getYearStrFromDateTimeStr(String dateTimeStr) {
        return null;
    }
}
