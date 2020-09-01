package com.qa.game_library.service;


import com.qa.game_library.domain.Library;
import com.qa.game_library.dto.LibraryDTO;
import com.qa.game_library.exceptions.LibraryNotFoundException;
import com.qa.game_library.repo.LibraryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final ModelMapper mapper;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository, ModelMapper mapper) {
        this.libraryRepository = libraryRepository;
        this.mapper = mapper;
    }

    private LibraryDTO mapToDTO(Library library){
        return this.mapper.map(library, LibraryDTO.class);
    }


    public List<LibraryDTO> readAllLibraries(){
        return this.libraryRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public LibraryDTO createLibrary(Library library){
        return this.mapToDTO(this.libraryRepository.save(library));
    }

    public LibraryDTO findLibraryById(Long id){
        return this.mapToDTO(this.libraryRepository.findById(id).orElseThrow(LibraryNotFoundException::new));
    }

    public LibraryDTO updateLibrary(Long id, Library library){
        Library update = this.libraryRepository.findById(id).orElseThrow(LibraryNotFoundException::new);
        update.setName(library.getName());
        return this.mapToDTO(this.libraryRepository.save(library));
    }


    public boolean deleteLibrary(Long id){
        if(!this.libraryRepository.existsById(id)){
            throw new LibraryNotFoundException();
        }
        this.libraryRepository.deleteById(id);
        return this.libraryRepository.existsById(id);
    }

// Before DTO
//    public List<Library> readAllLibraries(){
//        return this.libraryRepository.findAll();
//    }
//    public Library createLibrary (Library library){
//        return this.libraryRepository.save(library);
//    }
//
//    public Library findLibraryById(Long id){
//        return this.libraryRepository.findById(id).orElseThrow(LibraryNotFoundException::new);
//    }
//
//    public Library updateLibrary(Long id, Library library){
//        Library update = findLibraryById(id);
//        update.setName(library.getName());
//        return this.libraryRepository.save(update);
//    }






}
