package com.globant.sewingmachines.sales.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;



@Configuration
public class AmazonSNSConfiguration {
   
	
	@Bean
	@Primary
	public AmazonSNSClient amazonSNSClient() {
		AWSSessionCredentials credentials = new BasicSessionCredentials("ASIAR3CAQBU3FBUMJQGP",
				"TZE4DQYYAkODpVW7w2+D8mNipGrHpYgaX5wXixer", "IQoJb3JpZ2luX2VjEMf//////////wEaCXVzLWVhc3QtMSJHMEUCICilPDxuReZe/0oKWdOFEpVD0BOmL6S+26QDdYgDf98oAiEAw5IZ757datPkN2zDbj6NyHO8kCMtcLPaiviA5lc2LCcqrAMIj///////////ARAAGgwxMjY4MzY4MDQ5MTgiDKja0ly4g3A3ZYOt+CqAA/gTFgETtNkD4oFS2WuQ7S2Lgk9mdWJPEV+rcDU987+ExE+7Mq3N2O6CjsPoz7U/whmo3wM9KQSLpJotikkxq9ju4/wQnFLyssg024SObtmjUru/7pt6EOgn5Zu0nJhPlx562j7qPFBPSGW4vOHTZX6Dvb9DXANxdNskhNzrQ+rKNWD3zP2DiN4+YfOZCsUfCqHqLZ6h5MG99U+Z+T+qH5bESPapQ7+HQiGUB8sBRzVOfZhXyLlAbELbtQNeQpzoMWasbS3rNRxtPXkG+U2eIJWNe6M1+6OXVGFo/SRdiNV0af795GPjXn2tC+WzCoINku0nFAaWhpk42/5v4l7GP7A1VbNEIPvXzcYaxNJ8FhMn/MQjtR7KOdBw1bZ9CBsIIjL+6/gSz0F/7EYAbpalmtA+SLMCPKAtmDdc87DLtIrouW59QkefmQXhNt8BfGx7gM4gf0BKUyaZ3x25URRLxDm/jaO5O5p9pedRCkjjtxd9xhluW/m7Ap+znH5YByQzLjCduM+TBjqmAVtGgUMTqK3vVAt2mC1x0CIUNR/7Iwdus9GgeB+5/XlbbrsIKVuKSk4QKlefqvhjMZVPW9bOkVSIfibni5s6AZXajVxwi5MbP5FT1xscc4O1TnyrHZKiB6xfWoT6KlJuD1Fp4j4FnlBVdiaKsdL8y8ecAtiLgS33W0Tv+uecjbE5PcSE7jQuPBs1mS6iTeov0hB7JXaLJk2wE5wSfd9GZJcEt81AnXE=//////////wEaCXVzLWVhc3QtMSJHMEUCID0lNCtqY86gJE5xPJbeBiBqH6OutQaV1ttI5PErVwUcAiEA1H88qb7/poDN2PjoYfN8nJPWNHGpFeE6PeWU6V/dFaoqowMIfxAAGgwxMjY4MzY4MDQ5MTgiDBF60hXaP+LR7zrEISqAA+pa00FGsO3Tx6dad/qoQovN7oupvXI9TlKe+Zn6QkEvgqDO1lk+1Gnp0rnFTemdxda2fe2NVhbNbq+7DIH8A5G7NGtii1nJqhPs14S9qCxXpz8YhMqTRWda5HMg+0FaiUo1OOqKORI3hD4SjcSP7f/PfbeVKnDZKRaVWiyEPcYSutNcOeB08T4X4pE+70Dip6GEx9L8+22fBLDpStrUq3NiiPFsj9+aDmfRnnKDZlqPjtPLECWCaWi7qG6sMl1BQhnnV7bYjYuosU42ISYMTW+aDpcCXBWvmEdoOBri6O+SQ7e7ZGPUCzs9v8ae27n8vzlP6+veKp8I6fZ+2HT++pvXQHJ+/KP80ubm+Vg8kooziWylmR66HPTL2U5O8DaiEdjVm2QtxQCpVtAnEoKkqFchwF1c9nDai6JK1w3QPqGKMNM5yy5jEY31Ohubq5IXeuqwVE4C76Px8aKfhf0sLhFOL2ADp5BeXvW9SzQLjPyvxKYI1UWctVLIkgLcVkFpxzCP48uTBjqmAeTnAyx9basVKl5bL22WFrUXif+IU9YiQSkAyaIP7OXDX16T2vG/boY6QgX/EVH3CYSAvLtTNEC+Obst5mmbbOISoHc2YTN2U2dC49ALGahPpN+qyI6Fu4Pv4bKm+MlKTCZQYZzBxE4VjPRE7QOBCouDrAcuCrtc8GrwxBGrLiXO1LrIwqXbE/fd820himC8yNKIIu0eMNy02GXe9f8JO+JgsOuVY3E=");
		return (AmazonSNSClient) AmazonSNSClientBuilder
				.standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(
						new AWSStaticCredentialsProvider(
								credentials))
				.build();
	}
 
}