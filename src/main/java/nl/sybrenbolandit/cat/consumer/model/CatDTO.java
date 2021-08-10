package nl.sybrenbolandit.cat.consumer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatDTO {
	private String name;
	private int age;
}
