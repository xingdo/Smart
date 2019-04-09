package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.Eventhandle;
import com.demo.service.IEventhandleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class EventhandleServiceImpl extends BaseServiceImpl<Eventhandle> implements IEventhandleService {



}
