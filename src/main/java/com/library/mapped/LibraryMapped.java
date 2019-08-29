package com.library.mapped;

import com.library.domain.Library;
import com.library.dto.LibraryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class LibraryMapped {

    @Autowired
    private ModelMapper modelMapper;

    private LibraryDto convertToDto(Library lib) {

        return modelMapper.map(lib, LibraryDto.class);
    }
}

