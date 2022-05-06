package com.globant.sewingmachines.configservice;

        import static java.text.MessageFormat.format;

        import java.io.BufferedOutputStream;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.security.KeyPair;
        import java.security.KeyPairGenerator;
        import java.security.SecureRandom;
        import java.util.List;
        import java.util.UUID;

        import com.amazonaws.auth.*;
        import com.amazonaws.services.s3.AmazonS3ClientBuilder;
        import org.apache.commons.logging.Log;
        import org.apache.commons.logging.LogFactory;

        import com.amazonaws.regions.Region;
        import com.amazonaws.regions.Regions;
        import com.amazonaws.services.s3.AmazonS3;
        import com.amazonaws.services.s3.AmazonS3Client;
        import com.amazonaws.services.s3.AmazonS3EncryptionClient;
        import com.amazonaws.services.s3.model.Bucket;
        import com.amazonaws.services.s3.model.EncryptionMaterials;
        import com.amazonaws.services.s3.model.ListObjectsRequest;
        import com.amazonaws.services.s3.model.ObjectListing;
        import com.amazonaws.services.s3.model.ObjectMetadata;
        import com.amazonaws.services.s3.model.ProgressEvent;
        import com.amazonaws.services.s3.model.ProgressListener;
        import com.amazonaws.services.s3.model.PutObjectResult;
        import com.amazonaws.services.s3.model.S3ObjectSummary;
        import com.amazonaws.services.s3.transfer.TransferManager;
        import com.amazonaws.services.s3.transfer.Upload;
        import com.amazonaws.util.StringInputStream;
import org.junit.jupiter.api.Test;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;

public class AwsTest {

    public static final Log log = LogFactory.getLog(AwsTest.class);

    private static final Regions REGION = Regions.US_EAST_1;

    private static String bucketName;
    private static String objectKey;


    public static final AWSCredentials cred =
            new ClasspathPropertiesFileCredentialsProvider("AwsCredentials.properties").getCredentials();



    @Test
    public void checkListObjects() throws Exception {
        AmazonS3 client = AmazonS3ClientBuilder.standard()
                .withCredentials(new InstanceProfileCredentialsProvider(false))
                .withRegion(Regions.US_EAST_1)
                .build();
        //client.setRegion(Region.getRegion(REGION));

//        AWSSessionCredentials credentials = new BasicSessionCredentials("ASIAR3CAQBU3E74QROPG",
//                "70K6zYS5MF589ZTGThnmY4rL0msPLafxs/u9VriV","");
//        AmazonS3 client = AmazonS3ClientBuilder
//                .standard()
//                .withRegion(Regions.US_EAST_1)
//                .withCredentials(
//                        new AWSStaticCredentialsProvider(
//                                credentials))
//                .build();

        ListObjectsRequest request = new ListObjectsRequest()
                .withBucketName("s3-machines-pod2");

        ObjectListing objList = client.listObjects(request);

        for (S3ObjectSummary summary : objList.getObjectSummaries()) {
            log.debug(format("Object found under the {0} key.", summary.getKey()));
        }
    }




}