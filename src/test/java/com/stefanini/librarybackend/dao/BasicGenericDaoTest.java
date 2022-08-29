package com.stefanini.librarybackend.dao;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// DONT WORK

@DataJpaTest
public class BasicGenericDaoTest {

    @Autowired
    private IGenericDao<BasicEntityTest> underTest;


    @Test
    void itShouldCreateEntityAndSaveItInDatabase() {
        // given
        BasicEntityTest entityTest = new BasicEntityTest(1, "John");

        // when
        underTest.create(entityTest);

        // then
        Boolean expectedUserExists = true;
        Boolean exists = underTest.getById(entityTest.getId()) != null;

        assertThat(expectedUserExists).isEqualTo(exists);

        underTest.removeById(entityTest.getId());
    }

}
