package com.rest.api.auction;

import com.rest.api.auction.entity.User;
import com.rest.api.auction.exception.AuctionerExceptionMapper;
import com.rest.api.auction.resource.UserResource;
import com.rest.api.auction.service.UserServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AuctionerApplication extends Application<AuctionerConfiguration> {

	public static void main(String[] args) throws Exception {
		new AuctionerApplication().run(args);
	}

	private final HibernateBundle<AuctionerConfiguration> hibernateBundle = new HibernateBundle<AuctionerConfiguration>(
			User.class) {
		@Override
		public PooledDataSourceFactory getDataSourceFactory(AuctionerConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	@Override
	public void initialize(Bootstrap<AuctionerConfiguration> bootstrap) {
		bootstrap.addBundle(hibernateBundle);
	}

	@Override
	public void run(AuctionerConfiguration configuration, Environment environment) {
		final UserServiceImpl userService = new UserServiceImpl(hibernateBundle.getSessionFactory());
		environment.jersey().register(new UserResource(userService));
		environment.jersey().register(new AuctionerExceptionMapper());
	}
}
