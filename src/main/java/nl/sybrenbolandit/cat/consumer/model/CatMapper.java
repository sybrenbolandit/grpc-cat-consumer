package nl.sybrenbolandit.cat.consumer.model;

import nl.sybrenbolandit.proto.Cat;

import javax.inject.Singleton;

@Singleton
public class CatMapper {

	public CatDTO map(Cat cat) {
		return CatDTO.builder()
						.name(cat.getName())
						.age(cat.getAge())
						.build();
	}
}
