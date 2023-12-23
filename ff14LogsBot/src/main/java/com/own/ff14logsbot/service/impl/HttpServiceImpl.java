package com.own.ff14logsbot.service.impl;

import com.own.ff14logsbot.mapper.HttpMapper;
import com.own.ff14logsbot.service.HttpService;
import org.springframework.stereotype.Service;


@Service
public class HttpServiceImpl implements HttpService {
    HttpMapper httpMapper = new HttpMapper();
    @Override
    public Object getHttpSourceByUrl(String url) {
        return httpMapper.getHttpSourceCodeByUrl(url);
    }
}
