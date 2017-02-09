package de.incentergy.mediminder.service;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;

@Singleton
@DataSourceDefinition(
	name = "java:app/ArzneiMobil",
	url = "jdbc:sqlite:/home/manuel/workspace/mediminder/src/main/data/20160711_AaA_ifap_DS_20160715.sqlite",
	className = "org.sqlite.SQLiteDataSource",
	isolationLevel=Connection.TRANSACTION_READ_UNCOMMITTED)
public class Datasource {

	private static final Logger log = Logger.getLogger(Datasource.class.getName());

	@PostConstruct
	public void init() {
		DataSourceDefinition datasourceDefinition = Datasource.class.getAnnotation(DataSourceDefinition.class);
		log.info("Initing datasource: " + datasourceDefinition.name() + " " + datasourceDefinition.url());
	}
}
