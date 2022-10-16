package com.example.requestprocessingservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

@Document(indexName = "requestindex")
@Data
@Builder
public class ElasticRequest {
    @Id
    private Long id;
    @Field(type = FieldType.Text, name = "text")
    private String text;
    @Field(type = FieldType.Long, name = "modifiedDate")
    private Long modifiedDate;
    @Field(type = FieldType.Long, name = "length")
    private Long length;
}
