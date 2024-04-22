package com.example.fn;

import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.bds.BdsClient;
import com.oracle.bmc.bds.model.*;
import com.oracle.bmc.bds.requests.*;
import com.oracle.bmc.bds.responses.*;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.UUID;
import java.util.Arrays;


public class AddWorkerNodesExample {
    public static void main(String[] args) throws Exception {

        /**
         * Create a default authentication provider that uses the DEFAULT
         * profile in the configuration file.
         * Refer to <see href="https://docs.cloud.oracle.com/en-us/iaas/Content/API/Concepts/sdkconfig.htm#SDK_and_CLI_Configuration_File>the public documentation</see> on how to prepare a configuration file.
         */
        final ConfigFileReader.ConfigFile configFile = ConfigFileReader.parseDefault("/home/dhruv_kach/.oci/config","DEFAULT");
        final AuthenticationDetailsProvider provider = new ConfigFileAuthenticationDetailsProvider(configFile);

        /* Create a service client */
        BdsClient client = BdsClient.builder().build(provider);

        /* Create a request and dependent object(s). */
	AddWorkerNodesDetails addWorkerNodesDetails = AddWorkerNodesDetails.builder()
		.clusterAdminPassword("Admin@123")
		.numberOfWorkerNodes(1)
		.nodeType(AddWorkerNodesDetails.NodeType.Worker)
		.shape("VM.Standard.E4.Flex")
		.blockVolumeSizeInGBs(150)
		.build();

	AddWorkerNodesRequest addWorkerNodesRequest = AddWorkerNodesRequest.builder()
		.bdsInstanceId("ocid1.bigdataservice.oc1.iad.amaaaaaapvq3y5aa6kk7ghpecaqbras6io56fxtymjpvkx6vbkuvsz7vph7q")
		.addWorkerNodesDetails(addWorkerNodesDetails)
		.build();

        /* Send request to the Client */
        AddWorkerNodesResponse response = client.addWorkerNodes(addWorkerNodesRequest);
    }

    
}
