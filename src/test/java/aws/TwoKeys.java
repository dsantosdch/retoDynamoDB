

package aws;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

import java.util.Map;

public class TwoKeys {

    public static GetItemResponse TwoDynamoDBKeys () {

        DynamoDbClient ddb = awsConnection.getDynamoClient();

        String tableName = "Movie";
        String partitionKeyName = "MovieName";
        String sortKeyName = "MovieDirector";
        String partitionKeyValue = "Elemental";
        String sortKeyValue = "Peter Sohn";

        GetItemRequest getItemRequest = GetItemRequest.builder()
                .tableName(tableName)
                .key(Map.of(
                        partitionKeyName, AttributeValue.builder().s(partitionKeyValue).build(),
                        sortKeyName, AttributeValue.builder().s(sortKeyValue).build()
                ))
                .build();

        GetItemResponse getItemResponse = ddb.getItem(getItemRequest);

        if (getItemResponse.hasItem()) {
            System.out.println("Elemento encontrado: " + getItemResponse.item());
        } else {
            System.out.println("Elemento no encontrado.");
        }

        return getItemResponse;

    }
}

