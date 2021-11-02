package com.learn.spring.section12.service;

import com.learn.spring.section12.commands.UnitOfMeasureCommand;
import com.learn.spring.section12.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.learn.spring.section12.domain.UnitOfMeasure;
import com.learn.spring.section12.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    public void SetUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms() throws Exception{
        // given
        Set<UnitOfMeasure> unitOfMeasureSet = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasureSet.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasureSet.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasureSet);

        Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();

    }

}