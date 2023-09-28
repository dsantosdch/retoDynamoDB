package aws;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class awsConnection {

    private static AwsBasicCredentials getSessionCredentials() {
        return AwsBasicCredentials.create("AKIAXA5GPF4BPUAM5CP3", "2r79FASz+uVBPO6FfvVckr80NWVy4HHcUFSWBUpe");
    }

    public static DynamoDbClient getDynamoClient() {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(getSessionCredentials()))
                .build();
    }

}
