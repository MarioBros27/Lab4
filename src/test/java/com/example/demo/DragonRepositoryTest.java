package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class DragonRepositoryTest {
	@Resource
	private DragonRepository dragonRepository;
	
	@Test
	public void givenDragon_whenSave_thenRetrieveSame() {
		Dragon dragon = new Dragon(1,"Meraxes");
		dragonRepository.save(dragon);
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		assertEquals("Meraxes", retrievedDragon.getName());
		
	}
	@Test
	public void givenDragon_whenModify_thenUpdate() {
		Dragon dragon = new Dragon(2, "Mario");
		dragonRepository.save(dragon);
		dragon.setName("Giorgie");
		dragonRepository.save(dragon);
		Dragon retrievedDragon = dragonRepository.findById(2L).orElse(null);
		assertEquals("Giorgie", retrievedDragon.getName());
		
	}
	@Test
	public void givenDragon_whenDelete_thenRemove() {
		Dragon dragon = new Dragon (3, "Kike");
		dragonRepository.save(dragon);
		dragonRepository.delete(dragon);
		
		Dragon retrievedDragon = dragonRepository.findById(3L).orElse(null);
		assertNull(retrievedDragon);
	}
}
