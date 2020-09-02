package com.qa.game_library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The Library with this id does not exit")
public class LibraryNotFoundException extends EntityNotFoundException {
}
