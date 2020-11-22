package com.volvo.SpringBootApplication.graphql;


import com.volvo.SpringBootApplication.db.MongoVolvoDB;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class VehicleDataFetcher {
    MongoVolvoDB mongoVolvoDB = new MongoVolvoDB();

    public VehicleDataFetcher() throws UnknownHostException {
    }

    public DataFetcher getAllVehicles() {
        return dataFetchingEnvironment -> mongoVolvoDB.getAllVehicles();
    }

    public DataFetcher seedVehiclesfromApi() {
        return dataFetchingEnvironment -> mongoVolvoDB.seedVehiclesfromApi();
    }


}
