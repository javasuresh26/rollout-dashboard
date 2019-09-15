package com.walmart.gls.rd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.gls.rd.entity.AppModuleDCDeployment;
import com.walmart.gls.rd.repo.AppModuleDCDeploymentRepo;
import com.walmart.gls.rd.utils.AuditValueUpdateUtils;


@RestController
@RequestMapping(value = "/appModuleDCDeployment")
public class AppModuleDCDeploymentController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AppModuleDCDeploymentRepo appModuleDCDeploymentRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<AppModuleDCDeployment> getAllUsersAppModuleDCDeployment() {
		LOG.info("Getting all");
		return appModuleDCDeploymentRepo.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public AppModuleDCDeployment addAppModuleDCDeployment(@RequestBody AppModuleDCDeployment entity) {
		LOG.info("Saving..");
		AuditValueUpdateUtils.updateAuditDateValue(entity);
		return appModuleDCDeploymentRepo.save(entity);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public AppModuleDCDeployment updateAppModuleDCDeployment(@RequestBody AppModuleDCDeployment entity) {
		LOG.info("updating..");
		AuditValueUpdateUtils.updateAuditDateValue(entity);
		return appModuleDCDeploymentRepo.save(entity);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteAppModuleDCDeployment(@RequestBody AppModuleDCDeployment entity) {
		LOG.info("deleting..");
		appModuleDCDeploymentRepo.delete(entity);
	}
}